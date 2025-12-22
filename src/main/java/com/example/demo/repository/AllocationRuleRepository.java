package com.demo.resourceallocation.repository;

import com.demo.resourceallocation.entity.AllocationRule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationRuleRepository
        extends JpaRepository<AllocationRule, Long> {
}
