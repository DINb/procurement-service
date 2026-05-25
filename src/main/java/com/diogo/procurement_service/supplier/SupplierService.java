package com.diogo.procurement_service.supplier;

import com.diogo.procurement_service.supplier.dto.SupplierDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository repository;

    public List<Supplier> findAll() {
        return repository.findAll();
    }

    public Supplier findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found with id: " + id));
    }

    @Transactional
    public Supplier create(SupplierDTO dto) {
        Supplier supplier = new Supplier();
        supplier.setName(dto.name());
        supplier.setEmail(dto.email());
        
        return repository.save(supplier);
    }

    @Transactional
    public Supplier update(Long id, SupplierDTO dto) {
        Supplier existingSupplier = findById(id);
        
        existingSupplier.setName(dto.name());
        existingSupplier.setEmail(dto.email());
        
        return repository.save(existingSupplier);
    }

    @Transactional
    public void delete(Long id) {
        Supplier supplier = findById(id);
        repository.delete(supplier);
    }
}
