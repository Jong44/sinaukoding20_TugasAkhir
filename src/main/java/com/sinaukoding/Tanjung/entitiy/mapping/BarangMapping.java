package com.sinaukoding.Tanjung.entitiy.mapping;

import com.sinaukoding.Tanjung.entitiy.Barang;
import com.sinaukoding.Tanjung.entitiy.dto.BarangCostumeDTO;
import com.sinaukoding.Tanjung.entitiy.dto.BarangDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BarangMapping{
    BarangMapping INSTANCE = Mappers.getMapper(BarangMapping.class);

    Barang toEntity(BarangDTO dto);

    BarangDTO toDto(Barang barang);

    List<Barang> toBarangList(List<BarangDTO> data);

    List<BarangDTO> toBarangDTOList(List<Barang> data);

    List<BarangCostumeDTO> toCostumeDTO(List<Barang> data);


}