package com.demo.resourceallocation.service.impl;

import com.demo.resourceallocation.entity.AllocationRule;
import com.demo.resourceallocation.repository.AllocationRuleRepository;
import com.demo.resourceallocation.service.AllocationRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationRuleServiceImpl implements AllocationRuleService {

    @Autowired
    private AllocationRuleRepository ruleRepository;

    @Override
    public AllocationRule createRule(AllocationRule rule) {
        return ruleRepository.save(rule);
    }

    @Override
    public List<AllocationRule> getAllRules() {
        return ruleRepository.findAll();
    }

    @Override
    public void deleteRule(Long id) {
        ruleRepository.deleteById(id);
    }
}
