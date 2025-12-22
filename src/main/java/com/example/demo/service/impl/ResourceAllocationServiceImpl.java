package com.demo.resourceallocation.service.impl;

import com.demo.resourceallocation.entity.Resource;
import com.demo.resourceallocation.entity.ResourceAllocation;
import com.demo.resourceallocation.entity.User;
import com.demo.resourceallocation.repository.ResourceAllocationRepository;
import com.demo.resourceallocation.repository.ResourceRepository;
import com.demo.resourceallocation.repository.UserRepository;
import com.demo.resourceallocation.service.ResourceAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceAllocationServiceImpl implements ResourceAllocationService {

    @Autowired
    private ResourceAllocationRepository allocationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public ResourceAllocation allocateResource(Long userId, Long resourceId, int amount) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Resource resource = resourceRepository.findById(resourceId)
                .orElseThrow(() -> new RuntimeException("Resource not found"));

        if (resource.getAvailableCapacity() < amount) {
            throw new RuntimeException("Insufficient resource capacity");
        }

        resource.setAvailableCapacity(resource.getAvailableCapacity() - amount);
        resourceRepository.save(resource);

        ResourceAllocation allocation =
                new ResourceAllocation(user, resource, amount);

        return allocationRepository.save(allocation);
    }

    @Override
    public List<ResourceAllocation> getAllAllocations() {
        return allocationRepository.findAll();
    }

    @Override
    public ResourceAllocation getAllocationById(Long id) {
        return allocationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Allocation not found"));
    }
}
