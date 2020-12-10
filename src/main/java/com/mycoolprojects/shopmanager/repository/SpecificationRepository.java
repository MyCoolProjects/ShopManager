package com.mycoolprojects.shopmanager.repository;

import com.mycoolprojects.shopmanager.entity.Specification;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecificationRepository extends JpaRepository<Specification, Long> {
}
