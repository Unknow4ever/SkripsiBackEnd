package main.java.jsonModel.Response;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import main.java.jsonModel.detailModel.FoodJson;
import main.java.jsonModel.detailModel.ResultResponse;

public class RestaurantFoodListResponse {
	@SerializedName(value = "result_response")
	private ResultResponse resultResponse;
	
	@SerializedName(value = "food")
	private List<FoodJson> foodJson;

	public ResultResponse getResultResponse() {
		return resultResponse;
	}

	public void setResultResponse(ResultResponse resultResponse) {
		this.resultResponse = resultResponse;
	}

	public List<FoodJson> getFoodJson() {
		return foodJson;
	}

	public void setFoodJson(List<FoodJson> foodJson) {
		this.foodJson = foodJson;
	}
	
	
}
