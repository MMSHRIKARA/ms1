package com.drug.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.drug.entity.Drug;
import com.drug.exception.DrugNotFoundException;
import com.drug.repo.DrugRepo;

@ExtendWith(MockitoExtension.class)
public class DrugServiceImplTests {
	
	@Mock
	private DrugRepo drugRepo;
	
	@InjectMocks
	private DrugServiceImpl drugServiceImpl;
	
	@Test
	public void findAll_should_return_drugsDetails() {
		Drug drug=this.buildTestingDrug();
		
		when(drugRepo.findAll()).thenReturn(List.of(drug));
		List<Drug> drugList=this.drugServiceImpl.getDrug();
		
		assertEquals(1, drugList.size());
		verify(this.drugRepo).findAll();
	}
	
	@Test
	public void add_drug_should_add_drug() {
		Drug drug=this.buildTestingDrug();
		
		this.drugServiceImpl.addDrug(drug);
		verify(this.drugRepo).save(drug);
		
	}
	
//	@Test
//	public void delete_should_the_drug() throws DrugNotFoundException {
//		this.drugServiceImpl.deleteDrugById(1);
//		verify(this.drugRepo).deleteById(1);
//	}
	

    @Test
    public void testDeleteDrugById() throws DrugNotFoundException {
        
        Integer drugId = 1;
        Drug drug = new Drug(drugId,"dolo",12);

        when(drugRepo.findById(drugId)).thenReturn(Optional.of(drug));

      
        Drug deletedDrug = drugServiceImpl.deleteDrugById(drugId);

        assertNotNull(deletedDrug);
        assertEquals(drugId, deletedDrug.getId());
    }

	
	@Test
	public void findById_should_get_drug() {
		Drug drug=this.buildTestingDrug();
		
		when(drugRepo.findById(1)).thenReturn(Optional.of(drug));
		Optional returnedDrug=this.drugServiceImpl.getDrugById(1);
		assertEquals(drug.getId(), ((Drug) returnedDrug.get()).getId());
		verify(this.drugRepo).findById(1);
	}
	
	private Drug buildTestingDrug() {
		// TODO Auto-generated method stub
		Drug drug=new Drug();
		drug.setId(1);
		drug.setDrugName("dolo");
		drug.setDrugPrice(10);
		return drug;
	}


}
