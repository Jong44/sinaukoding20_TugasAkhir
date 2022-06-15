package com.sinaukoding.Tanjung.entitiy;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaksi")
@Setter
@Getter
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaksi")
    private int id_transaksi;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_barang")
    private Barang barang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pembeli")
    private Pembeli pembeli;

    @Column(name = "tgl_transaksi")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyy")
    private Date tglTransaksi;

    @Column(name = "keterangan")
    private String keterangan;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pembayaran")
    private Pembayaran pembayaran;




}
