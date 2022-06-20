package com.sinaukoding.Tanjung.entitiy.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;

@Getter
@Setter
public class TransaksiDTO {
    private int id_transaksi;
    private BarangCostumeDTO barang;
    private PembeliCostumeDTO pembeli;
    @JsonFormat(pattern = "dd/MM/yyy")
    private Date tglTransaksi;
    private String keterangan;
    private PembayaranCostumeDTO pembayaran;
}
