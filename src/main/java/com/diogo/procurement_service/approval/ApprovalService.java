package com.diogo.procurement_service.approval;

import com.diogo.procurement_service.purchaserequest.PurchaseRequest;
import com.diogo.procurement_service.purchaserequest.PurchaseRequestRepository;
import com.diogo.procurement_service.purchaserequest.PurchaseRequestStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApprovalService {

    private final ApprovalRepository approvalRepository;
    private final PurchaseRequestRepository purchaseRequestRepository;

    public List<Approval> findAll() {
        return approvalRepository.findAll();
    }

    public Approval findById(Long id) {
        return approvalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Approval not found"));
    }

    public Approval create(Approval approval) {
        approval.setStatus(ApprovalStatus.PENDING);
        approval.setDate(LocalDateTime.now());

        PurchaseRequest pr = purchaseRequestRepository
                .findById(approval.getPurchaseRequest().getId())
                .orElseThrow(() -> new RuntimeException("Purchase Request not found"));

        pr.setStatus(PurchaseRequestStatus.PENDING);
        purchaseRequestRepository.save(pr);

        return approvalRepository.save(approval);
    }

    public Approval updateStatus(Long id, ApprovalStatus status) {
        Approval approval = findById(id);
        approval.setStatus(status);
        approval.setDate(LocalDateTime.now());

        PurchaseRequest pr = approval.getPurchaseRequest();
        if (status == ApprovalStatus.APPROVED) {
            pr.setStatus(PurchaseRequestStatus.APPROVED);
        } else if (status == ApprovalStatus.REJECTED) {
            pr.setStatus(PurchaseRequestStatus.REJECTED);
        }
        purchaseRequestRepository.save(pr);

        return approvalRepository.save(approval);
    }
}