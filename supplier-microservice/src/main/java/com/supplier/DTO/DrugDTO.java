package com.supplier.DTO;

public class DrugDTO {
	
	private int id;
	private String drugName;
	private int drugPrice;
	
	public DrugDTO() {
		
	}
	public DrugDTO(int id, String drugName, int drugPrice) {
		super();
		this.id = id;
		this.drugName = drugName;
		this.drugPrice = drugPrice;
	}
//	public int getDrugId() {
//		return drugId;
//	}
//	public void setDrugId(int drugId) {
//		this.drugId = drugId;
//	}\
	
	
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
