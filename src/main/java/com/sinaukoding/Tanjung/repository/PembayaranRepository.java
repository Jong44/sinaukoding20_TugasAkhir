package com.sinaukoding.Tanjung.repository;

import com.sinaukoding.Tanjung.entitiy.Pembayaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PembayaranRepository extends JpaRepository<Pembayaran, Integer> {

}
