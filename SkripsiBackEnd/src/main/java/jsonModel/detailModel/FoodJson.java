package main.java.jsonModel.detailModel;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import main.java.GlobalVal.JsonName;
import main.java.databaseModel.Food;
import main.java.logic.TasteManagement;
import main.java.logic.TypeManagement;

public class FoodJson {
	
	@SerializedName(value = "food_id")
	private Integer foodId;
	
	@SerializedName(value = "restaurant_id")
	private Integer restaurantId;
	
	@SerializedName(value = "food_name")
	private String foodName;
	
	@SerializedName(value = "deskripsi")
	private String deskripsi;
	
	@SerializedName(value = "price")
	private Integer price;
	
	@SerializedName(value = "image")
	private String image;
	
	@SerializedName(value = "jumlah")
	private int jumlah;
	
	@SerializedName(value = "stock")
	private int stock;
	
	@SerializedName(value = "taste")
	private List<TasteJson> taste;
	
	@SerializedName(value = "type")
	private TypeJson type;
	
	@SerializedName(value = "restaurant_name")
	private String restaurantName;
	
	private transient Double distance;

	public void setFromQuery(Food query) {
		TasteManagement tasteManagement = new TasteManagement();
		TypeManagement typeManagement = new TypeManagement();
		
		foodId = query.getFoodId();
		restaurantId = query.getRestaurantId();
		foodName = query.getFoodName();
		deskripsi = query.getDeskripsi();
		price = query.getPrice();
		image = query.getImage();
		stock = query.getStock();
		jumlah = 0;
		
		taste = tasteManagement.GetListFromFood(foodId);
		type = typeManagement.GetListFromFood(foodId);
	}
	
	public void setFromJson(JsonObject json) {
		JsonName jsonName = new JsonName();
		List<TasteJson> tasteData = new ArrayList<TasteJson>();
		TypeJson typeJson = new TypeJson();
		typeJson.setFromJson(json.get(jsonName.food.type).getAsJsonObject());
		
		foodId = json.get(jsonName.food.foodId).getAsInt();
		restaurantId = json.get(jsonName.food.restaurantId).getAsInt();
		foodName = json.get(jsonName.food.foodName).getAsString();
		deskripsi = json.get(jsonName.food.deskripsi).getAsString();
		price = json.get(jsonName.food.price).getAsInt();
		jumlah = json.get(jsonName.food.jumlah).getAsInt();
		image = json.get(jsonName.food.image).getAsString();
		stock = json.get(jsonName.food.stock).getAsInt();
		
		type = typeJson;
		
		JsonArray tasteList = json.get(jsonName.tasteOfFood.taste).getAsJsonArray();
		for(int i=0;i<tasteList.size();i++) {
			TasteJson tasteJson = new TasteJson();
			tasteJson.setFromJson(tasteList.get(i).getAsJsonObject());
			tasteData.add(tasteJson);
		}
		taste = tasteData;		
	}
	
	public void setFromJsonOrder(JsonObject json) {
		JsonName jsonName = new JsonName();
		List<TasteJson> tasteData = new ArrayList<TasteJson>();
		TypeJson typeJson = new TypeJson();
		typeJson.setFromJson(json.get(jsonName.food.type).getAsJsonObject());
		
		foodId = json.get(jsonName.food.foodId).getAsInt();
		restaurantId = json.get(jsonName.food.restaurantId).getAsInt();
		foodName = json.get(jsonName.food.foodName).getAsString();
		deskripsi = json.get(jsonName.food.deskripsi).getAsString();
		price = json.get(jsonName.food.price).getAsInt();
		jumlah = json.get(jsonName.food.jumlah).getAsInt();
		type = typeJson;
		
		JsonArray tasteList = json.get(jsonName.tasteOfFood.taste).getAsJsonArray();
		for(int i=0;i<tasteList.size();i++) {
			TasteJson tasteJson = new TasteJson();
			tasteJson.setFromJson(tasteList.get(i).getAsJsonObject());
			tasteData.add(tasteJson);
		}
		taste = tasteData;		
	}
	
	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getDeskripsi() {
		return deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public List<TasteJson> getTaste() {
		return taste;
	}

	public void setTaste(List<TasteJson> taste) {
		this.taste = taste;
	}

	public int getJumlah() {
		return jumlah;
	}

	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}

	public TypeJson getType() {
		return type;
	}

	public void setType(TypeJson type) {
		this.type = type;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}
