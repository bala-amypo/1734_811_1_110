package com.example.demo.service; 
 
import com.example.demo.entity.AllocationRule; 
 
import java.util.List; 
 
public interface AllocationRuleService { 
 
    AllocationRule createRule(AllocationRule rule); 
 
    AllocationRule getRule(Long id); 
 
    List<AllocationRule> getAllRules(); 
} 
 
package com.example.demo.service; 
 
import com.example.demo.entity.ResourceAllocation; 
 
import java.util.List; 
 
public interface ResourceAllocationService { 
    ResourceAllocation autoAllocate(Long requestId); 
    List<ResourceAllocation> getAllAllocations(); 
} 
 
 
package com.example.demo.service; 
 
import com.example.demo.entity.ResourceRequest; 
 
import java.util.List; 
 
public interface ResourceRequestService { 
 
    // Create a new request for a user 
    ResourceRequest createRequest(Long userId, ResourceRequest request); 
 
    // Get all requests for a user 
    List<ResourceRequest> getRequestsByUser(Long userId); 
 
    // Update status of a request 
    ResourceRequest updateRequestStatus(Long requestId, String status); 
 
    // Optional: get by ID directly 
    ResourceRequest getRequestById(Long requestId); 
} 
package com.example.demo.service; 
import com.example.demo.entity.Resource; 
import java.util.List; 
public interface ResourceService { 
// Create a resource (throws exception if exists/invalid) 
Resource createResource(Resource resource); 
// Get all resources 
List<Resource> getAllResources(); 
// Optional helper: get resource by name 
Resource getResourceByName(String resourceName); 
} 
package com.example.demo.service; 
import com.example.demo.entity.User; 
public interface UserService { 
User registerUser(User user); 
User getUserByEmail(String email); 
}