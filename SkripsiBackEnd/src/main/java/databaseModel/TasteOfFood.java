package main.java.databaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="taste_of_food")
@DynamicUpdate
public class TasteOfFood {
	@Id
	@Column(name="taste_of_food_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tasteOfFoodId;
	
	@Column(name="food_id",length=100,nullable=false)
	private Integer foodId;
	
	@Column(name="taste_id",length=100,nullable=false)
	private Integer tasteId;
	
	public void setFromRequest(int foodIdRequest, int tasteIdRequest) {
		foodId = foodIdRequest;
		tasteId = tasteIdRequest;
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

	public Integer getTasteId() {
		return tasteId;
	}

	public void setTasteId(Integer tasteId) {
		this.tasteId = tasteId;
	}
}
