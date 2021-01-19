package main.java.jsonModel.detailModel;

import com.google.gson.annotations.SerializedName;

public class ResultResponse {
	@SerializedName(value = "status")
	private String status;

	@SerializedName(value = "message")
	private String message;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
