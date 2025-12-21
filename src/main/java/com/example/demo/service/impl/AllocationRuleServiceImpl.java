package com.optimizer.resourceallocation.service.impl;

import com.optimizer.resourceallocation.entity.AllocationRule;
import com.optimizer.resourceallocation.repository.AllocationRuleRepository;
import com.optimizer.resourceallocation.service.AllocationRuleService;
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
