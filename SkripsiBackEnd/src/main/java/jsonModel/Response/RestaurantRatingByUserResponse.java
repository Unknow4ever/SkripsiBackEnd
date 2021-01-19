package main.java.jsonModel.Response;

import com.google.gson.annotations.SerializedName;

import main.java.jsonModel.detailModel.RestaurantRatingDetailJson;
import main.java.jsonModel.detailModel.ResultResponse;

public class RestaurantRatingByUserResponse {
	@SerializedName(value = "result_response")
	private ResultResponse resultResponse;
	
	@SerializedName(value = "rating_result")
	private RestaurantRatingDetailJson restaurantRatingDetailJson;

	public ResultResponse getResultResponse() {
		return resultResponse;
	}

	public void setResultResponse(ResultResponse resultResponse) {
		this.resultResponse = resultResponse;
	}

	public RestaurantRatingDetailJson getRestaurantRatingDetailJson() {
		return restaurantRatingDetailJson;
	}

	public void setRestaurantRatingDetailJson(RestaurantRatingDetailJson restaurantRatingDetailJson) {
		this.restaurantRatingDetailJson = restaurantRatingDetailJson;
	}
	
	
}
