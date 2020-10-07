package com.example.repository;

import com.example.entity.Specifications;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecificationsRepository extends PagingAndSortingRepository<Specifications, Long> {

}
