package com.supplier.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("drugs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drug {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//private int drugId;
	private String drugName;
	private int drugPrice;


	

//	public int getDrugId() {
//		return drugId;
//	}
//
//	public void setDrugId(int drugId) {
//		this.drugId = drugId;
//	}
	

	public String getDrugName() {
		return drugName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public int getDrugPrice() {
		return drugPrice;
	}

	public void setDrugPrice(int drugPrice) {
		this.drugPrice = drugPrice;
	}

}
