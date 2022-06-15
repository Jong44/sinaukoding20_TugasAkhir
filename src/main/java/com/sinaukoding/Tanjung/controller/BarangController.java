package com.sinaukoding.Tanjung.controller;
;
import com.sinaukoding.Tanjung.entitiy.Barang;
import com.sinaukoding.Tanjung.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/barang")
public class BarangController {

    @Autowired
    BarangService service;

    @PostMapping
    public Barang saveBarang(@RequestBody Barang param){
        return service.save(param);
    }

    @GetMapping
    public List<Barang> findAll(){
        return service.lihatSemuaData();
    }

    @GetMapping(value = "/find-by-nama-barang")
        public List<Barang> findByNamaBarang(@RequestParam(value = "namaBarang") String namaBarang){
            return service.findByNamaBarang(namaBarang);
    }

    @PutMapping(value = "/{id_barang}")
    public Barang updateBarang(@RequestBody Barang param, @PathVariable int id_barang){
        return service.updateBarang(param, id_barang);
    }

    @DeleteMapping(value = "/{id_barang}")
    public String deleteBarang(@PathVariable int id_barang){
        if (service.deleteBarang(id_barang)){
            return "Data Berhasil dihapus";
        }
        else {
            return "Data Gagal dihapus";
        }
    }



}
