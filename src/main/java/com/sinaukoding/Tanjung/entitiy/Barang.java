package com.sinaukoding.Tanjung.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "barang")
@Setter
@Getter
public class Barang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_barang")
    private int idBarang;

    @Column(name = "nama_barang")
    private String namaBarang;

    @Column(name = "harga")
    private String harga;

    @Column(name = "stok")
    private String stok;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_supplier")
    private Supplier supplier;

    @OneToMany(mappedBy = "barang")
    List<Transaksi> transaksiList = new ArrayList<>();



}
