package com.sinaukoding.Tanjung.entitiy.mapping;


import com.sinaukoding.Tanjung.entitiy.Pembayaran;
import com.sinaukoding.Tanjung.entitiy.Pembeli;
import com.sinaukoding.Tanjung.entitiy.dto.PembayaranCostumeDTO;
import com.sinaukoding.Tanjung.entitiy.dto.PembayaranDTO;
import com.sinaukoding.Tanjung.entitiy.dto.PembeliCostumeDTO;
import com.sinaukoding.Tanjung.entitiy.dto.PembeliDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PembeliMapping {
    PembeliMapping INSTANCE = Mappers.getMapper(PembeliMapping.class);

    Pembeli toEntity(PembeliDTO dto);

    PembeliDTO toDto(Pembeli pembeli);

    List<Pembeli> toPembeliList(List<PembeliDTO> data);

    List<PembeliDTO> toPembeliDTOList(List<Pembeli> data);

    List<PembeliCostumeDTO> toCostumeDTO(List<Pembeli> data);
}
