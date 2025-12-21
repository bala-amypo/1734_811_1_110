package com.optimizer.resourceallocation.service.impl;

import com.optimizer.resourceallocation.entity.ResourceRequest;
import com.optimizer.resourceallocation.entity.User;
import com.optimizer.resourceallocation.repository.ResourceRequestRepository;
import com.optimizer.resourceallocation.repository.UserRepository;
import com.optimizer.resourceallocation.service.ResourceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceRequestServiceImpl implements ResourceRequestService {

    @Autowired
    private ResourceRequestRepository requestRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResourceRequest createRequest(Long userId, String resourceType, int amount) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        ResourceRequest request =
                new ResourceRequest(user, resourceType, amount, "PENDING");

        return requestRepository.save(request);
    }

    @Override
    public List<ResourceRequest> getAllRequests() {
        return requestRepository.findAll();
    }

    @Override
    public ResourceRequest updateRequestStatus(Long requestId, String status) {
        ResourceRequest request = requestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        request.setStatus(status);
        return requestRepository.save(request);
    }
}
