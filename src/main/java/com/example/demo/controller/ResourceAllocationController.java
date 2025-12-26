package com.example.demo.controller;

import com.example.demo.entity.Resource;
import com.example.demo.entity.ResourceAllocation;
import com.example.demo.entity.ResourceRequest;
import com.example.demo.service.ResourceAllocationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/allocations")
public class ResourceAllocationController {

    private final ResourceAllocationService allocationService;

    public ResourceAllocationController(ResourceAllocationService allocationService) {
        this.allocationService = allocationService;
    }

    @PostMapping
    public ResourceAllocation allocate(@RequestBody ResourceRequest request,
                                       @RequestBody Resource resource) {
        return allocationService.allocate(request, resource);
    }
}
