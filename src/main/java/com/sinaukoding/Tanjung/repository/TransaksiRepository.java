package com.sinaukoding.Tanjung.repository;

import com.sinaukoding.Tanjung.entitiy.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaksiRepository extends JpaRepository<Transaksi, Integer> {

}