package main.java.databaseModel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import main.java.jsonModel.Request.ChatWriteRequest;

@Entity
@Table(name="chat")
@DynamicUpdate
public class Chat {
	@Id
	@Column(name="chat_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer chatId;
	
	@Column(name="order_id",length=100,nullable=false)
	private Integer orderId;

	@Column(name="user_id",length=100,nullable=false)
	private Integer userId;
	
	@Column(name="chat",length=300,nullable=false)
	private String chat;
	
	@Column(name="create_date",nullable=false)
	private Date createdDate;
	
	@Column(name="update_date",nullable=false)
	private Date updateDate;
	
	public void setFromRequest(ChatWriteRequest request) {
		Date date = new Date();
		
		orderId = request.getOrderId();
		userId = request.getUserId();
		chat = request.getChat();
		createdDate = date;
		updateDate = date;		
	}

	public Integer getChatId() {
		return chatId;
	}

	public void setChatId(Integer chatId) {
		this.chatId = chatId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
}
