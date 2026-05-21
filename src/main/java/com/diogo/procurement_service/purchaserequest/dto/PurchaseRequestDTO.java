package com.diogo.procurement_service.purchaserequest.dto;

import com.diogo.procurement_service.purchaserequest.PurchaseRequest;
import com.diogo.procurement_service.purchaserequest.PurchaseRequestStatus;
import com.diogo.procurement_service.supplier.dto.SupplierDTO;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class PurchaseRequestDTO {
    private Long id;
    private String description;
    private BigDecimal amount;
    private PurchaseRequestStatus status;
    private SupplierDTO supplier;

    public static PurchaseRequestDTO from(PurchaseRequest pr) {
        PurchaseRequestDTO dto = new PurchaseRequestDTO();
        dto.setId(pr.getId());
        dto.setDescription(pr.getDescription());
        dto.setAmount(pr.getAmount());
        dto.setStatus(pr.getStatus());
        dto.setSupplier(SupplierDTO.from(pr.getSupplier()));
        return dto;
    }
}