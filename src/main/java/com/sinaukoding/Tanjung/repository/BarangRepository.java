package com.sinaukoding.Tanjung.repository;

import com.sinaukoding.Tanjung.entitiy.Barang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarangRepository extends JpaRepository<Barang, Integer> {
    List<Barang> findByNamaBarangContaining(String namaBarang);

}
