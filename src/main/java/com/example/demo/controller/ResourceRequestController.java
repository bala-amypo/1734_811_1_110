package com.optimizer.resourceallocation.controller;

import com.optimizer.resourceallocation.entity.ResourceRequest;
import com.optimizer.resourceallocation.service.ResourceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class ResourceRequestController {

    @Autowired
    private ResourceRequestService requestService;

    @PostMapping
    public ResponseEntity<ResourceRequest> createRequest(
            @RequestParam Long userId,
            @RequestParam String resourceType,
            @RequestParam int amount) {

        return ResponseEntity.ok(
                requestService.createRequest(userId, resourceType, amount)
        );
    }

    @GetMapping
    public ResponseEntity<List<ResourceRequest>> getAllRequests() {
        return ResponseEntity.ok(requestService.getAllRequests());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ResourceRequest> updateRequestStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return ResponseEntity.ok(
                requestService.updateRequestStatus(id, status)
        );
    }
}
