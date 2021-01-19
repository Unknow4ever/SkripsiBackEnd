package main.java.jsonModel.Request;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import main.java.GlobalVal.JsonName;
import main.java.jsonModel.detailModel.TasteJson;
import main.java.jsonModel.detailModel.TypeJson;

public class SearchFoodRequest {
	double latitude;
	double longitude;	
	int range;
	String foodName;
	List<TasteJson> taste;
	TypeJson type;
	
	public void setFromJson(JsonObject request) {
		JsonName jsonName = new JsonName();
		
		latitude = request.get(jsonName.restaurant.latitude).getAsDouble();
		longitude = request.get(jsonName.restaurant.longitude).getAsDouble();
		range = request.get(jsonName.restaurant.range).getAsInt();
		
		try {
			if(request.get(jsonName.food.foodName).getAsString().isEmpty()) {
				foodName = null;
			}
			else {
				foodName = "%"+ request.get(jsonName.food.foodName).getAsString() +"%";
			}
		} catch (Exception e) {
			foodName = null;
		}
		
		try {
			TypeJson typeJson = new TypeJson();
			typeJson.setFromJson(request.get(jsonName.food.type).getAsJsonObject());
			type = typeJson;
		} catch (Exception e) {
			type = null;
		}
		
		try {
			List<TasteJson> tasteJson = new ArrayList<TasteJson>();
			JsonArray tasteList = request.get(jsonName.food.taste).getAsJsonArray();
			
			if(tasteList.size() < 1) {
				tasteJson = null;
			}
			else {
				for(int i=0;i<tasteList.size();i++) {
					TasteJson data = new TasteJson();
					data.setFromJson(tasteList.get(i).getAsJsonObject());
					tasteJson.add(data);
				}
			}
			
			taste = tasteJson;
		} catch (Exception e) {
			taste = null;
		}
	}
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}		
	public double getMinLatitude(){
		double minLatitude;		
		minLatitude = latitude - (range * 0.01);		
		return minLatitude;
	}
	public double getMaxLatitude(){
		double maxLatitude;		
		maxLatitude = latitude + (range * 0.01);		
		return maxLatitude;
	}
	public double getMinLongitude(){
		double minLongitude;		
		minLongitude = longitude - (range * 0.01);		
		return minLongitude;
	}
	public double getMaxLongitude(){
		double maxLongitude;		
		maxLongitude = longitude + (range * 0.01);		
		return maxLongitude;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public List<TasteJson> getTaste() {
		return taste;
	}

	public void setTaste(List<TasteJson> taste) {
		this.taste = taste;
	}

	public TypeJson getType() {
		return type;
	}

	public void setType(TypeJson type) {
		this.type = type;
	}
	
	
}
