package com.sinaukoding.Tanjung.entitiy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "supplier")
@Setter
@Getter
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_supplier")
    private Integer idSupplier;

    @Column(name = "nama_supplier")
    private String namaSupplier;

    @Column(name = "no_telp")
    private String noTelp;

    @Column(name = "alamat")
    private String alamat;


}
