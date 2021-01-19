package main.java.jsonModel.Response;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import main.java.jsonModel.detailModel.FoodJson;
import main.java.jsonModel.detailModel.ResultResponse;

public class SearchFoodResponse {
	
	@SerializedName(value = "food")
	private List<FoodJson> food;
	
	@SerializedName(value = "result_response")
	private ResultResponse resultResponse;

	public List<FoodJson> getFood() {
		return food;
	}

	public void setFood(List<FoodJson> food) {
		this.food = food;
	}

	public ResultResponse getResultResponse() {
		return resultResponse;
	}

	public void setResultResponse(ResultResponse resultResponse) {
		this.resultResponse = resultResponse;
	}	
	
}
