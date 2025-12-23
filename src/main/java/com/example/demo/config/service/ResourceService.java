package com.example.demo.service;

import com.example.demo.entity.Resource;
import com.example.demo.repository.ResourceRepository;

import java.util.List;

public class ResourceService {

    private final ResourceRepository resourceRepository;

    // REQUIRED constructor order
    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public Resource createResource(Resource resource) {
        if (resourceRepository.existsByResourceName(resource.getResourceName())) {
            throw new RuntimeException("Resource already exists");
        }
        if (resource.getCapacity() < 1) {
            throw new RuntimeException("Invalid capacity");
        }
        return resourceRepository.save(resource);
    }

    public Resource getResource(Long id) {
        return resourceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resource not found"));
    }

    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }
}
