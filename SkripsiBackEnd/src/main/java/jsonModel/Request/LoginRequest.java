package main.java.jsonModel.Request;

import com.google.gson.JsonObject;

import main.java.GlobalVal.JsonName;

public class LoginRequest {
	private String username;
	private String password;
	
	public void setFromJson(JsonObject json) {
		JsonName jsonName = new JsonName();
		
		username = json.get(jsonName.userData.userName).getAsString();
		password = json.get(jsonName.userData.password).getAsString();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
