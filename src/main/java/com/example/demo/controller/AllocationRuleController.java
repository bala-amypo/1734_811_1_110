package com.demo.resourceallocation.controller;

import com.demo.resourceallocation.entity.AllocationRule;
import com.demo.resourceallocation.service.AllocationRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class AllocationRuleController {

    @Autowired
    private AllocationRuleService ruleService;

    @PostMapping
    public ResponseEntity<AllocationRule> createRule(@RequestBody AllocationRule rule) {
        return ResponseEntity.ok(ruleService.createRule(rule));
    }

    @GetMapping
    public ResponseEntity<List<AllocationRule>> getAllRules() {
        return ResponseEntity.ok(ruleService.getAllRules());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRule(@PathVariable Long id) {
        ruleService.deleteRule(id);
        return ResponseEntity.ok("Allocation rule deleted successfully");
    }
}
