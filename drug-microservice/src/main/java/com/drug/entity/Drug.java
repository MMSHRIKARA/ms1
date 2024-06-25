package com.drug.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Document("drugs")
public class Drug {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//private int drugId;
	private String drugName;
	private int drugPrice;

	public Drug() {

	}

	public Drug(int id, String drugName, int drugPrice) {
		super();
		this.id = id;
		this.drugName = drugName;
		this.drugPrice = drugPrice;
	}

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
