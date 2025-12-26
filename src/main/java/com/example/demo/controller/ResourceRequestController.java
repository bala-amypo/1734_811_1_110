package com.example.demo.controller;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.entity.User;
import com.example.demo.service.ResourceRequestService;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class ResourceRequestController {

    private final ResourceRequestService requestService;
    private final UserService userService;

    public ResourceRequestController(ResourceRequestService requestService,
                                     UserService userService) {
        this.requestService = requestService;
        this.userService = userService;
    }

    @PostMapping("/{email}")
    public ResourceRequest createRequest(@RequestBody ResourceRequest request,
                                         @PathVariable String email) {
        User user = userService.getByEmail(email);
        return requestService.createRequest(request, user);
    }

    @GetMapping
    public List<ResourceRequest> getAllRequests() {
        return requestService.getAllRequests();
    }
}
