package main.java.databaseModel;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import main.java.jsonModel.Request.RegisterRestaurantRequest;
import main.java.jsonModel.Request.UpdateRestaurantRequest;

@Entity
@Table(name="restaurant")
@DynamicUpdate
public class Restaurant {
	
	@Id
	@Column(name="restaurant_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer restaurantId;
	
	@Column(name="restaurant_name",length=100,nullable=false)
	private String restaurantName;
	
	@Column(name="latitude",nullable=false)
	private double latitude;
	
	@Column(name="longitude",nullable=false)
	private double longitude;
	
	@Column(name="no_telp",length=100,nullable=false)
	private String nomorTelepon;
	
	@Column(name="open",length=100,nullable=false)
	private Time openHours;
	
	@Column(name="close",length=100,nullable=false)
	private Time closeHours;
	
	@Column(name="deskripsi",length=100,nullable=false)
	private String deskripsi;
	
	@Column(name="jenis_makanan",length=100,nullable=false)
	private String jenisMakanan;
	
	@Column(name="image", columnDefinition="Longtext")
	private String image;
	
	@Column(name="user_id", nullable=false)
	private int userId;
	
	@Column(name="active", nullable=false)
	private int active;
	
	@Column(name="status", nullable=false)
	private int status;

	public void setFromRequest(RegisterRestaurantRequest request) {
		restaurantName = request.getRestaurantName();
		latitude = request.getLatitude();
		longitude = request.getLongitude();
		nomorTelepon = request.getNomorTelepon();
		openHours = request.getOpenHours();
		closeHours = request.getCloseHours();
		deskripsi = request.getDeskripsi();
		jenisMakanan = request.getJenisMakanan();
		image = request.getImage();
		userId = request.getUserId();
		active = 1;
	}
	
	public void setFromRequest(UpdateRestaurantRequest request) {
		restaurantId = request.getRestaurantId();
		restaurantName = request.getRestaurantName();
		latitude = request.getLatitude();
		longitude = request.getLongitude();
		nomorTelepon = request.getNomorTelepon();
		openHours = request.getOpenHours();
		closeHours = request.getCloseHours();
		deskripsi = request.getDeskripsi();
		jenisMakanan = request.getJenisMakanan();
		image = request.getImage();
		userId = request.getUserId();
		active = 1;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
