package com.diogo.procurement_service.purchaseorder;

import com.diogo.procurement_service.purchaserequest.PurchaseRequest;
import com.diogo.procurement_service.purchaserequest.PurchaseRequestRepository;
import com.diogo.procurement_service.purchaserequest.PurchaseRequestStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseOrderService {

    private final PurchaseOrderRepository repository;
    private final PurchaseRequestRepository purchaseRequestRepository;

    public List<PurchaseOrder> findAll() {
        return repository.findAll();
    }

    public PurchaseOrder findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase Order not found"));
    }

    public PurchaseOrder create(Long purchaseRequestId) {
        PurchaseRequest pr = purchaseRequestRepository.findById(purchaseRequestId)
                .orElseThrow(() -> new RuntimeException("Purchase Request not found"));

        if (pr.getStatus() != PurchaseRequestStatus.APPROVED) {
            throw new RuntimeException("Purchase Request must be APPROVED to create a Purchase Order");
        }

        PurchaseOrder po = new PurchaseOrder();
        po.setOrderNumber(generateOrderNumber());
        po.setPurchaseRequest(pr);
        po.setSupplier(pr.getSupplier());
        po.setAmount(pr.getAmount());
        po.setStatus(PurchaseOrderStatus.DRAFT);
        po.setCreatedAt(LocalDateTime.now());

        pr.setStatus(PurchaseRequestStatus.PURCHASE_ORDER_CREATED);
        purchaseRequestRepository.save(pr);

        return repository.save(po);
    }

    public PurchaseOrder updateStatus(Long id, PurchaseOrderStatus status) {
        PurchaseOrder po = findById(id);
        po.setStatus(status);
        return repository.save(po);
    }

    private String generateOrderNumber() {
        int year = Year.now().getValue();
        String prefix = "PO-" + year + "-";
        long count = repository.countByOrderNumberStartingWith(prefix);
        return String.format("%s%04d", prefix, count + 1);
    }
}