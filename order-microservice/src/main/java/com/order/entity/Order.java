package com.order.entity;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Document("order")
public class Order {
	
	@Id
	private int id;
	private String doctorName;
	private String drugName;
	private String drugPrices;
	private int quantities;
	private LocalDate orderDate;
	private OrderStatus status;
	
	public Order() {
		
	}
	
	public Order(int id, String doctorName, String drugName, String drugPrices, int quantities, LocalDate orderDate,OrderStatus status) {
		super();
		this.id = id;
		this.doctorName = doctorName;
		this.drugName = drugName;
		this.drugPrices = drugPrices;
		this.quantities = quantities;
		this.orderDate = orderDate;
		this.status=status;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getDrugPrices() {
		return drugPrices;
	}
	public void setDrugPrices(String drugPrices) {
		this.drugPrices = drugPrices;
	}
	public int getQuantities() {
		return quantities;
	}
	public void setQuantities(int quantities) {
		this.quantities = quantities;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	

}
