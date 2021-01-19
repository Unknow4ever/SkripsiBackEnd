package main.java.databaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="taste")
@DynamicUpdate
public class Taste {
	@Id
	@Column(name="taste_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tasteId;
	
	@Column(name="taste_name",length=100,nullable=false)
	private String tasteName;

	public Integer getTasteId() {
		return tasteId;
	}

	public void setTasteId(Integer tasteId) {
		this.tasteId = tasteId;
	}

	public String getTasteName() {
		return tasteName;
	}

	public void setTasteName(String tasteName) {
		this.tasteName = tasteName;
	}
	
	
}
