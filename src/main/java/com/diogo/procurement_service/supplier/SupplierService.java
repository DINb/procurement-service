package com.diogo.procurement_service.supplier;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
    }

    public Supplier create(Supplier supplier) {
        return repository.save(supplier);
    }

    public Supplier update(Long id, Supplier supplier) {
        Supplier existing = findById(id);
        existing.setName(supplier.getName());
        existing.setEmail(supplier.getEmail());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}