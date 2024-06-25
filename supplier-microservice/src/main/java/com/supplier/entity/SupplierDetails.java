package com.supplier.entity;

import jakarta.persistence.Id;
import lombok.Data;


@Data
public class SupplierDetails {

	@Id
	private Long id;
    private String name;
    private String contact;
    private String email;
    
    private String drugId;
	
}
