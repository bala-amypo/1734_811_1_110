package com.optimizer.resourceallocation.repository;

import com.optimizer.resourceallocation.entity.ResourceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourceRequestRepository
        extends JpaRepository<ResourceRequest, Long> {

    List<ResourceRequest> findByStatus(String status);

    List<ResourceRequest> findByUserId(Long userId);
}
