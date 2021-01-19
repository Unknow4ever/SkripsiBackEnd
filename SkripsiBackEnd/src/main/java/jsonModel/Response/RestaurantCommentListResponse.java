package main.java.jsonModel.Response;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import main.java.jsonModel.detailModel.RestaurantCommentJson;
import main.java.jsonModel.detailModel.ResultResponse;

public class RestaurantCommentListResponse {
	@SerializedName(value = "result_response")
	private ResultResponse resultResponse;
	
	@SerializedName(value = "restaurant_comment")
	private List<RestaurantCommentJson> restaurantCommentJson;

	public ResultResponse getResultResponse() {
		return resultResponse;
	}

	public void setResultResponse(ResultResponse resultResponse) {
		this.resultResponse = resultResponse;
	}

	public List<RestaurantCommentJson> getRestaurantCommentJson() {
		return restaurantCommentJson;
	}

	public void setRestaurantCommentJson(List<RestaurantCommentJson> restaurantCommentJson) {
		this.restaurantCommentJson = restaurantCommentJson;
	}
}
