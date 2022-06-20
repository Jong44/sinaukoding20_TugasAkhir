package com.sinaukoding.Tanjung.repository;

import com.sinaukoding.Tanjung.entitiy.Pembeli;
import com.sinaukoding.Tanjung.entitiy.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    List<Supplier> findByNamaSupplierContaining(String namaSupplier);

}
