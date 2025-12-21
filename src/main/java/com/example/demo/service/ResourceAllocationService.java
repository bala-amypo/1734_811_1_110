package com.optimizer.resourceallocation.service;

import com.optimizer.resourceallocation.entity.ResourceAllocation;

import java.util.List;

public interface ResourceAllocationService {

    ResourceAllocation allocateResource(Long userId, Long resourceId, int amount);

    List<ResourceAllocation> getAllAllocations();

    ResourceAllocation getAllocationById(Long id);
}
