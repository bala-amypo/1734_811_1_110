package com.demo.resourceallocation.service;

import com.demo.resourceallocation.entity.ResourceRequest;

import java.util.List;

public interface ResourceRequestService {

    ResourceRequest createRequest(Long userId, String resourceType, int amount);

    List<ResourceRequest> getAllRequests();

    ResourceRequest updateRequestStatus(Long requestId, String status);
}
