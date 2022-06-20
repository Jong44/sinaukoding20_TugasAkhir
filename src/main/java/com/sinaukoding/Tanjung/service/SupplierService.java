package com.sinaukoding.Tanjung.service;

import com.sinaukoding.Tanjung.entitiy.Pembeli;
import com.sinaukoding.Tanjung.entitiy.Supplier;
import com.sinaukoding.Tanjung.entitiy.dto.PembeliDTO;
import com.sinaukoding.Tanjung.entitiy.dto.SupplierDTO;
import com.sinaukoding.Tanjung.entitiy.mapping.PembeliMapping;
import com.sinaukoding.Tanjung.entitiy.mapping.SupplierMapping;
import com.sinaukoding.Tanjung.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository repository;

    public SupplierDTO save(SupplierDTO param){
        Supplier supplier = repository.save(SupplierMapping.INSTANCE.toEntity(param));
        return SupplierMapping.INSTANCE.toDto(supplier);
    }

    public List<SupplierDTO> lihatSemuaData(){
        return SupplierMapping.INSTANCE.toSupplierDTOList(repository.findAll());
    }


    public SupplierDTO findById(Integer id_supplier){
        return SupplierMapping.INSTANCE.toDto(repository.findById(id_supplier).orElse(null));
    }

    public List<SupplierDTO> findByNamaSupplier(String param){
        return SupplierMapping.INSTANCE.toSupplierDTOList(repository.findByNamaSupplierContaining(param));
    }

    public SupplierDTO updateSupplier(SupplierDTO supplier, Integer id_supplier){
        Supplier referenceData = repository.findById(id_supplier).orElse(null);

        if (referenceData != null ){

            referenceData.setNamaSupplier(supplier.getNamaSupplier() !=null ? supplier.getNamaSupplier() :referenceData.getNamaSupplier());
            referenceData.setAlamat(supplier.getAlamat() !=null ? supplier.getAlamat() : referenceData.getAlamat());
            referenceData.setNoTelp(supplier.getNoTelp() !=null ? supplier.getNoTelp() : referenceData.getNoTelp());

            return SupplierMapping.INSTANCE.toDto(repository.save(referenceData));
        }

        return null;

    }

    public boolean deleteSupplier(int id_supplier){
        Supplier reference = repository.findById(id_supplier).orElse(null);



        if (reference != null) {
            repository.delete(reference);
            return true;
        }
        return false;
    }
}
