package com.sinaukoding.Tanjung.service;

import com.sinaukoding.Tanjung.entitiy.Transaksi;
import com.sinaukoding.Tanjung.entitiy.dto.TransaksiDTO;
import com.sinaukoding.Tanjung.entitiy.mapping.TransaksiMapping;
import com.sinaukoding.Tanjung.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaksiService {
    @Autowired
    TransaksiRepository repository;

    public TransaksiDTO save(TransaksiDTO param){
        Transaksi transaksi = repository.save(TransaksiMapping.INSTANCE.toEntity(param));
        return TransaksiMapping.INSTANCE.toDto(transaksi);
    }

    public List<TransaksiDTO> lihatSemuaData(){
        return TransaksiMapping.INSTANCE.toTransaksiDTOList(repository.findAll());
    }


    public TransaksiDTO findById(Integer id_transaksi){
        return TransaksiMapping.INSTANCE.toDto(repository.findById(id_transaksi).orElse(null));
    }


    public TransaksiDTO updateTransaksi(TransaksiDTO transaksi, Integer id_transaksi){
       Transaksi referenceData = repository.findById(id_transaksi).orElse(null);

        if (referenceData != null ){

            referenceData.setTglTransaksi(transaksi.getTglTransaksi() !=null ? transaksi.getTglTransaksi() :referenceData.getTglTransaksi());
            referenceData.setKeterangan(transaksi.getKeterangan() !=null ? transaksi.getKeterangan() :referenceData.getKeterangan());


            return TransaksiMapping.INSTANCE.toDto(repository.save(referenceData));
        }

        return null;

    }

    public boolean deleteTransaksi(int id_transaksi){
        Transaksi reference = repository.findById(id_transaksi).orElse(null);


        if (reference != null) {
            repository.delete(reference);
            return true;
        }
        return false;
    }

}
