package com.drug.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.DTO.DrugDTO;
import com.drug.entity.Drug;
import com.drug.exception.DrugNotFoundException;
import com.drug.repo.DrugRepo;

import jakarta.validation.Valid;

@Service
public class DrugServiceImpl implements DrugService {

    private static final Logger logger = LoggerFactory.getLogger(DrugServiceImpl.class);

    @Autowired
    private DrugRepo drugRepo;

    @Override
    public Drug addDrug(Drug drug) {
        logger.info("Adding a new drug: {}", drug.getDrugName());
        return this.drugRepo.save(drug);
    }

    @Override
    public List<Drug> getDrug() {
        logger.info("Retrieving all drugs");
        return drugRepo.findAll();
    }

    @Override
    public Drug deleteDrugById(@Valid Integer id) throws DrugNotFoundException {
        logger.info("Deleting a drug with ID: {}", id);
        Optional<Drug> dDrug = this.drugRepo.findById(id);
        if (dDrug.isEmpty()) {
            logger.error("Drug with ID {} not found", id);
            throw new DrugNotFoundException("drugid does not exist to delete");
        }
        this.drugRepo.deleteById(id);
        return dDrug.get();
    }

    @Override
    public Drug editDrug(DrugDTO drugDao) throws DrugNotFoundException {
        logger.info("Editing a drug with ID: {}", drugDao.getId());
        Optional<Drug> drug = this.drugRepo.findById(drugDao.getId());
        if (drug.isEmpty()) {
            logger.error("Drug with ID {} not found", drugDao.getId());
            throw new DrugNotFoundException("drugid does not exist to update");
        }
        Drug updateDrug = drug.get();
        updateDrug.setDrugName(drugDao.getDrugName());
        updateDrug.setDrugPrice(drugDao.getDrugPrice());
        return this.drugRepo.save(updateDrug);
    }

    @Override
    public Optional<Drug> getDrugById(@Valid Integer drugId) {
        logger.info("Retrieving a drug by ID: {}", drugId);
        return this.drugRepo.findById(drugId);
    }
}
