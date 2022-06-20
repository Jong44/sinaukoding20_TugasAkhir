package com.sinaukoding.Tanjung.entitiy.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class PembayaranCostumeDTO {
    private int id_pembayaran;
    @JsonFormat(pattern = "dd/MM/yyy")
    private Date tglBayar;
    private String Total;

}
