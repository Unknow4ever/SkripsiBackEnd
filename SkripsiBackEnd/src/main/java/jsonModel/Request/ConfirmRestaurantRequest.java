package main.java.jsonModel.Request;

import com.google.gson.JsonObject;

import main.java.GlobalVal.JsonName;

public class ConfirmRestaurantRequest {
	private int restaurantId;
	private int status;

	public void setFromJson(JsonObject json) {
		JsonName jsonName = new JsonName();
		
		restaurantId = json.get(jsonName.restaurant.restaurantId).getAsInt();
		status = json.get(jsonName.restaurant.status).getAsInt();
	}
	
	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
