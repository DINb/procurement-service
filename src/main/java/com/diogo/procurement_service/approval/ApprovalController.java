package com.diogo.procurement_service.approval;

import com.diogo.procurement_service.approval.dto.ApprovalDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/approvals")
@RequiredArgsConstructor
public class ApprovalController {

    private final ApprovalService service;

    @GetMapping
    public List<ApprovalDTO> findAll() {
        return service.findAll().stream()
                .map(ApprovalDTO::from)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApprovalDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ApprovalDTO.from(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ApprovalDTO> create(@RequestBody Approval approval) {
        return ResponseEntity.ok(ApprovalDTO.from(service.create(approval)));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ApprovalDTO> updateStatus(@PathVariable Long id, @RequestParam ApprovalStatus status) {
        return ResponseEntity.ok(ApprovalDTO.from(service.updateStatus(id, status)));
    }
}