package main.java.jsonModel.Request;

import java.sql.Time;

import com.google.gson.JsonObject;

import main.java.GlobalVal.JsonName;

public class RegisterRestaurantRequest {
	private int userId;
	private String restaurantName;
	private String jenisMakanan;
	private String deskripsi;
	private String nomorTelepon;
	private Time openHours;
	private Time closeHours;
	private String image;
	private double latitude;
	private double longitude;	
	
	public void setFromJson(JsonObject request) {
		JsonName jsonName = new JsonName();
		
		userId = request.get(jsonName.restaurant.userId).getAsInt();
		restaurantName = request.get(jsonName.restaurant.restaurantName).getAsString();
		jenisMakanan = request.get(jsonName.restaurant.jenisMakanan).getAsString();
		nomorTelepon = request.get(jsonName.restaurant.noTelp).getAsString();
		openHours = Time.valueOf(request.get(jsonName.restaurant.open).getAsString());
		closeHours = Time.valueOf(request.get(jsonName.restaurant.close).getAsString());
		image = request.get(jsonName.restaurant.image).getAsString();
		latitude = request.get(jsonName.restaurant.latitude).getAsDouble();
		longitude = request.get(jsonName.restaurant.longitude).getAsDouble();	
		deskripsi = request.get(jsonName.restaurant.deskripsi).getAsString();
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getJenisMakanan() {
		return jenisMakanan;
	}
	public void setJenisMakanan(String jenisMakanan) {
		this.jenisMakanan = jenisMakanan;
	}
	public String getNomorTelepon() {
		return nomorTelepon;
	}
	public void setNomorTelepon(String nomorTelepon) {
		this.nomorTelepon = nomorTelepon;
	}
	public Time getOpenHours() {
		return openHours;
	}
	public void setOpenHours(Time openHours) {
		this.openHours = openHours;
	}
	public Time getCloseHours() {
		return closeHours;
	}
	public void setCloseHours(Time closeHours) {
		this.closeHours = closeHours;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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

	public String getDeskripsi() {
		return deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}
	
	
}
