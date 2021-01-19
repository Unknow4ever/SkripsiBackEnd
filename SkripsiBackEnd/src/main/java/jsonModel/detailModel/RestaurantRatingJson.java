package main.java.jsonModel.detailModel;

import com.google.gson.annotations.SerializedName;

public class RestaurantRatingJson {
	@SerializedName(value = "rating_score")
	private Double rating;
	
	@SerializedName(value = "user_number")
	private Integer userNumber;

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Integer getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(Integer userNumber) {
		this.userNumber = userNumber;
	}
	
	
}
