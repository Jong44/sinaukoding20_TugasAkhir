package com.sinaukoding.Tanjung.entitiy.mapping;

import com.sinaukoding.Tanjung.entitiy.Pembeli;
import com.sinaukoding.Tanjung.entitiy.Supplier;
import com.sinaukoding.Tanjung.entitiy.dto.PembeliCostumeDTO;
import com.sinaukoding.Tanjung.entitiy.dto.PembeliDTO;
import com.sinaukoding.Tanjung.entitiy.dto.SupplieCostumeDTO;
import com.sinaukoding.Tanjung.entitiy.dto.SupplierDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SupplierMapping {
    SupplierMapping INSTANCE = Mappers.getMapper(SupplierMapping.class);

    Supplier toEntity(SupplierDTO dto);

    SupplierDTO toDto(Supplier supplier);

    List<Supplier> toSupplierList(List<SupplierDTO> data);

    List<SupplierDTO> toSupplierDTOList(List<Supplier> data);

    List<SupplieCostumeDTO> toCostumeDTO(List<Supplier> data);
}
