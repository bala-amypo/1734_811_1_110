package com.optimizer.resourceallocation.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "resource_requests")
public class ResourceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String resourceType;

    @Column(nullable = false)
    private int requestedAmount;

    @Column(nullable = false)
    private String status; // PENDING, APPROVED, REJECTED

    public ResourceRequest() {
    }

    public ResourceRequest(User user, String resourceType, int requestedAmount, String status) {
        this.user = user;
        this.resourceType = resourceType;
        this.requestedAmount = requestedAmount;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getResourceType() {
        return resourceType;
    }

    public int getRequestedAmount() {
        return requestedAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
