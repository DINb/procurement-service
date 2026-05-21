package com.diogo.procurement_service.approval.dto;

import com.diogo.procurement_service.approval.Approval;
import com.diogo.procurement_service.approval.ApprovalStatus;
import com.diogo.procurement_service.purchaserequest.dto.PurchaseRequestDTO;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ApprovalDTO {
    private Long id;
    private PurchaseRequestDTO purchaseRequest;
    private String approver;
    private ApprovalStatus status;
    private LocalDateTime date;

    public static ApprovalDTO from(Approval approval) {
        ApprovalDTO dto = new ApprovalDTO();
        dto.setId(approval.getId());
        dto.setPurchaseRequest(PurchaseRequestDTO.from(approval.getPurchaseRequest()));
        dto.setApprover(approval.getApprover());
        dto.setStatus(approval.getStatus());
        dto.setDate(approval.getDate());
        return dto;
    }
}