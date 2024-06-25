package com.drug.service;

import java.util.List;
import java.util.Optional;

import com.drug.DTO.DrugDTO;
import com.drug.entity.Drug;
import com.drug.exception.DrugNotFoundException;

import jakarta.validation.Valid;



public interface DrugService {
	
public Drug addDrug(Drug drug);
	
	public List<Drug> getDrug(); 
	
	public Optional<Drug> getDrugById(@Valid Integer drugId);
	
	public Drug deleteDrugById(Integer drugId) throws DrugNotFoundException;
	
	public Drug editDrug(DrugDTO drugDao) throws DrugNotFoundException;

}
