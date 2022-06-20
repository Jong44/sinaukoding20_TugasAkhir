package com.sinaukoding.Tanjung.repository;

import com.sinaukoding.Tanjung.entitiy.Pembeli;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PembeliRepository extends JpaRepository<Pembeli, Integer> {

    List<Pembeli> findByNamaPembeliContaining(String namaPembeli);
}
