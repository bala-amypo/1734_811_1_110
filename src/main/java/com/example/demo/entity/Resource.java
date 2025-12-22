package com.demo.resourceallocation.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "resources")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String resourceName;

    @Column(nullable = false)
    private String resourceType; // CPU, MEMORY, STORAGE

    @Column(nullable = false)
    private int totalCapacity;

    @Column(nullable = false)
    private int availableCapacity;

    public Resource() {
    }

    public Resource(String resourceName, String resourceType, int totalCapacity, int availableCapacity) {
        this.resourceName = resourceName;
        this.resourceType = resourceType;
        this.totalCapacity = totalCapacity;
        this.availableCapacity = availableCapacity;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public int getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(int availableCapacity) {
        this.availableCapacity = availableCapacity;
    }
}
