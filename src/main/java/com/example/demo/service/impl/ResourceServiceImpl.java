package com.optimizer.resourceallocation.service.impl;

import com.optimizer.resourceallocation.entity.Resource;
import com.optimizer.resourceallocation.repository.ResourceRepository;
import com.optimizer.resourceallocation.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public Resource createResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    @Override
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    @Override
    public Resource getResourceById(Long id) {
        return resourceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resource not found"));
    }

    @Override
    public Resource updateResource(Long id, Resource resource) {
        Resource existing = getResourceById(id);
        existing.setResourceName(resource.getResourceName());
        existing.setResourceType(resource.getResourceType());
        existing.setTotalCapacity(resource.getTotalCapacity());
        existing.setAvailableCapacity(resource.getAvailableCapacity());
        return resourceRepository.save(existing);
    }

    @Override
    public void deleteResource(Long id) {
        resourceRepository.deleteById(id);
    }
}
