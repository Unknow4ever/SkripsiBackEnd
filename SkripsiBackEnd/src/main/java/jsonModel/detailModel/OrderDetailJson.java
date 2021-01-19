package main.java.jsonModel.detailModel;

import com.google.gson.annotations.SerializedName;

import main.java.databaseModel.OrderDetail;
import main.java.logic.FoodManagement;

public class OrderDetailJson {
	@SerializedName(value = "order_detail_id")
	private Integer orderDetailId;
	
	@SerializedName(value = "amount")
	private Integer amount;
	
	@SerializedName(value = "food_id")
	private Integer foodId;
	
	@SerializedName(value = "food_total_price")
	private Integer foodTotalPrice;
	
	@SerializedName(value = "unit_price")
	private Integer unitPrice;
	
	@SerializedName(value = "order_id")
	private Integer orderId;
	
	@SerializedName(value = "food")
	private FoodJson food;

	public void setFromQuery(OrderDetail query) {
		FoodManagement foodManagement = new FoodManagement();
		
		orderDetailId = query.getOrderDetailId();
		amount = query.getAmount();
		foodId = query.getFoodId();
		foodTotalPrice = query.getFoodTotalPrice();
		unitPrice = query.getUnitPrice();
		orderId = query.getOrderId();
		
		food = foodManagement.GetFoodById(foodId);
	}

	public Integer getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public Integer getFoodTotalPrice() {
		return foodTotalPrice;
	}

	public void setFoodTotalPrice(Integer foodTotalPrice) {
		this.foodTotalPrice = foodTotalPrice;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public FoodJson getFood() {
		return food;
	}

	public void setFood(FoodJson food) {
		this.food = food;
	}
	
	
	
}
