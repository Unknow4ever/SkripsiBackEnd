package main.java.jsonModel.Request;

import com.google.gson.JsonObject;
import main.java.GlobalVal.JsonName;

public class UtilityRequest {
	String utilityName;

	public void setFromJson(JsonObject request) {
		JsonName jsonName = new JsonName();
		
		utilityName = request.get(jsonName.utility.utilityName).getAsString();
	}
	
	public String getUtilityName() {
		return utilityName;
	}

	public void setUtilityName(String utilityName) {
		this.utilityName = utilityName;
	}
	
	
}
