package com.diogo.procurement_service.purchaserequest;

import com.diogo.procurement_service.purchaserequest.dto.PurchaseRequestDTO;
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
    public List<PurchaseRequestDTO> findAll() {
        return service.findAll().stream()
                .map(PurchaseRequestDTO::from)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseRequestDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(PurchaseRequestDTO.from(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<PurchaseRequestDTO> create(@RequestBody PurchaseRequest purchaseRequest) {
        return ResponseEntity.ok(PurchaseRequestDTO.from(service.create(purchaseRequest)));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<PurchaseRequestDTO> updateStatus(@PathVariable Long id, @RequestParam PurchaseRequestStatus status) {
        return ResponseEntity.ok(PurchaseRequestDTO.from(service.updateStatus(id, status)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}