package main.java.jsonModel.detailModel;

import java.sql.Time;
import java.text.SimpleDateFormat;

import com.google.gson.annotations.SerializedName;

import main.java.databaseModel.Restaurant;
import main.java.logic.RestaurantManagement;

public class RestaurantJson {

	@SerializedName(value = "restaurant_id")
	private Integer restaurantId;
	
	@SerializedName(value = "restaurant_name")
	private String restaurantName;
	
	@SerializedName(value = "user_id")
	private int userId;
	
	@SerializedName(value = "latitude")
	private double latitude;
	
	@SerializedName(value = "longitude")
	private double longitude;
	
	@SerializedName(value = "no_telp")
	private String nomorTelepon;
	
	@SerializedName(value = "open")
	private String openHours;
	
	@SerializedName(value = "close")
	private String closeHours;
	
	@SerializedName(value = "deskripsi")
	private String deskripsi;
	
	@SerializedName(value = "jenis_makanan")
	private String jenisMakanan;
	
	@SerializedName(value = "image")
	private String image;
	
	@SerializedName(value = "rating_result")
	private RestaurantRatingJson rating;
	
	@SerializedName(value = "status")
	private int status;
	
	private transient SimpleDateFormat dateParser = new SimpleDateFormat ("yyyy-MM-dd kk:mm:ss");	
	
	private transient Double distance;
	
	public void setFromQuery(Restaurant query) {
		this.restaurantId = query.getRestaurantId();
		this.restaurantName = query.getRestaurantName();
		this.latitude = query.getLatitude();
		this.longitude = query.getLongitude();
		this.nomorTelepon = query.getNomorTelepon();
		this.openHours = dateParser.format(query.getOpenHours());
		this.closeHours = dateParser.format(query.getCloseHours());
		this.deskripsi = query.getDeskripsi();
		this.jenisMakanan = query.getJenisMakanan();
		this.image = query.getImage();
		this.userId = query.getUserId();
		this.status = query.getStatus();
		
		RestaurantManagement restaurantManagement = new RestaurantManagement();
		this.rating = restaurantManagement.getRestaurantRating(restaurantId);
	}
	
	public void setDistance(double lat,double lon) {
		double theta = lon - longitude;
		double dist = Math.sin(Math.toRadians(lat)) * Math.sin(Math.toRadians(latitude)) + Math.cos(Math.toRadians(lat)) * Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(theta));
		dist = Math.acos(dist);
		dist = Math.toDegrees(dist);
		dist = dist * 60 * 1.1515;		
		dist = dist * 1.609344 * 1000;
		
		distance = dist;
	}
	
	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
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

	public String getNomorTelepon() {
		return nomorTelepon;
	}

	public void setNomorTelepon(String nomorTelepon) {
		this.nomorTelepon = nomorTelepon;
	}

	public String getOpenHours() {
		return openHours;
	}

	public void setOpenHours(Time openHours) {
		this.openHours = dateParser.format(openHours);
	}

	public String getCloseHours() {
		return closeHours;
	}

	public void setCloseHours(Time closeHours) {
		this.closeHours = dateParser.format(closeHours);
	}

	public String getDeskripsi() {
		return deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	public String getJenisMakanan() {
		return jenisMakanan;
	}

	public void setJenisMakanan(String jenisMakanan) {
		this.jenisMakanan = jenisMakanan;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public RestaurantRatingJson getRating() {
		return rating;
	}

	public void setRating(RestaurantRatingJson rating) {
		this.rating = rating;
	}

	public Double getDistance() {
		return distance;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
