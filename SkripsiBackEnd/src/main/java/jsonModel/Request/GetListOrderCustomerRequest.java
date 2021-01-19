package main.java.jsonModel.Request;

import com.google.gson.JsonObject;

import main.java.GlobalVal.JsonName;

public class GetListOrderCustomerRequest {
	private Integer userId;
	
	public void setFromJson(JsonObject json) {
		JsonName jsonName = new JsonName();
		
		userId = json.get(jsonName.restaurantRating.userId).getAsInt();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
