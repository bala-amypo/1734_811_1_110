package com.demo.resourceallocation.repository;

import com.demo.resourceallocation.entity.ResourceAllocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourceAllocationRepository
        extends JpaRepository<ResourceAllocation, Long> {

    List<ResourceAllocation> findByUserId(Long userId);

    List<ResourceAllocation> findByResourceId(Long resourceId);
}
