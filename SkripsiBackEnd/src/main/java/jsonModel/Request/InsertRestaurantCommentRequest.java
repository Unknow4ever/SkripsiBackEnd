package main.java.jsonModel.Request;

import com.google.gson.JsonObject;

import main.java.GlobalVal.JsonName;

public class InsertRestaurantCommentRequest {
	String comment;
	int restaurantId;
	int userId;
	
	public void setFromJson(JsonObject json) {
		JsonName jsonName = new JsonName();
		
		comment = json.get(jsonName.restaurantComment.comment).getAsString();
		restaurantId = json.get(jsonName.restaurantComment.restaurantId).getAsInt();
		userId = json.get(jsonName.restaurantComment.userId).getAsInt();
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
