package main.java.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.google.gson.JsonObject;

import main.java.GlobalVal.ResultValue;
import main.java.HibernateUtil.HibernateUtil;
import main.java.databaseModel.Restaurant;
import main.java.databaseModel.RestaurantRating;
import main.java.databaseModel.UserData;
import main.java.jsonModel.Request.NearbyRestaurantRequest;
import main.java.jsonModel.Request.RegisterRestaurantRequest;
import main.java.jsonModel.Request.RestaurantDetailRequest;
import main.java.jsonModel.Request.RestaurantListByUserRequest;
import main.java.jsonModel.Request.RestaurantRatingByUserRequest;
import main.java.jsonModel.Request.RestaurantRatingRequest;
import main.java.jsonModel.Request.UpdateRestaurantRequest;
import main.java.jsonModel.Request.ConfirmRestaurantRequest;
import main.java.jsonModel.Request.DeleteRestaurantRequest;
import main.java.jsonModel.Request.InsertRestaurantRatingRequest;
import main.java.jsonModel.Response.ConfirmRestaurantResponse;
import main.java.jsonModel.Response.DeleteRestaurantResponse;
import main.java.jsonModel.Response.InsertRestaurantRatingResponse;
import main.java.jsonModel.Response.NearbyRestaurantResponse;
import main.java.jsonModel.Response.RegisterRestaurantResponse;
import main.java.jsonModel.Response.RestaurantDetailResponse;
import main.java.jsonModel.Response.RestaurantListByUserResponse;
import main.java.jsonModel.Response.RestaurantRatingByUserResponse;
import main.java.jsonModel.Response.RestaurantRatingResponse;
import main.java.jsonModel.Response.UpdateRestaurantResponse;
import main.java.jsonModel.detailModel.FoodJson;
import main.java.jsonModel.detailModel.RestaurantCommentJson;
import main.java.jsonModel.detailModel.RestaurantJson;
import main.java.jsonModel.detailModel.RestaurantRatingDetailJson;
import main.java.jsonModel.detailModel.RestaurantRatingJson;
import main.java.jsonModel.detailModel.ResultResponse;

public class RestaurantManagement {
	ResultValue resultValue = new ResultValue();
	
	public List<RestaurantJson> getRestaurantByUser(int userId){
		List<RestaurantJson> result = new ArrayList<RestaurantJson>();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria query = session.createCriteria(Restaurant.class);
			
			query.add(Restrictions.eq("userId", userId));
			query.add(Restrictions.eq("active", 1));
			
			List<Restaurant> restaurant = query.list();
			List<RestaurantJson> list = new ArrayList<RestaurantJson>();
			for(int i=0; i<restaurant.size(); i++) {
				RestaurantJson insert = new RestaurantJson();
				insert.setFromQuery(restaurant.get(i));
				list.add(insert);
			}
			
			result = list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<RestaurantJson> getRestaurantByAdmin(){
		List<RestaurantJson> result = new ArrayList<RestaurantJson>();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria query = session.createCriteria(Restaurant.class);
			
			query.add(Restrictions.eq("status", 1));
			query.add(Restrictions.eq("active", 1));
			
			List<Restaurant> restaurant = query.list();
			List<RestaurantJson> list = new ArrayList<RestaurantJson>();
			for(int i=0; i<restaurant.size(); i++) {
				RestaurantJson insert = new RestaurantJson();
				insert.setFromQuery(restaurant.get(i));
				list.add(insert);
			}
			
			result = list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public RestaurantJson getRestaurantById(int restaurantId){
		RestaurantJson result = new RestaurantJson();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria query = session.createCriteria(Restaurant.class);
			
			query.add(Restrictions.eq("restaurantId", restaurantId));			
			
			List<Restaurant> restaurant = query.list();
			RestaurantJson data = new RestaurantJson();
			data.setFromQuery(restaurant.get(0));
			
			result = data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public RestaurantListByUserResponse RestaurantListByUser(RestaurantListByUserRequest request) {
		RestaurantListByUserResponse result = new RestaurantListByUserResponse();
		
		try {
			List<RestaurantJson> restaurant;
			
			if(request.getAdmin() == 1) {
				restaurant = getRestaurantByAdmin();
			}
			else{
				restaurant = getRestaurantByUser(request.getUserId());
			}
			
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("berhasil mengambil data restoran");
			resultResponse.setStatus(resultValue.success);				
				
			result.setResultResponse(resultResponse);		
			result.setRestaurant(restaurant);
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Terjadi masalah saat mengambil data restoran");
			resultResponse.setStatus(resultValue.failed);				
				
			result.setResultResponse(resultResponse);		
		}
		
		return result;
	}
	
	public List<RestaurantJson> getNearbyRestaurantList(Double lat,Double Long,Double minLat,Double maxLat,Double minLong,Double maxLong){
		List<RestaurantJson> result = new ArrayList<RestaurantJson>();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria query = session.createCriteria(Restaurant.class);
			
			query.add(Restrictions.gt("latitude", minLat));
			query.add(Restrictions.gt("longitude", minLong));
			query.add(Restrictions.lt("latitude", maxLat));
			query.add(Restrictions.lt("longitude", maxLong));
			query.add(Restrictions.eq("active", 1));
			query.add(Restrictions.eq("status", 2));
			
			List<Restaurant> restaurant = query.list();
			
			List<RestaurantJson> list = new ArrayList<RestaurantJson>();
			for(int i=0; i<restaurant.size(); i++) {
				RestaurantJson insert = new RestaurantJson();
				insert.setFromQuery(restaurant.get(i));
				insert.setDistance(lat, Long);
				list.add(insert);
			}
			
			Collections.sort(list, new Comparator<RestaurantJson>() {
				  @Override
				  public int compare(RestaurantJson u1, RestaurantJson u2) {
				    return u1.getDistance().compareTo(u2.getDistance());
				  }
				});
			
			result = list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public NearbyRestaurantResponse NearbyRestaurant(NearbyRestaurantRequest request) {
		NearbyRestaurantResponse result = new NearbyRestaurantResponse();
		
		try {
			
			
			List<RestaurantJson> restaurant = getNearbyRestaurantList(request.getLatitude(),request.getLongitude(),request.getMinLatitude(),request.getMaxLatitude(),request.getMinLongitude(),request.getMaxLongitude());
			
			if(restaurant.size() > 0) {
				ResultResponse resultResponse = new ResultResponse();
				resultResponse.setMessage("Mengambil list restoran berhasil");
				resultResponse.setStatus(resultValue.success);		
				
				result.setResultResponse(resultResponse);
				result.setRestaurant(restaurant);
			}
			else {
				ResultResponse resultResponse = new ResultResponse();
				resultResponse.setMessage("Tidak ditemukan restoran disekitar anda");
				resultResponse.setStatus(resultValue.failed);
				
				result.setResultResponse(resultResponse);
			}
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Terjadi masalah saat mengambil data");
			resultResponse.setStatus(resultValue.failed);
		} 
		
		return result;
	}
	
	public RegisterRestaurantResponse RegisterRestaurant(RegisterRestaurantRequest request) {
		RegisterRestaurantResponse result = new RegisterRestaurantResponse();	
		
		try {
			Restaurant restaurant = new Restaurant();
			restaurant.setFromRequest(request);
			restaurant.setStatus(1);
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(restaurant);
			session.getTransaction().commit();			
						
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage(String.format("Berhasil mendaftarkan restoran %s ", request.getRestaurantName()));
			resultResponse.setStatus(resultValue.success);				
				
			result.setResultResponse(resultResponse);
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Terjadi masalah saat mendaftarkan restoran");
			resultResponse.setStatus(resultValue.failed);
			
			result.setResultResponse(resultResponse);
		}
		
		return result;
	}
	
	public UpdateRestaurantResponse UpdateRestaurant(UpdateRestaurantRequest request) {
		UpdateRestaurantResponse result = new UpdateRestaurantResponse();	
		
		try {
			Restaurant restaurant = new Restaurant();
			restaurant.setFromRequest(request);
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(restaurant);
			session.getTransaction().commit();
			
						
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Berhasil update data restoran");
			resultResponse.setStatus(resultValue.success);				
				
			result.setResultResponse(resultResponse);	
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Terjadi masalah saat update restoran");
			resultResponse.setStatus(resultValue.failed);
			
			result.setResultResponse(resultResponse);
		}
		
		return result;
	}
	
	public RestaurantDetailResponse RestaurantDetail(RestaurantDetailRequest request) {
		RestaurantDetailResponse result = new RestaurantDetailResponse();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria query = session.createCriteria(Restaurant.class);			
			query.add(Restrictions.eq("restaurantId", request.getRestaurantId()));
			
			RestaurantJson restaurantJson = new RestaurantJson();
			List<Restaurant> restaurant = query.list();			
			restaurantJson.setFromQuery(restaurant.get(0));
			
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Mengambil detail restoran berhasil");
			resultResponse.setStatus(resultValue.success);	
			
			RestaurantCommentManagement commentLogic = new RestaurantCommentManagement();
			List<RestaurantCommentJson> restaurantCommentJson = commentLogic.getCommentList(request.getRestaurantId());
			
			FoodManagement foodLogic = new FoodManagement();
			List<FoodJson> foodJson = foodLogic.GetListFromRestaurant(request.getRestaurantId());		
			
			result.setRestaurantJson(restaurantJson);
			result.setResultResponse(resultResponse);
			result.setRestaurantCommentJson(restaurantCommentJson);
			result.setFoodJson(foodJson);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Terjadi masalah saat mengambil data restoran");
			resultResponse.setStatus(resultValue.failed);
			
			result.setResultResponse(resultResponse);
		}
		
		return result;
	}
	
	public RestaurantRatingResponse RestaurantRating(RestaurantRatingRequest request) {
		RestaurantRatingResponse result = new RestaurantRatingResponse();
		
		try {			
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("berhasil mengambil rating restoran");
			resultResponse.setStatus(resultValue.success);			
			
			RestaurantRatingJson rating = getRestaurantRating(request.getRestaurantId());
			
			result.setResultResponse(resultResponse);
			result.setRestaurantRatingJson(rating);
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Terjadi masalah saat mengambil rating restoran");
			resultResponse.setStatus(resultValue.failed);
			
			result.setResultResponse(resultResponse);
		}
		
		return result;
	}
	
	public RestaurantRatingJson getRestaurantRating(int restaurantId) {
		RestaurantRatingJson result = new RestaurantRatingJson();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria query = session.createCriteria(RestaurantRating.class);			
			query.add(Restrictions.eq("restaurantId", restaurantId));
			
			List<RestaurantRating> data = query.list();
			
			double totalRating = 0;
			
			if(data.size() > 0) {
				for(int i=0;i<data.size();i++) {
					RestaurantRating score = data.get(i);
					totalRating = totalRating + score.getRating();
				}
				
				result.setRating(Double.valueOf(totalRating / data.size()));
				result.setUserNumber(data.size());
			}
			else {
				result.setRating(0.0);
				result.setUserNumber(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public RestaurantRatingByUserResponse RestaurantRatingByUser(RestaurantRatingByUserRequest request) {
		RestaurantRatingByUserResponse result = new RestaurantRatingByUserResponse();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria query = session.createCriteria(RestaurantRating.class);			
			query.add(Restrictions.eq("restaurantId", request.getRestaurantId()));
			query.add(Restrictions.eq("userId", request.getUserId()));
			
			List<RestaurantRating> restaurantRating = query.list();
			
			if(restaurantRating.size() > 0) {
				RestaurantRatingDetailJson rating = new RestaurantRatingDetailJson();
				rating.setFromQuery(restaurantRating.get(0));
				
				ResultResponse resultResponse = new ResultResponse();
				resultResponse.setMessage("berhasil mengambil rating restoran berdasarkan user");
				resultResponse.setStatus(resultValue.success);
				
				result.setResultResponse(resultResponse);
				result.setRestaurantRatingDetailJson(rating);
			}
			else {
				ResultResponse resultResponse = new ResultResponse();
				resultResponse.setMessage("rating restoran berdasarkan user tidak ada");
				resultResponse.setStatus(resultValue.success);
				
				result.setResultResponse(resultResponse);
			}
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("terjadi masalah saat mengambil rating restoran berdasarkan user");
			resultResponse.setStatus(resultValue.failed);
			
			result.setResultResponse(resultResponse);
		}
		
		return result;
	}
	
	public InsertRestaurantRatingResponse InsertRestaurantRating(InsertRestaurantRatingRequest request) {
		InsertRestaurantRatingResponse result = new InsertRestaurantRatingResponse();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria query = session.createCriteria(RestaurantRating.class);			
			query.add(Restrictions.eq("restaurantId", request.getRestaurantId()));
			query.add(Restrictions.eq("userId", request.getUserId()));
			
			List<RestaurantRating> restaurantRating = query.list();
			
			if(restaurantRating.size() == 1) {
				RestaurantRating rating = new RestaurantRating();
				rating = restaurantRating.get(0);
				rating.setRating(request.getRating());
				
				session.beginTransaction();
				session.save(rating);
				session.getTransaction().commit();
				
				ResultResponse resultResponse = new ResultResponse();
				resultResponse.setMessage("berhasil memasukan rating restoran");
				resultResponse.setStatus(resultValue.success);
				
				result.setResultResponse(resultResponse);
			}
			else if(restaurantRating.size() > 1) {
				RestaurantRating rating = new RestaurantRating();
				
				for(int i=1;i<restaurantRating.size();i++) {
					rating = restaurantRating.get(i);
					session.delete(rating);
				}
				
				rating = restaurantRating.get(0);
				rating.setRating(request.getRating());
				
				session.beginTransaction();
				session.save(rating);
				session.getTransaction().commit();
				
				ResultResponse resultResponse = new ResultResponse();
				resultResponse.setMessage("berhasil memasukan rating restoran");
				resultResponse.setStatus(resultValue.success);
				
				result.setResultResponse(resultResponse);
			}
			else {
				RestaurantRating rating = new RestaurantRating();
				rating.setFromRequestInsert(request);
				
				session.beginTransaction();
				session.save(rating);
				session.getTransaction().commit();
				
				ResultResponse resultResponse = new ResultResponse();
				resultResponse.setMessage("berhasil memasukan rating restoran");
				resultResponse.setStatus(resultValue.success);
				
				result.setResultResponse(resultResponse);
			}
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("terjadi masalah saat memasukan rating restoran");
			resultResponse.setStatus(resultValue.failed);
			
			result.setResultResponse(resultResponse);
		}
		
		
		return result;
	}
	
	public DeleteRestaurantResponse DeleteRestaurant(DeleteRestaurantRequest request) {
		DeleteRestaurantResponse result = new DeleteRestaurantResponse();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria query = session.createCriteria(Restaurant.class);			
			query.add(Restrictions.eq("restaurantId", request.getRestaurantId()));
			
			List<Restaurant> restaurant = query.list();
			
			Restaurant delete = restaurant.get(0);
			delete.setActive(0);
			session.beginTransaction();
			session.update(delete);
			session.getTransaction().commit();
			
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("berhasil menghapus restoran");
			resultResponse.setStatus(resultValue.success);
			
			result.setResultResponse(resultResponse);
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Terjadi masalah saat menghapus restoran");
			resultResponse.setStatus(resultValue.failed);
			
			result.setResultResponse(resultResponse);
		}
		
		return result;
	}
	
	public ConfirmRestaurantResponse ConfirmRestaurant(ConfirmRestaurantRequest request) {
		ConfirmRestaurantResponse result = new ConfirmRestaurantResponse();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria query = session.createCriteria(Restaurant.class);			
			query.add(Restrictions.eq("restaurantId", request.getRestaurantId()));
			
			List<Restaurant> restaurant = query.list();
			
			Restaurant status = restaurant.get(0);
			status.setStatus(request.getStatus());
			session.beginTransaction();
			session.update(status);
			session.getTransaction().commit();
			
			ResultResponse resultResponse = new ResultResponse();
			if(request.getStatus() == 2) {
				resultResponse.setMessage("berhasil konfirmasi restoran");
			}
			else if(request.getStatus() == 3) {
				resultResponse.setMessage("berhasil menolak konfirmasi restoran");
			}
			
			resultResponse.setStatus(resultValue.success);
			
			result.setResultResponse(resultResponse);
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Terjadi masalah saat konfirmasi restoran");
			resultResponse.setStatus(resultValue.failed);
			
			result.setResultResponse(resultResponse);
		}
		
		return result;
	}
}
