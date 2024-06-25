package com.drug.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.DTO.DrugDTO;
import com.drug.entity.Drug;
import com.drug.exception.DrugNotFoundException;
import com.drug.service.DrugService;
import com.drug.service.DrugServiceImpl;

import jakarta.validation.Valid;


@RestController
@CrossOrigin("*")
public class DrugController {
	
	@Autowired
	private DrugServiceImpl drugService;
	
	@PostMapping("/addDrug")
	public Drug addDrug(@Valid@RequestBody DrugDTO drugDao) {
		Drug drug=new Drug(drugDao.getId(),drugDao.getDrugName(),drugDao.getDrugPrice());
		return this.drugService.addDrug(drug);
	}
	
	@GetMapping("/viewDrug")
	public List<Drug> getDrug(){
		return this.drugService.getDrug();
		
}
	@DeleteMapping("/deleteDrug/{id}")
	public Drug deleteDrugById(@PathVariable Integer id) throws DrugNotFoundException {
		return this.drugService.deleteDrugById(id);
	}
	
	@GetMapping("/getDrugById/{drugId}")
	public Optional<Drug> getDrugById(@PathVariable Integer drugId) {
		return this.drugService.getDrugById(drugId);
	}
	
	@PutMapping("/editDrug")
	public Drug editDrug(@RequestBody DrugDTO drugDao) throws DrugNotFoundException {
		return this.drugService.editDrug(drugDao);
	}
}
