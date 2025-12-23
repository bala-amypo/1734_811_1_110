package com.example.demo.service;

import com.example.demo.entity.AllocationRule;
import com.example.demo.repository.AllocationRuleRepository;

import java.util.List;

public class AllocationRuleService {

    private final AllocationRuleRepository ruleRepository;

    // REQUIRED constructor order
    public AllocationRuleService(AllocationRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    public AllocationRule createRule(AllocationRule rule) {
        if (ruleRepository.existsByRuleName(rule.getRuleName())) {
            throw new RuntimeException("Rule already exists");
        }
        if (rule.getPriorityWeight() < 0) {
            throw new RuntimeException("Invalid priority weight");
        }
        return ruleRepository.save(rule);
    }

    public AllocationRule getRule(Long id) {
        return ruleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found"));
    }

    public List<AllocationRule> getAllRules() {
        return ruleRepository.findAll();
    }
}
