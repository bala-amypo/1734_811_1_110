package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
resource-allocation-optimizer
│
├── pom.xml
│
└── src
    └── main
        ├── java
        │   └── com
        │       └── example
        │           └── demo
        │               │
        │               ├── DemoApplication.java
        │               │
        │               ├── controller
        │               │   ├── AuthController.java
        │               │   ├── UserController.java
        │               │   ├── ResourceController.java
        │               │   ├── ResourceRequestController.java
        │               │   ├── ResourceAllocationController.java
        │               │   └── AllocationRuleController.java
        │               │
        │               ├── service
        │               │   ├── UserService.java
        │               │   ├── ResourceService.java
        │               │   ├── ResourceRequestService.java
        │               │   ├── ResourceAllocationService.java
        │               │   └── AllocationRuleService.java
        │               │
        │               ├── repository
        │               │   ├── UserRepository.java
        │               │   ├── ResourceRepository.java
        │               │   ├── ResourceRequestRepository.java
        │               │   ├── ResourceAllocationRepository.java
        │               │   └── AllocationRuleRepository.java
        │               │
        │               ├── entity
        │               │   ├── User.java
        │               │   ├── Resource.java
        │               │   ├── ResourceRequest.java
        │               │   ├── ResourceAllocation.java
        │               │   └── AllocationRule.java
        │               │
        │               ├── dto
        │               │   ├── LoginRequest.java
        │               │   ├── RegisterRequest.java
        │               │   └── AuthResponse.java
        │               │
        │               ├── security
        │               │   ├── JwtUtil.java
        │               │   ├── JwtAuthenticationFilter.java
        │               │   └── CustomUserDetailsService.java
        │               │
        │               ├── config
        │               │   ├── SecurityConfig.java
        │               │   └── OpenApiConfig.java
        │               │
        │               ├── exception
        │               │   ├── ResourceNotFoundException.java
        │               │   ├── ValidationException.java
        │               │   └── GlobalExceptionHandler.java
        │               │
        │               └── servlet
        │                   └── SimpleHelloServlet.java
        │
        └── resources
            └── application.properties

