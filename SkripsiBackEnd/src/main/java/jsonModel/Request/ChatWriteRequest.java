package main.java.jsonModel.Request;

import com.google.gson.JsonObject;

import main.java.GlobalVal.JsonName;

public class ChatWriteRequest {
	private int orderId;
	private String chat;
	private int userId;
	
	public void setFromJson(JsonObject json) {
		JsonName jsonName = new JsonName();
		
		orderId = json.get(jsonName.chat.orderId).getAsInt();
		chat = json.get(jsonName.chat.chat).getAsString();
		userId = json.get(jsonName.chat.userId).getAsInt();
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getChat() {
		return chat;
	}

	public void setChat(String chat) {
		this.chat = chat;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
