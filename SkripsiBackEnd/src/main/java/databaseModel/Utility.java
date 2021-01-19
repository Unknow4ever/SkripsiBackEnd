package main.java.databaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="utility")
@DynamicUpdate
public class Utility {

	@Id
	@Column(name="utility_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer utilityId;
	
	@Column(name="utility_name",length=100,nullable=false, unique=true)
	private String utilityName;
	
	@Column(name="value",length=100,nullable=false,columnDefinition="Longtext")
	private String value;

	public Integer getUtilityId() {
		return utilityId;
	}

	public void setUtilityId(Integer utilityId) {
		this.utilityId = utilityId;
	}

	public String getUtilityName() {
		return utilityName;
	}

	public void setUtilityName(String utilityName) {
		this.utilityName = utilityName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
