package main.java.databaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import main.java.GlobalVal.JsonName;
import main.java.jsonModel.Request.InsertRestaurantRatingRequest;
import main.java.jsonModel.Request.RestaurantRatingByUserRequest;
import main.java.jsonModel.detailModel.RestaurantRatingJson;

@Entity
@Table(name="restaurant_rating")
@DynamicUpdate
public class RestaurantRating {
	@Id
	@Column(name="restaurant_rating_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer restaurantRatingId;
	
	@Column(name="restaurant_id",length=100,nullable=false)
	private Integer restaurantId;

	@Column(name="user_id",length=100,nullable=false)
	private Integer userId;
	
	@Column(name="rating",length=100,nullable=false)
	private Integer rating;
	
	public void setFromRequestInsert(InsertRestaurantRatingRequest request) {
		restaurantId = request.getRestaurantId();
		userId = request.getUserId();
		rating = request.getRating();
	}

	public Integer getRestaurantRatingId() {
		return restaurantRatingId;
	}
	
	public void setRestaurantRatingId(Integer restaurantRatingId) {
		this.restaurantRatingId = restaurantRatingId;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	
}
