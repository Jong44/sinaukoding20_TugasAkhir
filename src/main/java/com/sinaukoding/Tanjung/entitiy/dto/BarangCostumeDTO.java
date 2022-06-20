package com.sinaukoding.Tanjung.entitiy.dto;

import com.sinaukoding.Tanjung.entitiy.Supplier;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
public class BarangCostumeDTO {
    private Integer idBarang;
    private String namaBarang;



}
