package main.java.databaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="type_of_food")
@DynamicUpdate
public class TypeOfFood {
	@Id
	@Column(name="type_of_food_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tasteOfFoodId;
	
	@Column(name="food_id",length=100,nullable=false)
	private Integer foodId;
	
	@Column(name="type_id",length=100,nullable=false)
	private Integer typeId;
	
	public void setFromRequest(int foodIdRequest, int typeIdRequest) {
		foodId = foodIdRequest;
		typeId = typeIdRequest;
	}

	public Integer getTasteOfFoodId() {
		return tasteOfFoodId;
	}

	public void setTasteOfFoodId(Integer tasteOfFoodId) {
		this.tasteOfFoodId = tasteOfFoodId;
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
}
