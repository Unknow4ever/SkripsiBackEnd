package main.java.jsonModel.Response;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import main.java.jsonModel.detailModel.ResultResponse;
import main.java.jsonModel.detailModel.TasteJson;

public class TasteListResponse {
	@SerializedName(value = "taste")
	private List<TasteJson> tasteJson;
	
	@SerializedName(value = "result_response")
	private ResultResponse resultResponse;

	public List<TasteJson> getTasteJson() {
		return tasteJson;
	}

	public void setTasteJson(List<TasteJson> tasteJson) {
		this.tasteJson = tasteJson;
	}

	public ResultResponse getResultResponse() {
		return resultResponse;
	}

	public void setResultResponse(ResultResponse resultResponse) {
		this.resultResponse = resultResponse;
	}	
	
	
}
