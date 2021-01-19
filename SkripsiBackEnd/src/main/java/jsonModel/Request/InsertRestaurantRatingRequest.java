package main.java.jsonModel.Request;

import com.google.gson.JsonObject;
import main.java.GlobalVal.JsonName;

public class InsertRestaurantRatingRequest {	
	private Integer restaurantId;
	private Integer userId;
	private Integer rating;
	
	public void setFromJson(JsonObject json) {
		JsonName jsonName = new JsonName();
		
		restaurantId = json.get(jsonName.restaurantRating.restaurantId).getAsInt();
		userId = json.get(jsonName.restaurantRating.userId).getAsInt();
		rating = json.get(jsonName.restaurantRating.ratingScore).getAsInt();
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
