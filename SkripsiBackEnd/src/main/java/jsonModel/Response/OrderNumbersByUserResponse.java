package main.java.jsonModel.Response;

import com.google.gson.annotations.SerializedName;

import main.java.jsonModel.detailModel.ResultResponse;

public class OrderNumbersByUserResponse {
	@SerializedName(value = "result_response")
	private ResultResponse resultResponse;
	
	@SerializedName(value = "order_numbers")
	private int orderNumbers;

	public ResultResponse getResultResponse() {
		return resultResponse;
	}

	public void setResultResponse(ResultResponse resultResponse) {
		this.resultResponse = resultResponse;
	}

	public int getOrderNumbers() {
		return orderNumbers;
	}

	public void setOrderNumbers(int orderNumbers) {
		this.orderNumbers = orderNumbers;
	}
	
	
}
