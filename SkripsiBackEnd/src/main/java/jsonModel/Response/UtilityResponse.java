package main.java.jsonModel.Response;

import com.google.gson.annotations.SerializedName;

import main.java.jsonModel.detailModel.ResultResponse;
import main.java.jsonModel.detailModel.UtilityJson;

public class UtilityResponse {
	@SerializedName(value = "utility")
	private UtilityJson utilityJson;
	
	@SerializedName(value = "result_response")
	private ResultResponse resultResponse;

	public UtilityJson getUtilityJson() {
		return utilityJson;
	}

	public void setUtilityJson(UtilityJson utilityJson) {
		this.utilityJson = utilityJson;
	}

	public ResultResponse getResultResponse() {
		return resultResponse;
	}

	public void setResultResponse(ResultResponse resultResponse) {
		this.resultResponse = resultResponse;
	}
	
	
}
