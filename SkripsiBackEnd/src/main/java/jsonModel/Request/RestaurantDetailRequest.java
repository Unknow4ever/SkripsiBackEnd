package main.java.jsonModel.Request;

import com.google.gson.JsonObject;

import main.java.GlobalVal.JsonName;

public class RestaurantDetailRequest {
	private int RestaurantId;

	public void setFromJson(JsonObject request) {
		JsonName jsonName = new JsonName();
		
		RestaurantId = request.get(jsonName.restaurant.restaurantId).getAsInt();
	}
	
	public int getRestaurantId() {
		return RestaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		RestaurantId = restaurantId;
	}	
	
}
