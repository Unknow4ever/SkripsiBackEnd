package main.java.jsonModel.Response;

import com.google.gson.annotations.SerializedName;

import main.java.jsonModel.detailModel.RestaurantRatingJson;
import main.java.jsonModel.detailModel.ResultResponse;

public class RestaurantRatingResponse {
	@SerializedName(value = "result_response")
	private ResultResponse resultResponse;
	
	@SerializedName(value = "rating_result")
	private RestaurantRatingJson restaurantRatingJson;

	public ResultResponse getResultResponse() {
		return resultResponse;
	}

	public void setResultResponse(ResultResponse resultResponse) {
		this.resultResponse = resultResponse;
	}

	public RestaurantRatingJson getRestaurantRatingJson() {
		return restaurantRatingJson;
	}

	public void setRestaurantRatingJson(RestaurantRatingJson restaurantRatingJson) {
		this.restaurantRatingJson = restaurantRatingJson;
	}
	
	
}
