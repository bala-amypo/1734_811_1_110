package com.demo.resourceallocation.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "allocation_rules")
public class AllocationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ruleName;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int priorityLevel; // Higher number = higher priority

    public AllocationRule() {
    }

    public AllocationRule(String ruleName, String description, int priorityLevel) {
        this.ruleName = ruleName;
        this.description = description;
        this.priorityLevel = priorityLevel;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getDescription() {
        return description;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }
}
