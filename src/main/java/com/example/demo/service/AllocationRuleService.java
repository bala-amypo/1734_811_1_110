package com.example.demo.service;

import com.example.demo.entity.AllocationRule;
import com.example.demo.repository.AllocationRuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationRuleService {

    private final AllocationRuleRepository ruleRepository;

    public AllocationRuleService(AllocationRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    public AllocationRule saveRule(AllocationRule rule) {
        return ruleRepository.save(rule);
    }

    public List<AllocationRule> getAllRules() {
        return ruleRepository.findAll();
    }
}
