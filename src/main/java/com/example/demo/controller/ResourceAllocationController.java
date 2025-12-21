package com.optimizer.resourceallocation.controller;

import com.optimizer.resourceallocation.entity.ResourceAllocation;
import com.optimizer.resourceallocation.service.ResourceAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/allocations")
public class ResourceAllocationController {

    @Autowired
    private ResourceAllocationService allocationService;

    @PostMapping
    public ResponseEntity<ResourceAllocation> allocateResource(
            @RequestParam Long userId,
            @RequestParam Long resourceId,
            @RequestParam int amount) {

        return ResponseEntity.ok(
                allocationService.allocateResource(userId, resourceId, amount)
        );
    }

    @GetMapping
    public ResponseEntity<List<ResourceAllocation>> getAllAllocations() {
        return ResponseEntity.ok(allocationService.getAllAllocations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceAllocation> getAllocationById(@PathVariable Long id) {
        return ResponseEntity.ok(allocationService.getAllocationById(id));
    }
}
