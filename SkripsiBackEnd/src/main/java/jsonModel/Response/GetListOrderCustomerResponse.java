package main.java.jsonModel.Response;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import main.java.jsonModel.detailModel.OrderHeaderJson;
import main.java.jsonModel.detailModel.ResultResponse;

public class GetListOrderCustomerResponse {
	@SerializedName(value = "result_response")
	private ResultResponse resultResponse;
	
	@SerializedName(value = "order_header")
	private List<OrderHeaderJson> orderHeaderJson;

	public ResultResponse getResultResponse() {
		return resultResponse;
	}

	public void setResultResponse(ResultResponse resultResponse) {
		this.resultResponse = resultResponse;
	}

	public List<OrderHeaderJson> getOrderHeaderJson() {
		return orderHeaderJson;
	}

	public void setOrderHeaderJson(List<OrderHeaderJson> orderHeaderJson) {
		this.orderHeaderJson = orderHeaderJson;
	}

	
	
	
}
