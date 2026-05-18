package com.diogo.procurement_service.purchaserequest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseRequestService {

    private final PurchaseRequestRepository repository;

    public List<PurchaseRequest> findAll() {
        return repository.findAll();
    }

    public PurchaseRequest findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase Request not found"));
    }

    public PurchaseRequest create(PurchaseRequest purchaseRequest) {
        purchaseRequest.setStatus(PurchaseRequestStatus.DRAFT);
        return repository.save(purchaseRequest);
    }

    public PurchaseRequest updateStatus(Long id, PurchaseRequestStatus status) {
        PurchaseRequest existing = findById(id);
        existing.setStatus(status);
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}