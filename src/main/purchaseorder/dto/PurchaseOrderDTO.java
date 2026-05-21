package com.diogo.procurement_service.purchaseorder.dto;

import com.diogo.procurement_service.purchaseorder.PurchaseOrder;
import com.diogo.procurement_service.purchaseorder.PurchaseOrderStatus;
import com.diogo.procurement_service.supplier.dto.SupplierDTO;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PurchaseOrderDTO {
    private Long id;
    private String orderNumber;
    private Long purchaseRequestId;
    private SupplierDTO supplier;
    private BigDecimal amount;
    private PurchaseOrderStatus status;
    private LocalDateTime createdAt;
    private LocalDate expectedDeliveryDate;
    private String notes;

    public static PurchaseOrderDTO from(PurchaseOrder po) {
        PurchaseOrderDTO dto = new PurchaseOrderDTO();
        dto.setId(po.getId());
        dto.setOrderNumber(po.getOrderNumber());
        dto.setPurchaseRequestId(po.getPurchaseRequest().getId());
        dto.setSupplier(SupplierDTO.from(po.getSupplier()));
        dto.setAmount(po.getAmount());
        dto.setStatus(po.getStatus());
        dto.setCreatedAt(po.getCreatedAt());
        dto.setExpectedDeliveryDate(po.getExpectedDeliveryDate());
        dto.setNotes(po.getNotes());
        return dto;
    }
}