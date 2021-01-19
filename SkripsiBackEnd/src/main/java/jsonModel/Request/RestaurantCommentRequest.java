package main.java.jsonModel.Request;

import java.util.Date;

import com.google.gson.JsonObject;

import main.java.GlobalVal.JsonName;

public class RestaurantCommentRequest {
	private Integer restaurantId;
	private Integer userId;
	private String comment;
	
	public void setFromJson(JsonObject request) {
		JsonName jsonName = new JsonName();
		
		restaurantId = request.get(jsonName.restaurantComment.restaurantId).getAsInt();
		userId = request.get(jsonName.restaurantComment.userId).getAsInt();
		comment = request.get(jsonName.restaurantComment.comment).getAsString();
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}

