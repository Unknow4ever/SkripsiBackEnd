package main.java.jsonModel.detailModel;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

import main.java.databaseModel.RestaurantComment;
import main.java.logic.UserManagement;

public class RestaurantCommentJson {

	@SerializedName(value = "restaurant_id")
	private Integer restaurantId;
	
	@SerializedName(value = "restaurant_comment_id")
	private Integer restaurantCommentId;

	@SerializedName(value = "user_id")
	private Integer userId;
	
	@SerializedName(value = "comment")
	private String comment;
	
	@SerializedName(value = "create_date")
	private String createdDate;
	
	@SerializedName(value = "update_date")
	private String updateDate;
	
	@SerializedName(value = "user_data")
	private UserDataJson userData;
	
	private transient SimpleDateFormat dateParser = new SimpleDateFormat ("yyyy-MM-dd kk:mm:ss");	
	
	public void setFromQuery(RestaurantComment query) {
		UserManagement userManagement = new UserManagement();
		
		restaurantId = query.getRestaurantId();
		restaurantCommentId = query.getRestaurantCommentId();
		userId = query.getUserId();
		comment = query.getComment();
		createdDate = dateParser.format(query.getCreatedDate());
		updateDate = dateParser.format(query.getUpdateDate());
		
		userData = userManagement.getUserDetail(userId);
	}
	
	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Integer getRestaurantCommentId() {
		return restaurantCommentId;
	}

	public void setRestaurantCommentId(Integer restaurantCommentId) {
		this.restaurantCommentId = restaurantCommentId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = dateParser.format(createdDate);
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = dateParser.format(updateDate);
	}
	
	
}
