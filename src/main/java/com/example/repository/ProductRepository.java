package com.example.repository;

import com.example.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    /*
     * @Query(value =
     * "SELECT z.* FROM rek_zm d INNER JOIN proj_a a ON d.id = a.prj_idcislo" +
     * "                                   INNER JOIN proj_e e ON a.id = e.id" +
     * "                                   INNER JOIN rekv_z z ON d.id = z.id" +
     * "WHERE  d.id = ?1 AND a.id = ?2 AND e.id = ?3", nativeQuery = true) public
     * List<RekvalZamestn> getRekvOsOnDoh(Long dhzmrk, Long prj, Long prje); }
     */
}
