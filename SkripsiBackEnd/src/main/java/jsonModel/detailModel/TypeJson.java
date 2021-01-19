package main.java.jsonModel.detailModel;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import main.java.GlobalVal.JsonName;
import main.java.databaseModel.Type;

public class TypeJson {
	@SerializedName(value = "type_id")
	private Integer typeId;
	
	@SerializedName(value = "type_name")
	private String typeName;
	
	public void setFromJson(JsonObject request) {
		JsonName jsonName = new JsonName();
		
		typeId = request.get(jsonName.type.typeId).getAsInt();
		typeName = request.get(jsonName.type.typeName).getAsString();
	}
	
	public void setFromQuery(Type query) {
		typeId = query.getTypeId();
		typeName = query.getTypeName();
	}

	public Integer getTypeId() {
		return typeId; 
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	  
}
