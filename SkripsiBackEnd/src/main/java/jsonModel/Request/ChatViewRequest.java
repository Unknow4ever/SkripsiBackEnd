package main.java.jsonModel.Request;

import com.google.gson.JsonObject;

import main.java.GlobalVal.JsonName;

public class ChatViewRequest {
	private int orderId;

	public void setFromJson(JsonObject json) {
		JsonName jsonName = new JsonName();
		
		orderId = json.get(jsonName.orderHeader.orderId).getAsInt();
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) { 
		this.orderId = orderId;
	}
	
	
}
