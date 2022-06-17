package com.sinaukoding.Tanjung.controller;
;
import com.sinaukoding.Tanjung.Response;
import com.sinaukoding.Tanjung.entitiy.Barang;
import com.sinaukoding.Tanjung.entitiy.dto.BarangCostumeDTO;
import com.sinaukoding.Tanjung.entitiy.dto.BarangDTO;
import com.sinaukoding.Tanjung.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/barang")
public class BarangController {

    @Autowired
    BarangService service;

    @PostMapping
    public Response saveBarang(@RequestBody BarangDTO param){
        return new Response(service.save(param),"Data berhasil disimpan", HttpStatus.OK);
    }

    @GetMapping
    public Response findAll(){
        return new Response(service.lihatSemuaData(),"Data berhasil ditampilkan", HttpStatus.OK);
    }

    @GetMapping(value = "/find-by-nama-barang")
    public Response findByNamaBarang(@RequestParam(value = "namaBarang") String namaBarang){
        List<BarangDTO> data = service.findByNamaBarang(namaBarang);
        return new Response(data, data.isEmpty() ? "Barang tidak ditemukan" : "Barang ditemukan", HttpStatus.OK);
    }

    @GetMapping(value = "/{id_barang}")
        public Response findById(@PathVariable int id_barang){
        BarangDTO data = service.findById(id_barang);
        return new Response(data, data !=null ? "Data ditemukan": "Data tidak ditemukan", HttpStatus.OK);
    }

    @PutMapping(value = "/{id_barang}")
    public Response updateBarang(@RequestBody BarangDTO param,@PathVariable int id_barang){
        BarangDTO data = service.updateBarang(param, id_barang);
        return new Response(data, data != null ? "Data berhasil diubah" : "Data gagal diubah", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id_barang}")
    public Response DeleteBarang(@PathVariable int id_barang){
        if (service.deleteBarang(id_barang)){
            return new Response("Data berhasil dihapus", HttpStatus.OK);
        }
        else {
            return new Response("Data gagal dihapus", HttpStatus.OK);
        }

    }




}
