package com.supplier.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.supplier.DTO.DrugDTO;
import com.supplier.DTO.ResponseDto;
import com.supplier.DTO.SupplierDTO;
import com.supplier.entity.Supplier;
import com.supplier.exception.SupplierInvalidException;
import com.supplier.repo.SupplierRepo;

@Service
public class SupplierServiceImpl implements SupplierService {

    private static final Logger logger = LoggerFactory.getLogger(SupplierServiceImpl.class);

    @Autowired
    private SupplierRepo supplierRepo;
    private RestTemplate restTemplate;

    @Autowired
    public SupplierServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Supplier addSupplier(Supplier supplier) {
        logger.info("Adding a new supplier: {}", supplier.getName());
        return this.supplierRepo.save(supplier);
    }

    @Override
    public List<Supplier> getSupplier() {
        logger.info("Retrieving all suppliers");
        return this.supplierRepo.findAll();
    }

    @Override
    public Optional<Supplier> getSupplierById(Long id) throws SupplierInvalidException {
        logger.info("Retrieving a supplier by ID: {}", id);
        Optional<Supplier> s = supplierRepo.findById(id);
        if (s.isEmpty()) {
            logger.error("Supplier with ID {} not found", id);
            throw new SupplierInvalidException("id does not exist");
        }
        return s;
    }

    @Override
    public Supplier editSupplier(SupplierDTO supplierDTO) throws SupplierInvalidException {
        logger.info("Editing a supplier with ID: {}", supplierDTO.getId());
        Optional<Supplier> s = this.supplierRepo.findById(supplierDTO.getId());
        if (s.isEmpty()) {
            logger.error("Supplier with ID {} not found", supplierDTO.getId());
            throw new SupplierInvalidException("id does not exist");
        }
        Supplier updateSupplier = s.get();
        updateSupplier.setName(supplierDTO.getName());
        updateSupplier.setContact(supplierDTO.getContact());
        updateSupplier.setEmail(supplierDTO.getEmail());
        return this.supplierRepo.save(updateSupplier);
    }

    @Override
    public Supplier deleteSupplierById(Long id) throws SupplierInvalidException {
        logger.info("Deleting a supplier with ID: {}", id);
        Optional<Supplier> s = supplierRepo.findById(id);
        if (s.isEmpty()) {
            logger.error("Supplier with ID {} not found", id);
            throw new SupplierInvalidException("id does not exist");
        }
        this.supplierRepo.deleteById(id);
        return s.get();
    }

    @Override
    public ResponseDto getSupplierAndDrug(Long supplierId) {
        logger.info("Retrieving supplier information for supplier with ID: {}", supplierId);
        ResponseDto responseDto = new ResponseDto();
        logger.debug("Calling the Drug service to get drug information");
        Supplier supplier = supplierRepo.findById(supplierId).get();
        SupplierDTO supplierDTO = mapToUser(supplier);

        ResponseEntity<DrugDTO> responseEntity = restTemplate.getForEntity("http://localhost:8991/getDrugById/" + supplier.getDrugId(), DrugDTO.class);

        DrugDTO drugDTO = responseEntity.getBody();

        responseDto.setSupplier(supplierDTO);
        responseDto.setDrug(drugDTO);

        return responseDto;
    }

    private SupplierDTO mapToUser(Supplier supplier) {
        SupplierDTO dto = new SupplierDTO();
        dto.setId(supplier.getId());
        dto.setName(supplier.getName());
        dto.setEmail(supplier.getEmail());
        dto.setContact(supplier.getContact());
        return dto;
    }
}
