package main.java.jsonModel.Response;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import main.java.jsonModel.detailModel.ChatJson;
import main.java.jsonModel.detailModel.RestaurantCommentJson;
import main.java.jsonModel.detailModel.ResultResponse;

public class ChatViewResponse {
	@SerializedName(value = "result_response")
	private ResultResponse resultResponse;
	
	@SerializedName(value = "chat")
	private List<ChatJson> chat;

	public ResultResponse getResultResponse() {
		return resultResponse;
	}

	public void setResultResponse(ResultResponse resultResponse) {
		this.resultResponse = resultResponse;
	}

	public List<ChatJson> getChat() {
		return chat;
	}

	public void setChat(List<ChatJson> chat) {
		this.chat = chat;
	}

	
}
