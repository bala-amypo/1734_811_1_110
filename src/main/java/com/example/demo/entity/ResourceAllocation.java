package com.optimizer.resourceallocation.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "resource_allocations")
public class ResourceAllocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "resource_id", nullable = false)
    private Resource resource;

    @Column(nullable = false)
    private int allocatedAmount;

    @Column(nullable = false)
    private LocalDateTime allocationTime;

    public ResourceAllocation() {
    }

    public ResourceAllocation(User user, Resource resource, int allocatedAmount) {
        this.user = user;
        this.resource = resource;
        this.allocatedAmount = allocatedAmount;
        this.allocationTime = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Resource getResource() {
        return resource;
    }

    public int getAllocatedAmount() {
        return allocatedAmount;
    }

    public void setAllocatedAmount(int allocatedAmount) {
        this.allocatedAmount = allocatedAmount;
    }

    public LocalDateTime getAllocationTime() {
        return allocationTime;
    }
}
