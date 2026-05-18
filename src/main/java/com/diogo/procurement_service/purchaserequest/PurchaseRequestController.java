package com.diogo.procurement_service.purchaserequest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/purchase-requests")
@RequiredArgsConstructor
public class PurchaseRequestController {

    private final PurchaseRequestService service;

    @GetMapping
    public List<PurchaseRequest> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseRequest> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<PurchaseRequest> create(@RequestBody PurchaseRequest purchaseRequest) {
        return ResponseEntity.ok(service.create(purchaseRequest));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<PurchaseRequest> updateStatus(@PathVariable Long id, @RequestParam PurchaseRequestStatus status) {
        return ResponseEntity.ok(service.updateStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}