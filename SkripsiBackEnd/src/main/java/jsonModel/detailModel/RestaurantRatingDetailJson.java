package main.java.jsonModel.detailModel;

import com.google.gson.annotations.SerializedName;

import main.java.databaseModel.RestaurantRating;

public class RestaurantRatingDetailJson {
	@SerializedName(value = "restaurant_rating_id")
	private int restaurantRatingId;
	
	@SerializedName(value = "restaurant_id")
	private int restaurantId;
	
	@SerializedName(value = "user_id")
	private int userId;
	
	@SerializedName(value = "rating_score")
	private int rating;
	
	public void setFromQuery(RestaurantRating query) {
		restaurantRatingId = query.getRestaurantRatingId();
		restaurantId = query.getRestaurantId();
		userId = query.getUserId();
		rating = query.getRating();
	}

	public int getRestaurantRatingId() {
		return restaurantRatingId;
	}

	public void setRestaurantRatingId(int restaurantRatingId) {
		this.restaurantRatingId = restaurantRatingId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	
	
}
