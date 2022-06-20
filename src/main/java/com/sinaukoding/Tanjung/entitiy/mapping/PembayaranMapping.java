package com.sinaukoding.Tanjung.entitiy.mapping;


import com.sinaukoding.Tanjung.entitiy.Pembayaran;
import com.sinaukoding.Tanjung.entitiy.dto.PembayaranCostumeDTO;
import com.sinaukoding.Tanjung.entitiy.dto.PembayaranDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PembayaranMapping {
    PembayaranMapping INSTANCE = Mappers.getMapper(PembayaranMapping.class);

    Pembayaran toEnntity(PembayaranDTO dto);

    PembayaranDTO toDDto(Pembayaran barang);

    List<Pembayaran> toPembayaranList(List<PembayaranDTO> data);

    List<PembayaranDTO> toPembayaranDTOList(List<Pembayaran> data);

    List<PembayaranCostumeDTO> toCostumeDTO(List<Pembayaran> data);
}
