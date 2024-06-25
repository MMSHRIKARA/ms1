package com.supplier.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.supplier.DTO.ResponseDto;
import com.supplier.DTO.SupplierDTO;
import com.supplier.entity.Supplier;
import com.supplier.exception.SupplierInvalidException;
import com.supplier.service.SupplierService;

@RestController
@CrossOrigin("*")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/addSupplier")
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) {
        Supplier addedSupplier = this.supplierService.addSupplier(supplier);
        return ResponseEntity.ok(addedSupplier);
    }

    @GetMapping("/getSuppliers")
    public ResponseEntity<List<Supplier>> getSuppliers() {
        List<Supplier> suppliers = this.supplierService.getSupplier();
        return ResponseEntity.ok(suppliers);
    }

    @GetMapping("/getSupplierById/{id}")
    public ResponseEntity<Optional<Supplier>> getSupplierById(@PathVariable Long id) throws SupplierInvalidException {
        Optional<Supplier> supplier = this.supplierService.getSupplierById(id);
        return ResponseEntity.ok(supplier);
    }

    @PutMapping("/editSupplier")
    public ResponseEntity<Supplier> editSupplier(@RequestBody SupplierDTO supplierDTO) throws SupplierInvalidException {
        Supplier editedSupplier = this.supplierService.editSupplier(supplierDTO);
        return ResponseEntity.ok(editedSupplier);
    }

    @DeleteMapping("/deleteSupplier/{id}")
    public ResponseEntity<Supplier> deleteSupplierById(@PathVariable Long id) throws SupplierInvalidException {
        Supplier deletedSupplier = this.supplierService.deleteSupplierById(id);
        return ResponseEntity.ok(deletedSupplier);
    }

    @GetMapping("/getSupplierAndDrug/{supplierId}")
    public ResponseEntity<ResponseDto> getSupplierAndDrug(@PathVariable Long supplierId) throws SupplierInvalidException {
        ResponseDto responseDto = supplierService.getSupplierAndDrug(supplierId);
        return ResponseEntity.ok(responseDto);
    }
}
