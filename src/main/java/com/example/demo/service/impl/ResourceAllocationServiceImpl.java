package com.optimizer.resourceallocation.service.impl;

import com.optimizer.resourceallocation.entity.Resource;
import com.optimizer.resourceallocation.entity.ResourceAllocation;
import com.optimizer.resourceallocation.entity.User;
import com.optimizer.resourceallocation.repository.ResourceAllocationRepository;
import com.optimizer.resourceallocation.repository.ResourceRepository;
import com.optimizer.resourceallocation.repository.UserRepository;
import com.optimizer.resourceallocation.service.ResourceAllocationService;
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
