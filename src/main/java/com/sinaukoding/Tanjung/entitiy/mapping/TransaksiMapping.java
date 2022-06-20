package com.sinaukoding.Tanjung.entitiy.mapping;

import com.sinaukoding.Tanjung.entitiy.Transaksi;
import com.sinaukoding.Tanjung.entitiy.dto.TransaksiCostumeDTO;
import com.sinaukoding.Tanjung.entitiy.dto.TransaksiDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TransaksiMapping {
    TransaksiMapping INSTANCE = Mappers.getMapper(TransaksiMapping.class);

    Transaksi toEntity(TransaksiDTO dto);

    TransaksiDTO toDto(Transaksi transaksi);

    List<Transaksi> toTransaksiList(List<TransaksiDTO> data);

    List<TransaksiDTO> toTransaksiDTOList(List<Transaksi> data);

    List<TransaksiCostumeDTO> toCostumeDTO(List<Transaksi> data);
}
