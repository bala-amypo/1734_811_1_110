package com.example.demo.service;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.ResourceRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceRequestService {

    private final ResourceRequestRepository requestRepository;

    public ResourceRequestService(ResourceRequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public ResourceRequest createRequest(ResourceRequest request, User user) {
        request.setRequestedBy(user);
        request.setStatus("PENDING");
        return requestRepository.save(request);
    }

    public List<ResourceRequest> getAllRequests() {
        return requestRepository.findAll();
    }

    public ResourceRequest updateStatus(Long id, String status) {
        ResourceRequest request = requestRepository.findById(id).orElse(null);
        if (request != null) {
            request.setStatus(status);
            return requestRepository.save(request);
        }
        return null;
    }
}
