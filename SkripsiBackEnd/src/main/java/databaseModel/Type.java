package main.java.databaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="type")
@DynamicUpdate
public class Type {
	@Id
	@Column(name="type_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer typeId;
	
	@Column(name="type_name",length=100,nullable=false)
	private String typeName;
	
	

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
