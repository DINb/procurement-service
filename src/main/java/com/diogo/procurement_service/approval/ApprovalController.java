package com.diogo.procurement_service.approval;

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
    public List<Approval> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Approval> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Approval> create(@RequestBody Approval approval) {
        return ResponseEntity.ok(service.create(approval));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Approval> updateStatus(@PathVariable Long id, @RequestParam ApprovalStatus status) {
        return ResponseEntity.ok(service.updateStatus(id, status));
    }
}