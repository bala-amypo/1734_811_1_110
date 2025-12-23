package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ResourceAllocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ResourceRequest request;

    @ManyToOne
    private Resource resource;

    private boolean conflictFlag;

    private String notes;

    public ResourceAllocation() {}

    public Long getId() {
        return id;
    }

    public ResourceRequest getRequest() {
        return request;
    }

    public void setRequest(ResourceRequest request) {
        this.request = request;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public boolean isConflictFlag() {
        return conflictFlag;
    }

    public void setConflictFlag(boolean conflictFlag) {
        this.conflictFlag = conflictFlag;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
