package com.sinaukoding.Tanjung.service;

import com.sinaukoding.Tanjung.entitiy.Barang;
import com.sinaukoding.Tanjung.entitiy.dto.BarangCostumeDTO;
import com.sinaukoding.Tanjung.entitiy.dto.BarangDTO;
import com.sinaukoding.Tanjung.entitiy.mapping.BarangMapping;
import com.sinaukoding.Tanjung.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarangService {
    @Autowired
    BarangRepository repository;

    public BarangDTO save(BarangDTO param){
        Barang barang = repository.save(BarangMapping.INSTANCE.toEntity(param));
        return BarangMapping.INSTANCE.toDto(barang);
    }

    public List<BarangDTO> lihatSemuaData(){
        return BarangMapping.INSTANCE.toBarangDTOList(repository.findAll());
    }


    public List<BarangDTO> findByNamaBarang(String param){
        return BarangMapping.INSTANCE.toBarangDTOList(repository.findByNamaBarangContaining(param));
    }

    public BarangDTO findById(Integer id_barang){
        return BarangMapping.INSTANCE.toDto(repository.findById(id_barang).orElse(null));
    }

    public BarangDTO updateBarang(BarangDTO barang, Integer id_barang){
        Barang referenceData = repository.findById(id_barang).orElse(null);

        if (referenceData != null ){
            referenceData.setNamaBarang(barang.getNamaBarang() != null ? barang.getNamaBarang() : referenceData.getNamaBarang());
            referenceData.setHarga(barang.getHarga() !=null ? barang.getHarga() : referenceData.getHarga());
            referenceData.setStok(barang.getStok() !=null ? barang.getStok() : referenceData.getStok());

            return BarangMapping.INSTANCE.toDto(repository.save(referenceData));
        }

        return null;

    }

    public boolean deleteBarang(int id_barang){
        Barang reference = repository.findById(id_barang).orElse(null);



        if (reference != null) {
            repository.delete(reference);
            return true;
        }
        return false;
    }
}

