package main.java.jsonModel.detailModel;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import main.java.databaseModel.OrderHeader;
import main.java.logic.FoodManagement;
import main.java.logic.OrderManagement;
import main.java.logic.RestaurantManagement;

public class OrderHeaderJson {
	@SerializedName(value = "order_id")
	private Integer orderId;
	
	@SerializedName(value = "restaurant_id")
	private Integer restaurantId;

	@SerializedName(value = "status")
	private Integer status;
	
	@SerializedName(value = "total_price")
	private Integer totalPrice;
	
	@SerializedName(value = "userId")
	private Integer userId;
	
	@SerializedName(value = "restaurant")
	private RestaurantJson restaurant;
	
	@SerializedName(value = "order_detail")
	private List<OrderDetailJson> orderDetail;
	
	public void setFromQuery(OrderHeader query) {
		RestaurantManagement restaurantManagement = new RestaurantManagement();
		OrderManagement orderManagement = new OrderManagement();
				
		orderId = query.getOrderId();
		restaurantId = query.getRestaurantId();
		status = query.getStatus();
		totalPrice = query.getTotalPrice();
		userId = query.getUserId();
		
		restaurant = restaurantManagement.getRestaurantById(restaurantId);	
		orderDetail = orderManagement.GetOrderDetailByHeader(orderId);
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<OrderDetailJson> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(List<OrderDetailJson> orderDetail) {
		this.orderDetail = orderDetail;
	}
	
	
}
