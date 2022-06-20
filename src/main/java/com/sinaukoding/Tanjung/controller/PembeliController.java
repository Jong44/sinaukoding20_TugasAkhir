package com.sinaukoding.Tanjung.controller;


import com.sinaukoding.Tanjung.Response;
import com.sinaukoding.Tanjung.entitiy.dto.PembeliDTO;
import com.sinaukoding.Tanjung.service.PembeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pembeli")
public class PembeliController {
    @Autowired
    PembeliService service;

    @PostMapping
    public Response savePembeli(@RequestBody PembeliDTO param){
        return new Response(service.save(param),"Data berhasil disimpan", HttpStatus.OK);
    }

    @GetMapping
    public Response findAll(){
        return new Response(service.lihatSemuaData(),"Data berhasil ditampilkan", HttpStatus.OK);
    }

    @GetMapping(value = "/find-by-nama-pembeli")
    public Response findByNamaPembeli(@RequestParam(value = "namaPembeli") String namaPembeli){
        List<PembeliDTO> data = service.findByNamaPembeli(namaPembeli);
        return new Response(data, data.isEmpty() ? "Barang tidak ditemukan" : "Barang ditemukan", HttpStatus.OK);
    }

    @GetMapping(value = "/{id_pembeli}")
    public Response findById(@PathVariable int id_pembeli){
        PembeliDTO data = service.findById(id_pembeli);
        return new Response(data, data !=null ? "Data ditemukan": "Data tidak ditemukan", HttpStatus.OK);
    }

    @PutMapping(value = "/{id_pembeli}")
    public Response updatePembeli(@RequestBody PembeliDTO param,@PathVariable int id_pembeli){
        PembeliDTO data = service.updatePembeli(param, id_pembeli);
        return new Response(data, data != null ? "Data berhasil diubah" : "Data gagal diubah", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id_pembeli}")
    public Response DeletePembeli(@PathVariable int id_pembeli){
        if (service.deletePembeli(id_pembeli)){
            return new Response("Data berhasil dihapus", HttpStatus.OK);
        }
        else {
            return new Response("Data gagal dihapus", HttpStatus.OK);
        }

    }

}
