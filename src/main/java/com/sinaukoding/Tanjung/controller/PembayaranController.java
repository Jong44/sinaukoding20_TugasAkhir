package com.sinaukoding.Tanjung.controller;

import com.sinaukoding.Tanjung.Response;
import com.sinaukoding.Tanjung.entitiy.Pembayaran;
import com.sinaukoding.Tanjung.entitiy.dto.BarangDTO;
import com.sinaukoding.Tanjung.entitiy.dto.PembayaranDTO;
import com.sinaukoding.Tanjung.service.PembayaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pembayaran")
public class PembayaranController {

    @Autowired
    PembayaranService service;

    @PostMapping
    public Response savePembayaran(@RequestBody PembayaranDTO param){
        return new Response(service.save(param),"Data berhasil disimpan", HttpStatus.OK);
    }

    @GetMapping
    public Response findAll(){
        return new Response(service.lihatSemuaData(),"Data berhasil ditampilkan", HttpStatus.OK);
    }

    @GetMapping(value = "/{id_pembayaran}")
    public Response findById(@PathVariable int id_pembayaran){
        PembayaranDTO data = service.findById(id_pembayaran);
        return new Response(data, data !=null ? "Data ditemukan": "Data tidak ditemukan", HttpStatus.OK);
    }

    @PutMapping(value = "/{id_pembayaran}")
    public Response updateBarang(@RequestBody PembayaranDTO param,@PathVariable int id_pembayaran){
        PembayaranDTO data = service.updatePembayaran(param, id_pembayaran);
        return new Response(data, data != null ? "Data berhasil diubah" : "Data gagal diubah", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id_pembayaran}")
    public Response DeletePembayaran(@PathVariable int id_pembayaran){
        if (service.deletePembayaran(id_pembayaran)){
            return new Response("Data berhasil dihapus", HttpStatus.OK);
        }
        else {
            return new Response("Data gagal dihapus", HttpStatus.OK);
        }

    }
}
