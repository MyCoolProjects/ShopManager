package com.example.repository;

import com.example.entity.Specification_name;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Specification_nameRepository extends JpaRepository<Specification_name, Long> {

}
