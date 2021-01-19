package main.java.databaseModel;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="user_data")
@DynamicUpdate
public class UserData {

	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(name="user_name",length=100,nullable=false)
	private String userName;
	
	@Column(name="password",length=100,nullable=false)
	private String password;
	
	@Column(name="email",length=100,nullable=false)
	private String email;
	
	@Column(name="first_name",length=100,nullable=false)
	private String firstName;
	
	@Column(name="last_name",length=100,nullable=false)
	private String lastName;
	
	@Column(name="create_date",length=100,nullable=false)
	private Date createdDate;
	
	@Column(name="update_date",length=100,nullable=false)
	private Date updateDate;
	
	@Column(name="balance",length=100,nullable=false)
	private Integer balance;		
	
	@Column(name="admin",length=100,nullable=false)
	private Integer admin;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Integer getAdmin() {
		return admin;
	}

	public void setAdmin(Integer admin) {
		this.admin = admin;
	}
	
	
	
}
