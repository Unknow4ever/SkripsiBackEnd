package main.java.jsonModel.Request;

import com.google.gson.JsonObject;

import main.java.GlobalVal.JsonName;

public class RegisterRequest {
	private String userName;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	
	public void setFromJson(JsonObject request) {
		JsonName jsonName = new JsonName();
		
		userName = (request.get(jsonName.userData.userName).getAsString());
		password = (request.get(jsonName.userData.password).getAsString());
		email = (request.get(jsonName.userData.email).getAsString());
		firstName = (request.get(jsonName.userData.firstName).getAsString());
		lastName = (request.get(jsonName.userData.lastName).getAsString());
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
