package main.java.jsonModel.Request;

import com.google.gson.JsonObject;

import main.java.GlobalVal.JsonName;

public class RestaurantListByUserRequest {
	private Integer userId;
	private Integer admin;
	
	public void setFromJson(JsonObject json) {
		JsonName jsonName = new JsonName();
		
		userId = json.get(jsonName.restaurantRating.userId).getAsInt();
		admin = json.get(jsonName.userData.admin).getAsInt();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAdmin() {
		return admin;
	}

	public void setAdmin(Integer admin) {
		this.admin = admin;
	}
	
	
}
