package main.java.jsonModel.Request;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import main.java.GlobalVal.JsonName;
import main.java.jsonModel.detailModel.FoodJson;
import main.java.jsonModel.detailModel.TasteJson;

public class OrderRequest {
	private List<FoodJson> food;
	private int restaurantId;
	private int userId;
	
	public void setFromJson(JsonObject json) {
		JsonName jsonName = new JsonName();
		List<FoodJson> foodData = new ArrayList<FoodJson>();
		
		JsonArray foodList = json.get(jsonName.className.food).getAsJsonArray();
		for(int i=0;i<foodList.size();i++) {
			FoodJson foodJson = new FoodJson();
			foodJson.setFromJsonOrder(foodList.get(i).getAsJsonObject());
			foodData.add(foodJson);
		}
		food = foodData;
		restaurantId = json.get(jsonName.restaurant.restaurantId).getAsInt();
		userId = json.get(jsonName.userData.userId).getAsInt();
	}
	
	public List<FoodJson> getFood() {
		return food;
	}
	public void setFood(List<FoodJson> food) {
		this.food = food;
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
	
	
}
