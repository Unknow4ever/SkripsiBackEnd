package main.java.jsonModel.Request;

import com.google.gson.JsonObject;

import main.java.GlobalVal.JsonName;

public class RestaurantCommentListRequest {
	private int restaurantId;

	public void setFromJson(JsonObject json) {
		JsonName jsonName = new JsonName();
		
		restaurantId = json.get(jsonName.restaurant.restaurantId).getAsInt();
	}
	
	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}	
}
