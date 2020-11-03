package com.example.repository;

import com.example.entity.Specification_name;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Specification_nameRepository extends JpaRepository<Specification_name, Long> {

    @Query("SELECT s.id_category.id FROM Specification_name s WHERE s.id_name = :id_specification_name")
    public Long getIdCategory(@Param("id_specification_name") Long id_specification_name);
}
