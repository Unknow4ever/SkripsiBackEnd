package main.java.jsonModel.detailModel;

import java.text.SimpleDateFormat;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import main.java.GlobalVal.JsonName;
import main.java.databaseModel.Chat;
import main.java.logic.UserManagement;

public class ChatJson {
	@SerializedName(value = "chat_id")
	private Integer chatId;
	
	@SerializedName(value = "order_id")
	private Integer orderId;

	@SerializedName(value = "user_id")
	private Integer userId;
	
	@SerializedName(value = "chat")
	private String chat;
	
	@SerializedName(value = "create_date")
	private String createdDate;
	
	@SerializedName(value = "update_date")
	private String updateDate;
	
	@SerializedName(value = "user_data")
	private UserDataJson userData;
	
	private transient SimpleDateFormat dateParser = new SimpleDateFormat ("yyyy-MM-dd kk:mm:ss");	
		
	public void setFromQuery(Chat query) {
		UserManagement userManagement = new UserManagement();
		
		chatId = query.getChatId();
		orderId = query.getOrderId();
		userId = query.getUserId();
		chat = query.getChat();
		createdDate = dateParser.format(query.getCreatedDate());
		updateDate = dateParser.format(query.getUpdateDate());
		
		userData = userManagement.getUserDetail(userId);
	}	

	public Integer getRestaurantId() {
		return chatId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.chatId = restaurantId;
	}

	public Integer getOrdereId() {
		return orderId;
	}

	public void setOrdereId(Integer ordereId) {
		this.orderId = ordereId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getChat() {
		return chat;
	}

	public void setChat(String chat) {
		this.chat = chat;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public UserDataJson getUserData() {
		return userData;
	}

	public void setUserData(UserDataJson userData) {
		this.userData = userData;
	}

	
}
