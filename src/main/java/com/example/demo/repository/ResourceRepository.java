package com.demo.resourceallocation.repository;

import com.demo.resourceallocation.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Long> {

    List<Resource> findByResourceType(String resourceType);
}
