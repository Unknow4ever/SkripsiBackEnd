package main.java.jsonModel.Request;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import main.java.GlobalVal.JsonName;
import main.java.jsonModel.detailModel.TasteJson;
import main.java.jsonModel.detailModel.TypeJson;

public class UpdateFoodRequest {
	private Integer restaurantId;
	private String foodName;
	private String deskripsi;
	private Integer price;
	private Integer stock;
	private String image;
	private List<TasteJson> taste;
	private TypeJson type;
	private Integer foodId;

	public void setFromJson(JsonObject request) {
		JsonName jsonName = new JsonName();
		List<TasteJson> tasteData = new ArrayList<TasteJson>();
		TypeJson typeJson = new TypeJson();
		typeJson.setFromJson(request.get(jsonName.food.type).getAsJsonObject());
		
		restaurantId = request.get(jsonName.food.restaurantId).getAsInt();
		foodName = request.get(jsonName.food.foodName).getAsString();
		deskripsi = request.get(jsonName.food.deskripsi).getAsString();
		price = request.get(jsonName.food.price).getAsInt();
		image = request.get(jsonName.food.image).getAsString();
		foodId = request.get(jsonName.food.foodId).getAsInt();
		stock = request.get(jsonName.food.stock).getAsInt();
		type = typeJson;
		
		JsonArray tasteList = request.get(jsonName.tasteOfFood.taste).getAsJsonArray();
		for(int i=0;i<tasteList.size();i++) {
			TasteJson tasteJson = new TasteJson();
			tasteJson.setFromJson(tasteList.get(i).getAsJsonObject());
			tasteData.add(tasteJson);
		}
		taste = tasteData;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
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

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
}
