package main.java.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import main.java.GlobalVal.ResultValue;
import main.java.HibernateUtil.HibernateUtil;
import main.java.databaseModel.Food;
import main.java.databaseModel.Restaurant;
import main.java.databaseModel.TasteOfFood;
import main.java.databaseModel.Type;
import main.java.databaseModel.TypeOfFood;
import main.java.jsonModel.Request.DeleteFoodRequest;
import main.java.jsonModel.Request.InsertFoodRequest;
import main.java.jsonModel.Request.RestaurantFoodListRequest;
import main.java.jsonModel.Request.SearchFoodRequest;
import main.java.jsonModel.Request.UpdateFoodRequest;
import main.java.jsonModel.Response.DeleteFoodResponse;
import main.java.jsonModel.Response.InsertFoodResponse;
import main.java.jsonModel.Response.RestaurantFoodListResponse;
import main.java.jsonModel.Response.SearchFoodResponse;
import main.java.jsonModel.Response.UpdateFoodResponse;
import main.java.jsonModel.detailModel.FoodJson;
import main.java.jsonModel.detailModel.RestaurantJson;
import main.java.jsonModel.detailModel.ResultResponse;
import main.java.jsonModel.detailModel.TasteJson;
import main.java.jsonModel.detailModel.TypeJson;

public class FoodManagement {
	ResultValue resultValue = new ResultValue();
	
	public InsertFoodResponse InsertFood(InsertFoodRequest request) {
		InsertFoodResponse result = new InsertFoodResponse();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			Food food = new Food();
			food.setFromRequest(request);
			session.save(food);
			
			List<TasteJson> list = request.getTaste();
			
			for(int i=0;i<list.size();i++) {
				TasteOfFood data = new TasteOfFood();
				data.setFromRequest(food.getFoodId(), list.get(i).getTasteId());
				session.save(data);
			}			
			
			TypeOfFood type = new TypeOfFood();
			TypeJson typeRequest = request.getType();
			type.setFromRequest(food.getFoodId(), typeRequest.getTypeId());
			
			session.save(type);
			
			session.getTransaction().commit();
			
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage(String.format("Berhasil menambahkan menu dengan nama %s", food.getFoodName()));
			resultResponse.setStatus(resultValue.success);
			
			result.setResultResponse(resultResponse);
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Terjadi masalah saat menambahkan menu baru");
			resultResponse.setStatus(resultValue.failed);
			
			result.setResultResponse(resultResponse);
		}
		
		return result;
	}
	
	public List<FoodJson> GetListFromRestaurant(int restaurantId) {
		List<FoodJson> result = new ArrayList<FoodJson>();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria query = session.createCriteria(Food.class);
			query.add(Restrictions.eq("restaurantId", restaurantId));
			query.add(Restrictions.eq("active", 1));
			
			List<Food> food = query.list();
			
			for(int i=0;i<food.size();i++) {
				FoodJson data = new FoodJson();
				data.setFromQuery(food.get(i));
				result.add(data);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public FoodJson GetFoodById(int foodId) {
		FoodJson result = new FoodJson();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria query = session.createCriteria(Food.class);
			query.add(Restrictions.eq("foodId", foodId));
			
			List<Food> food = query.list();
			FoodJson data = new FoodJson();
			
			data.setFromQuery(food.get(0));
			result = data;		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public RestaurantFoodListResponse RestaurantFoodList(RestaurantFoodListRequest request) {
		RestaurantFoodListResponse result = new RestaurantFoodListResponse();
		
		try {
			List<FoodJson> foodList = GetListFromRestaurant(request.getRestaurantId());
			
			result.setFoodJson(foodList);
			
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Berhasil mengambil list makanan");
			resultResponse.setStatus(resultValue.success);
			
			result.setResultResponse(resultResponse);
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Terjadi masalah saat mengambil list makanan");
			resultResponse.setStatus(resultValue.failed);
			
			result.setResultResponse(resultResponse);
		}
		
		return result;
	}
	
	public SearchFoodResponse SearchFood(SearchFoodRequest request){
		SearchFoodResponse result = new SearchFoodResponse();
		
		try {
			RestaurantManagement restaurantManagement = new RestaurantManagement();
			List<RestaurantJson> restaurantList = restaurantManagement.getNearbyRestaurantList(request.getLatitude(), request.getLongitude(), request.getMinLatitude(), request.getMaxLatitude(), request.getMinLongitude(), request.getMaxLongitude());
			Map<Integer,Double> distance = new HashMap<Integer,Double>();
			Map<Integer,String> restaurantName = new HashMap<Integer,String>();
			
			List<TasteJson> tasteList = request.getTaste();
			
			List<Integer> restaurantIdList = new ArrayList<Integer>();
			for(int i=0;i<restaurantList.size();i++) {
				restaurantIdList.add(restaurantList.get(i).getRestaurantId());
				distance.put(restaurantList.get(i).getRestaurantId(), restaurantList.get(i).getDistance());
				restaurantName.put(restaurantList.get(i).getRestaurantId(), restaurantList.get(i).getRestaurantName());
			}
			
			List<Integer> tasteIdList = new ArrayList<Integer>();
			for(int i=0;tasteList != null && i<tasteList.size();i++) {
				tasteIdList.add(tasteList.get(i).getTasteId());
			}
			
			if(restaurantIdList.size() < 1) {
				ResultResponse resultResponse = new ResultResponse();
				resultResponse.setMessage("Tidak ditemukan restoran disekitar lokasi anda");
				resultResponse.setStatus(resultValue.failed);
				
				result.setResultResponse(resultResponse);
			}
			else {
				Session session = HibernateUtil.getSessionFactory().openSession();
				Criteria query = session.createCriteria(Food.class);
				
				query.add(Restrictions.in("restaurantId", restaurantIdList));
				if(request.getFoodName() != null) query.add(Restrictions.ilike("foodName", request.getFoodName()));
				if(request.getTaste() != null) {
					Criteria foodFromTaste = session.createCriteria(TasteOfFood.class);
					foodFromTaste.add(Restrictions.in("tasteId", tasteIdList));
					
					List<TasteOfFood> tasteOfFood = foodFromTaste.list();
					
					if(tasteOfFood.size() > 0) {
						List<Integer> foodIdFromTaste = new ArrayList<Integer>();
						
						for(int i=0;i<tasteOfFood.size();i++) {
							foodIdFromTaste.add(tasteOfFood.get(i).getFoodId());
						}
						
						query.add(Restrictions.in("foodId", foodIdFromTaste));
					}else {
						query.add(Restrictions.in("foodId", -1));
					}
				}
				
				if(request.getType() != null) {
					Criteria foodFromType = session.createCriteria(TypeOfFood.class);
					foodFromType.add(Restrictions.in("typeId", request.getType().getTypeId()));
					
					List<TypeOfFood> typeOfFood = foodFromType.list();
					
					if(typeOfFood.size() > 0) {
						List<Integer> foodIdFromType = new ArrayList<Integer>();
						
						for(int i=0;i<typeOfFood.size();i++) {
							foodIdFromType.add(typeOfFood.get(i).getFoodId());
						}
						
						query.add(Restrictions.in("foodId", foodIdFromType));
					}
					else {
						query.add(Restrictions.in("foodId", -1));
					}
					
					
				}				
				
				List<Food> foodList = query.list();
				
				List<FoodJson> food = new ArrayList<FoodJson>();
				for(int i=0;i<foodList.size();i++) {
					FoodJson data = new FoodJson();
					data.setFromQuery(foodList.get(i));
					data.setDistance(distance.get(foodList.get(i).getRestaurantId()));
					data.setRestaurantName(restaurantName.get(foodList.get(i).getRestaurantId()));
					food.add(data);
				}				
				
				Collections.sort(food, new Comparator<FoodJson>() {
					  @Override
					  public int compare(FoodJson u1, FoodJson u2) {
					    return u1.getDistance().compareTo(u2.getDistance());
					  }
					});
				
				result.setFood(food); 
				
				if(food.size() < 1) {
					ResultResponse resultResponse = new ResultResponse();
					resultResponse.setMessage("Makanan dengan filter ini tidak tersedia");
					resultResponse.setStatus(resultValue.success);
					
					result.setResultResponse(resultResponse);
				}
				else {
					ResultResponse resultResponse = new ResultResponse();
					resultResponse.setMessage("Berhasil mengambil list makanan");
					resultResponse.setStatus(resultValue.success);
					
					result.setResultResponse(resultResponse);
				}
			}
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Terjadi masalah saat mengambil list makanan");
			resultResponse.setStatus(resultValue.failed);
			
			result.setResultResponse(resultResponse);
		}
		
		return result;
	}
	
	public DeleteFoodResponse DeleteFood(DeleteFoodRequest request) {
		DeleteFoodResponse result = new DeleteFoodResponse();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria query = session.createCriteria(Food.class);
			query.add(Restrictions.eq("foodId", request.getFoodId()));
			
			List<Food> foodList = query.list();
			
			Food food = foodList.get(0);
			food.setActive(0);
			session.beginTransaction();
			session.save(food);
			session.getTransaction().commit();
			
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Berhasil menghapus menu");
			resultResponse.setStatus(resultValue.success);
			
			result.setResultResponse(resultResponse);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Terjadi masalah saat menghapus menu");
			resultResponse.setStatus(resultValue.failed);
			
			result.setResultResponse(resultResponse);
		}
		
		return result;
	}
	
	public UpdateFoodResponse UpdateFood(UpdateFoodRequest request) {
		UpdateFoodResponse result = new UpdateFoodResponse();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria query = session.createCriteria(Food.class);
			query.add(Restrictions.eq("foodId", request.getFoodId()));
			
			List<Food> foodList = query.list();
			
			Food food = foodList.get(0);
			food.setFromRequest(request);
			session.beginTransaction();
			
			List<TasteJson> tasteList = request.getTaste();
			
			Map<Integer,TasteJson> tasteMap = new HashMap<Integer, TasteJson>();
			for(int i=0;i<tasteList.size();i++) {
				tasteMap.put(tasteList.get(i).getTasteId(), tasteList.get(i));
			}
			
			Criteria tasteQuery = session.createCriteria(TasteOfFood.class);
			tasteQuery.add(Restrictions.eq("foodId",request.getFoodId()));
			List<TasteOfFood> tasteOfFood = tasteQuery.list();
			
			for(int i=0;i<tasteOfFood.size();i++) {
				session.delete(tasteOfFood.get(i));
			}
			
			for(int i=0;i<tasteList.size();i++) {
				TasteOfFood data = new TasteOfFood();
				data.setFromRequest(food.getFoodId(), tasteList.get(i).getTasteId());
				session.save(data);
			}
			
			TypeOfFood type = new TypeOfFood();
			TypeJson typeRequest = request.getType();
			
			Criteria typeQuery = session.createCriteria(TypeOfFood.class);
			typeQuery.add(Restrictions.eq("foodId",request.getFoodId()));
			List<TypeOfFood> typeOfFood = typeQuery.list();
			
			type = typeOfFood.get(0);
			type.setFromRequest(food.getFoodId(), typeRequest.getTypeId());
			
			session.save(type);
			session.save(food);
			session.getTransaction().commit();
			
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Berhasil memperbaharui menu");
			resultResponse.setStatus(resultValue.success);
			
			result.setResultResponse(resultResponse);
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Terjadi masalah saat memperbaharui menu");
			resultResponse.setStatus(resultValue.failed);
			
			result.setResultResponse(resultResponse);
		}
		
		return result;
	}
}
