package com.optimizer.resourceallocation.service;

import com.optimizer.resourceallocation.entity.AllocationRule;

import java.util.List;

public interface AllocationRuleService {

    AllocationRule createRule(AllocationRule rule);

    List<AllocationRule> getAllRules();

    void deleteRule(Long id);
}
