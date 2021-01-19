package main.java.jsonModel.Request;

import com.google.gson.JsonObject;

import main.java.GlobalVal.JsonName;

public class ProcessOrderRequest {
private Integer orderId;
	
	public void setFromJson(JsonObject json) {
		JsonName jsonName = new JsonName();
		
		orderId = json.get(jsonName.orderHeader.orderId).getAsInt();
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	
}
