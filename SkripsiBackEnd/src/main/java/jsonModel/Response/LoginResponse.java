package main.java.jsonModel.Response;

import com.google.gson.annotations.SerializedName;

import main.java.jsonModel.detailModel.ResultResponse;
import main.java.jsonModel.detailModel.UserDataJson;

public class LoginResponse {
	
	@SerializedName(value = "user_data")
	private UserDataJson userDataJson;
	
	@SerializedName(value = "result_response")
	private ResultResponse resultResponse;
	
	public UserDataJson getUserDataJson() {
		return userDataJson;
	}
	public void setUserDataJson(UserDataJson userDataJson) {
		this.userDataJson = userDataJson;
	}
	public ResultResponse getResultResponse() {
		return resultResponse;
	}
	public void setResultResponse(ResultResponse resultResponse) {
		this.resultResponse = resultResponse;
	}
}
