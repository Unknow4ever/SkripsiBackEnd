package main.java.jsonModel.Response;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import main.java.jsonModel.detailModel.FoodJson;
import main.java.jsonModel.detailModel.RestaurantCommentJson;
import main.java.jsonModel.detailModel.RestaurantJson;
import main.java.jsonModel.detailModel.ResultResponse;

public class RestaurantDetailResponse {
	@SerializedName(value = "result_response")
	private ResultResponse resultResponse;
	
	@SerializedName(value = "restaurant")
	private RestaurantJson restaurantJson;

	@SerializedName(value = "restaurant_comment")
	private List<RestaurantCommentJson> restaurantCommentJson;

	@SerializedName(value = "food")
	private List<FoodJson> foodJson;
	
	public ResultResponse getResultResponse() {
		return resultResponse;
	}

	public void setResultResponse(ResultResponse resultResponse) {
		this.resultResponse = resultResponse;
	}

	public RestaurantJson getRestaurantJson() {
		return restaurantJson;
	}

	public void setRestaurantJson(RestaurantJson restaurantJson) {
		this.restaurantJson = restaurantJson;
	}

	public List<RestaurantCommentJson> getRestaurantCommentJson() {
		return restaurantCommentJson;
	}

	public void setRestaurantCommentJson(List<RestaurantCommentJson> restaurantCommentJson) {
		this.restaurantCommentJson = restaurantCommentJson;
	}

	public List<FoodJson> getFoodJson() {
		return foodJson;
	}

	public void setFoodJson(List<FoodJson> foodJson) {
		this.foodJson = foodJson;
	}	
	
	
}
