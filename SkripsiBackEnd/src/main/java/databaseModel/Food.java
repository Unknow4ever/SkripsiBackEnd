package main.java.databaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import main.java.jsonModel.Request.InsertFoodRequest;
import main.java.jsonModel.Request.UpdateFoodRequest;

@Entity
@Table(name="food")
@DynamicUpdate
public class Food {
	@Id
	@Column(name="food_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer foodId;
	
	@Column(name="restaurant_id")
	private Integer restaurantId;
	
	@Column(name="food_name",length=100,nullable=false)
	private String foodName;
	
	@Column(name="deskripsi",length=100,nullable=false)
	private String deskripsi;
	
	@Column(name="price",nullable=false)
	private Integer price;
	
	@Column(name="stock",nullable=false)
	private Integer stock;
	
	@Column(name="image", columnDefinition="Longtext")
	private String image;
	
	@Column(name="active", columnDefinition="Longtext")
	private Integer active;
	
	public void setFromRequest(InsertFoodRequest request) {
		restaurantId = request.getRestaurantId();
		foodName = request.getFoodName();
		deskripsi = request.getDeskripsi();
		price = request.getPrice();
		image = request.getImage();
		stock = request.getStock();
		active = 1;
	}
	
	public void setFromRequest(UpdateFoodRequest request) {
		restaurantId = request.getRestaurantId();
		foodName = request.getFoodName();
		deskripsi = request.getDeskripsi();
		price = request.getPrice();
		image = request.getImage();
		stock = request.getStock();
		active = 1;
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getDeskripsi() {
		return deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
}
