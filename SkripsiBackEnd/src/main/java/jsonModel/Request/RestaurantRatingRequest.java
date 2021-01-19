package main.java.jsonModel.Request;

import com.google.gson.JsonObject;

import main.java.GlobalVal.JsonName;

public class RestaurantRatingRequest {
	private Integer restaurantId;
	
	public void setFromJson(JsonObject json) {
		JsonName jsonName = new JsonName();
		
		restaurantId = json.get(jsonName.restaurantRating.restaurantId).getAsInt();
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	
}
