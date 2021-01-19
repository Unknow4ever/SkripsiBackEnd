package main.java.jsonModel.Response;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import main.java.jsonModel.detailModel.ResultResponse;
import main.java.jsonModel.detailModel.TypeJson;

public class TypeListResponse {
	@SerializedName(value = "type")
	private List<TypeJson> typeJson;
	
	@SerializedName(value = "result_response")
	private ResultResponse resultResponse;

	public List<TypeJson> getTypeJson() {
		return typeJson;
	}

	public void setTypeJson(List<TypeJson> typeJson) {
		this.typeJson = typeJson;
	}

	public ResultResponse getResultResponse() {
		return resultResponse;
	}

	public void setResultResponse(ResultResponse resultResponse) {
		this.resultResponse = resultResponse;
	}
	
	
}
