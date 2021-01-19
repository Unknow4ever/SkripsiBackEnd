package main.java.databaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import main.java.jsonModel.detailModel.FoodJson;

@Entity
@Table(name="order_detail")
@DynamicUpdate
public class OrderDetail {
	@Id
	@Column(name="order_detail_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderDetailId;
	
	@Column(name="order_id",nullable=false)
	private Integer orderId;
	
	@Column(name="food_id",nullable=false)
	private Integer foodId;
	
	@Column(name="unit_price",nullable=false)
	private Integer unitPrice;
	
	@Column(name="amount",nullable=false)
	private Integer amount;
	
	@Column(name="food_total_price",nullable=false)
	private Integer foodTotalPrice;
	
	public void setFromRequest(int orderId,FoodJson food) {
		this.orderId = orderId;
		foodId = food.getFoodId();
		unitPrice = food.getPrice();
		amount = food.getJumlah();
		foodTotalPrice = food.getPrice() * food.getJumlah();
	}

	public Integer getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPriceId) {
		this.unitPrice = unitPriceId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getFoodTotalPrice() {
		return foodTotalPrice;
	}

	public void setFoodTotalPrice(Integer foodTotalPrice) {
		this.foodTotalPrice = foodTotalPrice;
	}

	
}
