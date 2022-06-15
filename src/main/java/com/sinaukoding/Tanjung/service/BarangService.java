package com.sinaukoding.Tanjung.service;

import com.sinaukoding.Tanjung.entitiy.Barang;
import com.sinaukoding.Tanjung.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarangService {
    @Autowired
    BarangRepository repository;

    public Barang save(Barang param){
        return repository.save(param);
    }

    public List<Barang> lihatSemuaData(){
        return repository.findAll();
    }

    public List<Barang> findByNamaBarang(String param){
        return repository.findByNamaBarangContaining(param);
    }

    public Barang findById(Integer id_barang){
        return repository.findById(id_barang).get();
    }

    public Barang updateBarang(Barang barang, Integer id_barang){
        Barang referenceData = repository.findById(id_barang).get();
        referenceData.setNamaBarang(barang.getNamaBarang() != null ? barang.getNamaBarang() : referenceData.getNamaBarang());
        return repository.save(referenceData);
    }

    public boolean deleteBarang(int id_barang){
        Barang reference = repository.findById(id_barang).orElse(new Barang());
        repository.delete(reference);

        reference = repository.findById(id_barang).orElse(null);

        if (reference == null)
            return true;
        return false;
    }
}
