package main.java.jsonModel.Request;

import com.google.gson.JsonObject;

import main.java.GlobalVal.JsonName;

public class NearbyRestaurantRequest {
	double latitude;
	double longitude;	
	int range;
	
	public void setFromJson(JsonObject json) {
		JsonName jsonName = new JsonName();
		
		latitude = json.get(jsonName.restaurant.latitude).getAsDouble();
		longitude = json.get(jsonName.restaurant.longitude).getAsDouble();
		range = json.get(jsonName.restaurant.range).getAsInt();
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
	
}
