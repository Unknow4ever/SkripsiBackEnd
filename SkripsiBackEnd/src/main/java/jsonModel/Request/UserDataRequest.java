package main.java.jsonModel.Request;

import com.google.gson.JsonObject;

import main.java.GlobalVal.JsonName;

public class UserDataRequest {
	private String username;
	
	public void setFromJson(JsonObject request) {
		JsonName jsonName = new JsonName();
		
		username = request.get(jsonName.userData.userName).getAsString();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
