package com.example.demo.controller;

import com.example.demo.entity.AllocationRule;
import com.example.demo.service.AllocationRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class AllocationRuleController {

    private final AllocationRuleService ruleService;

    public AllocationRuleController(AllocationRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    public AllocationRule createRule(@RequestBody AllocationRule rule) {
        return ruleService.saveRule(rule);
    }

    @GetMapping
    public List<AllocationRule> getAllRules() {
        return ruleService.getAllRules();
    }
}
