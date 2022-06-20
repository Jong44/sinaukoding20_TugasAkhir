package com.sinaukoding.Tanjung.controller;

import com.sinaukoding.Tanjung.Response;
import com.sinaukoding.Tanjung.entitiy.dto.TransaksiDTO;
import com.sinaukoding.Tanjung.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/transaksi")
public class TransaksiController {

    @Autowired
    TransaksiService service;

    @PostMapping
    public Response saveTransaksi(@RequestBody TransaksiDTO param){
        return new Response(service.save(param),"Data berhasil disimpan", HttpStatus.OK);
    }

    @GetMapping
    public Response findAll(){
        return new Response(service.lihatSemuaData(),"Data berhasil ditampilkan", HttpStatus.OK);
    }

    @GetMapping(value = "/{id_transaksi}")
    public Response findById(@PathVariable int id_transaksi){
        TransaksiDTO data = service.findById(id_transaksi);
        return new Response(data, data !=null ? "Data ditemukan": "Data tidak ditemukan", HttpStatus.OK);
    }

    @PutMapping(value = "/{id_transaksi}")
    public Response updateTransaksi(@RequestBody TransaksiDTO param,@PathVariable int id_transaksi){
        TransaksiDTO data = service.updateTransaksi(param, id_transaksi);
        return new Response(data, data != null ? "Data berhasil diubah" : "Data gagal diubah", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id_transaksi}")
    public Response DeleteTransaksi(@PathVariable int id_transaksi){
        if (service.deleteTransaksi(id_transaksi)){
            return new Response("Data berhasil dihapus", HttpStatus.OK);
        }
        else {
            return new Response("Data gagal dihapus", HttpStatus.OK);
        }

    }
}
