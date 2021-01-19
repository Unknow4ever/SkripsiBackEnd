package main.java.databaseModel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import main.java.jsonModel.Request.InsertRestaurantCommentRequest;

@Entity
@Table(name="restaurant_comment")
@DynamicUpdate
public class RestaurantComment {
	@Id
	@Column(name="restaurant_comment_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer RestaurantCommentId;
	
	@Column(name="restaurant_id",length=100,nullable=false)
	private Integer restaurantId;

	@Column(name="user_id",length=100,nullable=false)
	private Integer userId;
	
	@Column(name="comment",length=300,nullable=false)
	private String comment;
	
	@Column(name="create_date",nullable=false)
	private Date createdDate;
	
	@Column(name="update_date",nullable=false)
	private Date updateDate;

	public void setFromRequest(InsertRestaurantCommentRequest request) {
		Date date = new Date();
		
		restaurantId = request.getRestaurantId();
		userId = request.getUserId();
		comment = request.getComment();
		createdDate = date;
		updateDate = date;
	}
	
	public Integer getRestaurantCommentId() {
		return RestaurantCommentId;
	}

	public void setRestaurantCommentId(Integer restaurantCommentId) {
		RestaurantCommentId = restaurantCommentId;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
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
