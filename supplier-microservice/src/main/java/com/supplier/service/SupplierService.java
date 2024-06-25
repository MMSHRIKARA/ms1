package com.supplier.service;

import java.util.List;
import java.util.Optional;

import com.supplier.DTO.ResponseDto;
import com.supplier.DTO.SupplierDTO;
import com.supplier.entity.Supplier;
import com.supplier.exception.SupplierInvalidException;

public interface SupplierService {
	
	public Supplier addSupplier(Supplier supplier);
	
	public List<Supplier> getSupplier();
	
	public Optional<Supplier> getSupplierById(Long id) throws SupplierInvalidException ;
	
	public Supplier editSupplier(SupplierDTO supplierDTO) throws SupplierInvalidException ;
	
	public Supplier deleteSupplierById(Long id) throws SupplierInvalidException ;
	
	ResponseDto getSupplierAndDrug(Long supplierId)throws SupplierInvalidException;

}
