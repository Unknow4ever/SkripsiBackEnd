package main.java.jsonModel.detailModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.google.gson.annotations.SerializedName;
import main.java.databaseModel.UserData;

public class UserDataJson {

	@SerializedName(value = "user_id")
	private int userId;
	
	@SerializedName(value = "password")
	private String password;
	
	@SerializedName(value = "user_name")
	private String userName;
	
	@SerializedName(value = "first_name")
	private String firstName;
	
	@SerializedName(value = "last_name")
	private String lastName;
	
	@SerializedName(value = "email")
	private String email;
	
	@SerializedName(value = "create_date")
	private String createDate;
	
	@SerializedName(value = "update_date")
	private String updateDate;
	
	@SerializedName(value = "balance")
	private int balance;
	
	@SerializedName(value = "admin")
	private int admin;
	
	private transient SimpleDateFormat dateParser = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
	
	public void setFromQuery(UserData userData) {
		this.userId = userData.getUserId();
		this.userName = userData.getUserName();
		this.firstName = userData.getFirstName();
		this.lastName = userData.getLastName();
		this.email = userData.getEmail();
		this.createDate = dateParser.format(userData.getCreatedDate());
		this.updateDate = dateParser.format(userData.getUpdateDate());
		this.balance = userData.getBalance();		
		this.admin = userData.getAdmin();
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = dateParser.format(createDate);
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = dateParser.format(updateDate);
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}
	
	
}
