package main.java.jsonModel.detailModel;

import com.google.gson.annotations.SerializedName;

import main.java.databaseModel.Utility;

public class UtilityJson {
	@SerializedName(value = "utility_id")
	private int utilityId;
	
	@SerializedName(value = "utility_name")
	private String utilityName;
	
	@SerializedName(value = "value")
	private String value;

	public void setFromQuery(Utility query) {
		utilityId = query.getUtilityId();
		utilityName = query.getUtilityName();
		value = query.getValue();
	}
	
	public int getUtilityId() {
		return utilityId;
	}

	public void setUtilityId(int utilityId) {
		this.utilityId = utilityId;
	}

	public String getUtilityName() {
		return utilityName;
	}

	public void setUtilityName(String utilityName) {
		this.utilityName = utilityName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
