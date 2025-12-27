package com.example.demo.service; 
import com.example.demo.entity.Resource; 
import java.util.List; 
public interface ResourceService { 
// Create a resource (throws exception if exists/invalid) 
Resource createResource(Resource resource); 
List<Resource> getAllResources(); 
Resource getResourceByName(String resourceName); 
} 