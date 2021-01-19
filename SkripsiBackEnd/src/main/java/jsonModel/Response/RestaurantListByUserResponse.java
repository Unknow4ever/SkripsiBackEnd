package main.java.jsonModel.Response;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import main.java.jsonModel.detailModel.RestaurantJson;
import main.java.jsonModel.detailModel.ResultResponse;

public class RestaurantListByUserResponse {
	@SerializedName(value = "restaurant")
	private List<RestaurantJson> restaurant;
	
	@SerializedName(value = "result_response")
	private ResultResponse resultResponse;

	public List<RestaurantJson> getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(List<RestaurantJson> restaurant) {
		this.restaurant = restaurant;
	}

	public ResultResponse getResultResponse() {
		return resultResponse;
	}

	public void setResultResponse(ResultResponse resultResponse) {
		this.resultResponse = resultResponse;
	}
}
