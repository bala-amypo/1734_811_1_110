package com.demo.resourceallocation.service;

import com.demo.resourceallocation.entity.AllocationRule;

import java.util.List;

public interface AllocationRuleService {

    AllocationRule createRule(AllocationRule rule);

    List<AllocationRule> getAllRules();

    void deleteRule(Long id);
}
