package com.sinaukoding.Tanjung.entitiy.dto;

import com.sinaukoding.Tanjung.entitiy.Barang;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class SupplierDTO {
    private Integer idSupplier;

    private String namaSupplier;

    private String noTelp;

    private String alamat;


}
