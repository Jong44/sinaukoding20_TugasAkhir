package com.sinaukoding.Tanjung.entitiy.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class PembayaranDTO {
    private int id_pembayaran;
    private String Total;
    @JsonFormat(pattern = "dd/MM/yyy")
    private Date tglBayar;
}
