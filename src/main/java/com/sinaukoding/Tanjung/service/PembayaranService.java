package com.sinaukoding.Tanjung.service;

import com.sinaukoding.Tanjung.entitiy.Barang;
import com.sinaukoding.Tanjung.entitiy.Pembayaran;
import com.sinaukoding.Tanjung.entitiy.dto.BarangCostumeDTO;
import com.sinaukoding.Tanjung.entitiy.dto.BarangDTO;
import com.sinaukoding.Tanjung.entitiy.dto.PembayaranCostumeDTO;
import com.sinaukoding.Tanjung.entitiy.dto.PembayaranDTO;
import com.sinaukoding.Tanjung.entitiy.mapping.BarangMapping;
import com.sinaukoding.Tanjung.entitiy.mapping.PembayaranMapping;
import com.sinaukoding.Tanjung.repository.PembayaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PembayaranService {
    @Autowired
    PembayaranRepository repository;

    public PembayaranDTO save(PembayaranDTO param){
        Pembayaran pembayaran = repository.save(PembayaranMapping.INSTANCE.toEnntity(param));
        return PembayaranMapping.INSTANCE.toDDto(pembayaran);
    }

    public List<PembayaranDTO> lihatSemuaData(){
        return PembayaranMapping.INSTANCE.toPembayaranDTOList(repository.findAll());
    }

    public PembayaranDTO findById(Integer id_pembayaran){
        return PembayaranMapping.INSTANCE.toDDto(repository.findById(id_pembayaran).orElse(null));
    }

    public PembayaranDTO updatePembayaran(PembayaranDTO pembayaran, Integer id_pembayaran){
        Pembayaran referenceData = repository.findById(id_pembayaran).orElse(null);

        if (referenceData != null ){
            referenceData.setTotal(pembayaran.getTotal() != null ? pembayaran.getTotal() : referenceData.getTotal());
            referenceData.setTglBayar(pembayaran.getTglBayar() !=null ? pembayaran.getTglBayar() : referenceData.getTglBayar());

            return PembayaranMapping.INSTANCE.toDDto(repository.save(referenceData));
        }

        return null;

    }

    public boolean deletePembayaran(int id_pembayaran){
        Pembayaran reference = repository.findById(id_pembayaran).orElse(null);



        if (reference != null) {
            repository.delete(reference);
            return true;
        }
        return false;
    }
}
