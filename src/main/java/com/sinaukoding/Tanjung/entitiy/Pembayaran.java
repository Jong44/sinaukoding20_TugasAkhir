package com.sinaukoding.Tanjung.entitiy;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pembayaran")
@Setter
@Getter
public class Pembayaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pembayaran")
    private int id_pembayaran;

    @Column(name = "tgl_bayar")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyy")
    private Date tglBayar;

    @Column(name = "total")
    private Double Total;

    @OneToMany(mappedBy = "pembayaran")
    List<Transaksi> transaksiList = new ArrayList<>();
}
