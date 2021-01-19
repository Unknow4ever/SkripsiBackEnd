package main.java.jsonModel.Request;

import com.google.gson.JsonObject;

import main.java.GlobalVal.JsonName;

public class DeleteFoodRequest {
	private int foodId;
	
	public void setFromJson(JsonObject json) {
		JsonName jsonName = new JsonName();
		
		foodId = json.get(jsonName.food.foodId).getAsInt();
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	
	
}
