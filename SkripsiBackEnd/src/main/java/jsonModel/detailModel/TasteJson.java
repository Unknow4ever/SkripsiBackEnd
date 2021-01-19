package main.java.jsonModel.detailModel;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import main.java.GlobalVal.JsonName;
import main.java.databaseModel.Taste;

public class TasteJson {
	@SerializedName(value = "taste_id")
	private Integer tasteId;
	
	@SerializedName(value = "taste_name")
	private String tasteName;
	
	public void setFromJson(JsonObject request) {
		JsonName jsonName = new JsonName();
		
		tasteId = request.get(jsonName.taste.tasteId).getAsInt();
		tasteName = request.get(jsonName.taste.tasteName).getAsString();
	}
	
	public void setFromQuery(Taste query) {
		tasteId = query.getTasteId();
		tasteName = query.getTasteName();
	}

	public Integer getTasteId() {
		return tasteId;
	}

	public void setTasteId(Integer tasteId) {
		this.tasteId = tasteId;
	}

	public String getTasteName() {
		return tasteName;
	}

	public void setTasteName(String tasteName) {
		this.tasteName = tasteName;
	}
	
}
