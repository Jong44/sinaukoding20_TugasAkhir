package com.sinaukoding.Tanjung.repository;

import com.sinaukoding.Tanjung.entitiy.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
