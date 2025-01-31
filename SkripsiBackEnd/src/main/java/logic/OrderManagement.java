package main.java.logic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import main.java.GlobalVal.ResultValue;
import main.java.HibernateUtil.HibernateUtil;
import main.java.databaseModel.Chat;
import main.java.databaseModel.Food;
import main.java.databaseModel.OrderDetail;
import main.java.databaseModel.OrderHeader;
import main.java.databaseModel.Restaurant;
import main.java.databaseModel.UserData;
import main.java.jsonModel.Request.ChatViewRequest;
import main.java.jsonModel.Request.ChatWriteRequest;
import main.java.jsonModel.Request.GetListOrderCustomerRequest;
import main.java.jsonModel.Request.OrderListByOwnerRequest;
import main.java.jsonModel.Request.OrderNumbersByUserRequest;
import main.java.jsonModel.Request.OrderRequest;
import main.java.jsonModel.Request.ProcessOrderRequest;
import main.java.jsonModel.Response.ChatViewResponse;
import main.java.jsonModel.Response.ChatWriteResponse;
import main.java.jsonModel.Response.GetListOrderCustomerResponse;
import main.java.jsonModel.Response.OrderListByOwnerResponse;
import main.java.jsonModel.Response.OrderNumbersByUserResponse;
import main.java.jsonModel.Response.OrderResponse;
import main.java.jsonModel.Response.ProcessOrderResponse;
import main.java.jsonModel.detailModel.ChatJson;
import main.java.jsonModel.detailModel.FoodJson;
import main.java.jsonModel.detailModel.OrderDetailJson;
import main.java.jsonModel.detailModel.OrderHeaderJson;
import main.java.jsonModel.detailModel.RestaurantJson;
import main.java.jsonModel.detailModel.ResultResponse;

public class OrderManagement {
	ResultValue resultValue = new ResultValue();
	
	public OrderResponse Order(OrderRequest request) {
		OrderResponse result = new OrderResponse();
				
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria query = session.createCriteria(UserData.class);
			query.add(Restrictions.eq("userId",request.getUserId()));
			
			OrderHeader orderHeader = new OrderHeader();
			orderHeader.setFromRequest(request);
			
			List<UserData> userData = query.list();
			UserData data = userData.get(0);
			
			if(data.getBalance() < orderHeader.getTotalPrice()) {
				ResultResponse resultResponse = new ResultResponse();
				resultResponse.setMessage("Jumlah uang kurang");
				resultResponse.setStatus(resultValue.failed);
				
				result.setResultResponse(resultResponse);
			}
			else {
				session.beginTransaction();
				session.save(orderHeader);
				
				List<FoodJson> food = request.getFood();
				for(int i=0;i<food.size();i++) {
					OrderDetail orderDetail = new OrderDetail();
					orderDetail.setFromRequest(orderHeader.getOrderId(), food.get(i));
					session.save(orderDetail);
				}
				
				data.setBalance(data.getBalance() - orderHeader.getTotalPrice());
				session.update(data);
				
				session.getTransaction().commit();
				
				ResultResponse resultResponse = new ResultResponse();
				resultResponse.setMessage("Pesanan berhasil dibuat, pesanan akan dicek pemilik restoran");
				resultResponse.setStatus(resultValue.success);
				
				result.setResultResponse(resultResponse);
			}
			
			
			
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Terjadi kesalahan saat membuat pesanan");
			resultResponse.setStatus(resultValue.failed);
			
			result.setResultResponse(resultResponse);
		}
		
		return result;
	}
	
	public GetListOrderCustomerResponse GetListOrderCustomer(GetListOrderCustomerRequest request) {
		GetListOrderCustomerResponse result = new GetListOrderCustomerResponse();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria query = session.createCriteria(OrderHeader.class);
			query.add(Restrictions.eq("userId", request.getUserId()));
			
			List<OrderHeader> orderHeader = query.list();			
			
			List<OrderHeaderJson> data = new ArrayList<OrderHeaderJson>();			
			for(int i=0;i<orderHeader.size();i++) {
				OrderHeaderJson order = new OrderHeaderJson();
				order.setFromQuery(orderHeader.get(i));
				data.add(order);
			}			
			
			result.setOrderHeaderJson(data);
			
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Berhasil mengambil data");
			resultResponse.setStatus(resultValue.success);
			
			result.setResultResponse(resultResponse);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Terjadi kesalahan saat mengambil data");
			resultResponse.setStatus(resultValue.failed);
			
			result.setResultResponse(resultResponse);
		}
		
		return result;
	}
	
	public List<OrderDetailJson> GetOrderDetailByHeader(int orderId){
		List<OrderDetailJson> result = new ArrayList<OrderDetailJson>();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria query = session.createCriteria(OrderDetail.class);
			query.add(Restrictions.eq("orderId", orderId));
			
			List<OrderDetail> orderDetail = query.list();
			for(int i=0;i<orderDetail.size();i++) {
				OrderDetailJson data = new OrderDetailJson();
				data.setFromQuery(orderDetail.get(i));
				result.add(data);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public OrderNumbersByUserResponse OrderNumbersByUser(OrderNumbersByUserRequest request){
		OrderNumbersByUserResponse result = new OrderNumbersByUserResponse();
		
		try {
			RestaurantManagement restaurantManagement = new RestaurantManagement();
			List<RestaurantJson> restaurantListByUser = restaurantManagement.getRestaurantByUser(request.getUserId());
			
			if(restaurantListByUser.size() < 1) {
				ResultResponse resultResponse = new ResultResponse();
				resultResponse.setMessage("Berhasil mengambil data");
				resultResponse.setStatus(resultValue.success);
				
				result.setResultResponse(resultResponse);
				result.setOrderNumbers(0);
			}
			else {
				List<Integer> restaurantId = new ArrayList<Integer>();
				for(int i=0;i<restaurantListByUser.size();i++) {
					restaurantId.add(restaurantListByUser.get(i).getRestaurantId());
				}
				
				Session session = HibernateUtil.getSessionFactory().openSession();
				Criteria query = session.createCriteria(OrderHeader.class);
				query.add(Restrictions.in("restaurantId", restaurantId));
				query.add(Restrictions.eq("status",1));
				
				List<OrderHeader> orderHeader = query.list();
				
				ResultResponse resultResponse = new ResultResponse();
				resultResponse.setMessage("Berhasil mengambil data");
				resultResponse.setStatus(resultValue.success);
				
				result.setResultResponse(resultResponse);
				result.setOrderNumbers(orderHeader.size());
			}
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Terjadi masalah saat mengambil data");
			resultResponse.setStatus(resultValue.failed);
			
			result.setResultResponse(resultResponse);
		}
		
		return result;
	}
	
	public OrderListByOwnerResponse getOrderListByOwner(OrderListByOwnerRequest request) {
		OrderListByOwnerResponse result = new OrderListByOwnerResponse();
		
		try {
			RestaurantManagement restaurantManagement = new RestaurantManagement();
			List<RestaurantJson> restaurantListByUser = restaurantManagement.getRestaurantByUser(request.getUserId());
			
			List<Integer> restaurantId = new ArrayList<Integer>();
			for(int i=0;i<restaurantListByUser.size();i++) {
				restaurantId.add(restaurantListByUser.get(i).getRestaurantId());
			}
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria query = session.createCriteria(OrderHeader.class);
			query.add(Restrictions.in("restaurantId", restaurantId));
			query.add(Restrictions.eq("status",1));
			
			List<OrderHeader> orderHeader = query.list();
			
			List<OrderHeaderJson> data = new ArrayList<OrderHeaderJson>();			
			for(int i=0;i<orderHeader.size();i++) {
				OrderHeaderJson order = new OrderHeaderJson();
				order.setFromQuery(orderHeader.get(i));
				data.add(order);
			}			
			
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Berhasil mengambil data");
			resultResponse.setStatus(resultValue.success);
			
			result.setResultResponse(resultResponse);			
			result.setOrderHeaderJson(data);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Terjadi Masalah saat mengambil list order");
			resultResponse.setStatus(resultValue.failed);
			
			result.setResultResponse(resultResponse);
		}
		
		return result;
	}
	
	public ProcessOrderResponse ProcessOrder(ProcessOrderRequest request) {
		ProcessOrderResponse result = new ProcessOrderResponse();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria query = session.createCriteria(OrderHeader.class);
			query.add(Restrictions.in("orderId", request.getOrderId()));
			
			List<OrderHeader> orderList = query.list();
			OrderHeader order = orderList.get(0);
			order.setStatus(2);
			
			Criteria queryRestaurant = session.createCriteria(Restaurant.class);
			queryRestaurant.add(Restrictions.eq("restaurantId",order.getRestaurantId()));
			List<Restaurant> restaurantList = queryRestaurant.list();
			Restaurant restaurant = restaurantList.get(0);
			
			Criteria queryUser = session.createCriteria(UserData.class);
			queryUser.add(Restrictions.eq("userId",restaurant.getUserId()));
			List<UserData> userList = queryUser.list();
			UserData user = userList.get(0);
			user.setBalance(user.getBalance() + order.getTotalPrice());
			
			
			session.beginTransaction();
			session.update(order);
			session.update(user);
			session.getTransaction().commit();
			
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Pesanan Diterima");
			resultResponse.setStatus(resultValue.success);
			
			result.setResultResponse(resultResponse);		
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Terjadi masalah saat meproses pesanan");
			resultResponse.setStatus(resultValue.failed);
			
			result.setResultResponse(resultResponse);		
		}
		
		return result;
		
	}
	
	public ChatViewResponse ViewChat(ChatViewRequest request) {
		ChatViewResponse result = new ChatViewResponse();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria query = session.createCriteria(Chat.class);
			query.add(Restrictions.in("orderId", request.getOrderId()));
			
			List<Chat> chat = query.list();
			
			List<ChatJson> data = new ArrayList<ChatJson>();
			for(int i=0; i<chat.size(); i++) {
				ChatJson chatData = new ChatJson();
				chatData.setFromQuery(chat.get(i));
				data.add(chatData);
			}			
			
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("chat berhasil diambil");
			resultResponse.setStatus(resultValue.success);
			
			result.setChat(data);
			result.setResultResponse(resultResponse);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Terjadi masalah saat meproses chat");
			resultResponse.setStatus(resultValue.failed);
			
			result.setResultResponse(resultResponse);	
		}
		
		return result;
	}
	
	public ChatWriteResponse WriteChat(ChatWriteRequest request) {
		ChatWriteResponse result = new ChatWriteResponse();
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			Chat chat = new Chat();
			chat.setFromRequest(request);			
			
			session.save(chat);
			session.getTransaction().commit();			
			
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("chat berhasil ditulis");
			resultResponse.setStatus(resultValue.success);
			
			result.setResultResponse(resultResponse);
			
		} catch (Exception e) {
			ResultResponse resultResponse = new ResultResponse();
			resultResponse.setMessage("Terjadi masalah saat meproses chat");
			resultResponse.setStatus(resultValue.failed);
			
			result.setResultResponse(resultResponse);	
		}
		
		return result;
	}
}
