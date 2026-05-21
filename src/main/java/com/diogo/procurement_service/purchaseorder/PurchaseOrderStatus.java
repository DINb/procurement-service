package com.diogo.procurement_service.purchaseorder;

public enum PurchaseOrderStatus {
    DRAFT,
    SENT,
    ACKNOWLEDGED,
    IN_PROGRESS,
    PARTIALLY_RECEIVED,
    RECEIVED,
    CLOSED,
    CANCELLED
}