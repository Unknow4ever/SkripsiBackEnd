package main.java.jsonModel.Response;

import com.google.gson.annotations.SerializedName;

import main.java.jsonModel.detailModel.ResultResponse;

public class DeleteFoodResponse {
	@SerializedName(value = "result_response")
	private ResultResponse resultResponse;

	public ResultResponse getResultResponse() {
		return resultResponse;
	}

	public void setResultResponse(ResultResponse resultResponse) {
		this.resultResponse = resultResponse;
	}
	
	
}
