package com.optimizer.resourceallocation.repository;

import com.optimizer.resourceallocation.entity.AllocationRule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationRuleRepository
        extends JpaRepository<AllocationRule, Long> {
}
