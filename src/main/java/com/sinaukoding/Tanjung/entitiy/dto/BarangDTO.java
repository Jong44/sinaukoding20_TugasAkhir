package com.sinaukoding.Tanjung.entitiy.dto;


import com.sinaukoding.Tanjung.entitiy.Supplier;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Setter
@Getter
public class BarangDTO {
    private Integer idBarang;
    private String namaBarang;
    private String harga;
    private String stok;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_supplier")
    private SupplieCostumeDTO supplier;

}
