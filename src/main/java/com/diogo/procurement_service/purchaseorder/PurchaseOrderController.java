package com.diogo.procurement_service.purchaseorder;

import com.diogo.procurement_service.purchaseorder.dto.PurchaseOrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/purchase-orders")
@RequiredArgsConstructor
public class PurchaseOrderController {

    private final PurchaseOrderService service;

    @GetMapping
    public List<PurchaseOrderDTO> findAll() {
        return service.findAll().stream()
                .map(PurchaseOrderDTO::from)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrderDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(PurchaseOrderDTO.from(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<PurchaseOrderDTO> create(@RequestParam Long purchaseRequestId) {
        return ResponseEntity.ok(PurchaseOrderDTO.from(service.create(purchaseRequestId)));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<PurchaseOrderDTO> updateStatus(@PathVariable Long id, @RequestParam PurchaseOrderStatus status) {
        return ResponseEntity.ok(PurchaseOrderDTO.from(service.updateStatus(id, status)));
    }
}