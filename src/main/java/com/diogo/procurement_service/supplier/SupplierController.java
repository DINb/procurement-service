package com.diogo.procurement_service.supplier;

import com.diogo.procurement_service.supplier.dto.SupplierDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/suppliers")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService service;

    @GetMapping
    public List<SupplierDTO> findAll() {
        return service.findAll().stream()
                .map(SupplierDTO::from)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(SupplierDTO.from(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<SupplierDTO> create(@RequestBody Supplier supplier) {
        return ResponseEntity.ok(SupplierDTO.from(service.create(supplier)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierDTO> update(@PathVariable Long id, @RequestBody Supplier supplier) {
        return ResponseEntity.ok(SupplierDTO.from(service.update(id, supplier)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}