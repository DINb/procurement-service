package com.diogo.procurement_service.supplier.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import com.diogo.procurement_service.supplier.Supplier;

public record SupplierDTO(
        Long id,

        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
        String name,

        @NotBlank(message = "Email is required")
        @Email(message = "Email must be valid")
        String email
) {
    public static SupplierDTO from(Supplier supplier) {
        return new SupplierDTO(supplier.getId(), supplier.getName(), supplier.getEmail());
    }
}
