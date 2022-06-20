package com.sinaukoding.Tanjung.service;

import com.sinaukoding.Tanjung.entitiy.Pembeli;
import com.sinaukoding.Tanjung.entitiy.dto.PembeliDTO;
import com.sinaukoding.Tanjung.entitiy.mapping.PembeliMapping;
import com.sinaukoding.Tanjung.repository.PembeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PembeliService {
    @Autowired
    PembeliRepository repository;

    public PembeliDTO save(PembeliDTO param){
        Pembeli pembeli = repository.save(PembeliMapping.INSTANCE.toEntity(param));
        return PembeliMapping.INSTANCE.toDto(pembeli);
    }

    public List<PembeliDTO> lihatSemuaData(){
        return PembeliMapping.INSTANCE.toPembeliDTOList(repository.findAll());
    }

    public List<PembeliDTO> findByNamaPembeli(String param){
        return PembeliMapping.INSTANCE.toPembeliDTOList(repository.findByNamaPembeliContaining(param));
    }


    public PembeliDTO findById(Integer id_pembeli){
        return PembeliMapping.INSTANCE.toDto(repository.findById(id_pembeli).orElse(null));
    }

    public PembeliDTO updatePembeli(PembeliDTO pembeli, Integer id_pembeli){
        Pembeli referenceData = repository.findById(id_pembeli).orElse(null);

        if (referenceData != null ){

            referenceData.setNamaPembeli(pembeli.getNamaPembeli() !=null ? pembeli.getNamaPembeli() : referenceData.getNamaPembeli());
            referenceData.setAlamat(pembeli.getAlamat() !=null ? pembeli.getAlamat() : referenceData.getAlamat());
            referenceData.setNoTelp(pembeli.getNoTelp() !=null ? pembeli.getNoTelp() : referenceData.getNoTelp());

            return PembeliMapping.INSTANCE.toDto(repository.save(referenceData));
        }

        return null;

    }

    public boolean deletePembeli(int id_pembeli){
        Pembeli reference = repository.findById(id_pembeli).orElse(null);



        if (reference != null) {
            repository.delete(reference);
            return true;
        }
        return false;
    }
}
