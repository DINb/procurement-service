package com.diogo.procurement_service.supplier.dto;

import com.diogo.procurement_service.supplier.Supplier;
import lombok.Data;

@Data
public class SupplierDTO {
    private Long id;
    private String name;
    private String email;

    public static SupplierDTO from(Supplier supplier) {
        SupplierDTO dto = new SupplierDTO();
        dto.setId(supplier.getId());
        dto.setName(supplier.getName());
        dto.setEmail(supplier.getEmail());
        return dto;
    }
}