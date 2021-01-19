package main.java.logic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import main.java.GlobalVal.ResultValue;
import main.java.HibernateUtil.HibernateUtil;
import main.java.databaseModel.RestaurantComment;
import main.java.jsonModel.Request.InsertRestaurantCommentRequest;
import main.java.jsonModel.Request.RestaurantCommentListRequest;
import main.java.jsonModel.Response.InsertRestaurantCommentResponse;
import main.java.jsonModel.Response.RestaurantCommentListResponse;
import main.java.jsonModel.detailModel.RestaurantCommentJson;
import main.java.jsonModel.detailModel.ResultResponse;

public class RestaurantCommentManagement {
	ResultValue resultValue = new ResultValue();
	
	public List<RestaurantCommentJson> getCommentList(int restaurantId) {
		List<RestaurantCommentJson> result = new ArrayList<RestaurantCommentJson>();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria query = session.createCriteria(RestaurantComment.class);
			query.add(Restrictions.eq("restaurantId", restaurantId));
			query.addOrder(Order.desc("createdDate"));
			
			List<RestaurantComment> commentList= query.list();
			
			for(int i=0;i<commentList.size();i++) {
				RestaurantCommentJson data = new RestaurantCommentJson();
				data.setFromQuery(commentList.get(i));
				result.add(data);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public RestaurantCommentListResponse CommentList(RestaurantCommentListRequest request) {
		RestaurantCommentListResponse result = new RestaurantCommentListResponse();
		
		try {
			List<RestaurantCommentJson> commentList = getCommentList(request.getRestaurantId());
			
			result.setRestaurantCommentJson(commentList);
			
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Berhasil mengambil komentar");
			resultResponse.setStatus(resultValue.success);
			
			result.setResultResponse(resultResponse);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Terjadi masalah saat mengambil komentar");
			resultResponse.setStatus(resultValue.failed);
			
			result.setResultResponse(resultResponse);
		}
		
		return result;
	}
	
	public InsertRestaurantCommentResponse InsertComment(InsertRestaurantCommentRequest request) {
		InsertRestaurantCommentResponse result = new InsertRestaurantCommentResponse();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			RestaurantComment restaurantComment = new RestaurantComment();
			session.beginTransaction();
			restaurantComment.setFromRequest(request);
			session.save(restaurantComment);
			session.getTransaction().commit();
			
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Komentar berhasil ditulis");
			resultResponse.setStatus(resultValue.success);
			
			result.setResultResponse(resultResponse);
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Terjadi masalah saat menuliskan komentar");
			resultResponse.setStatus(resultValue.failed);
			
			result.setResultResponse(resultResponse);
		}
		
		return result;		
	}
}
