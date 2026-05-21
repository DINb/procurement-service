package com.diogo.procurement_service.purchaseorder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
    long countByOrderNumberStartingWith(String prefix);
}