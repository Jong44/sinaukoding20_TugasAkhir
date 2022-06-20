package com.sinaukoding.Tanjung.entitiy.dto;

import com.sinaukoding.Tanjung.entitiy.Barang;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SupplieCostumeDTO {
    private Integer idSupplier;
    private String namaSupplier;



}
