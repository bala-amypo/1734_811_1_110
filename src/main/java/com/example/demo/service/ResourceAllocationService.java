package com.example.demo.service;

import com.example.demo.entity.Resource;
import com.example.demo.entity.ResourceAllocation;
import com.example.demo.entity.ResourceRequest;
import com.example.demo.repository.ResourceAllocationRepository;
import org.springframework.stereotype.Service;

@Service
public class ResourceAllocationService {

    private final ResourceAllocationRepository allocationRepository;

    public ResourceAllocationService(ResourceAllocationRepository allocationRepository) {
        this.allocationRepository = allocationRepository;
    }

    public ResourceAllocation allocate(ResourceRequest request, Resource resource) {
        ResourceAllocation allocation = new ResourceAllocation();
        allocation.setRequest(request);
        allocation.setResource(resource);
        allocation.setConflictFlag(false);
        allocation.setNotes("Allocated successfully");

        request.setStatus("APPROVED");

        return allocationRepository.save(allocation);
    }
}
