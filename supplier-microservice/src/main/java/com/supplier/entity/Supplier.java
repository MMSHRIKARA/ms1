package com.supplier.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("supplier")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Supplier {
	
	@Id
	private Long id;
    private String name;
    private String contact;
    private String email;
    private String drugId;
//    private String drugName;
//	private int drugPrice;

    

    
    

}
