package main.java.databaseModel;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import main.java.jsonModel.Request.OrderRequest;
import main.java.jsonModel.detailModel.FoodJson;

@Entity
@Table(name="order_header")
@DynamicUpdate
public class OrderHeader {
	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderId;
	
	@Column(name="user_id",nullable=false)
	private Integer userId;
	
	@Column(name="restaurant_id",nullable=false)
	private Integer restaurantId;
	
	@Column(name="total_price",nullable=false)
	private Integer totalPrice;
	
	@Column(name="status",nullable=false)
	private Integer status;

	public void setFromRequest(OrderRequest request) {
		List<FoodJson> food = request.getFood();
		
		int totalPrice = 0;
		for(int i=0;i<food.size();i++) {
			totalPrice = totalPrice + (food.get(i).getPrice() * food.get(i).getJumlah());
		}
		
		userId = request.getUserId();
		restaurantId = request.getRestaurantId();
		this.totalPrice = totalPrice;
		this.status = 1;
	}
	
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
