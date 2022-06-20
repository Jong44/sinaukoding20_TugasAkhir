package com.sinaukoding.Tanjung.controller;

import com.sinaukoding.Tanjung.Response;
import com.sinaukoding.Tanjung.entitiy.dto.SupplierDTO;
import com.sinaukoding.Tanjung.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/supplier")
public class SupplierController {
    @Autowired
    SupplierService service;

    @PostMapping
    public Response saveSupplier(@RequestBody SupplierDTO param){
        return new Response(service.save(param),"Data berhasil disimpan", HttpStatus.OK);
    }

    @GetMapping
    public Response findAll(){
        return new Response(service.lihatSemuaData(),"Data berhasil ditampilkan", HttpStatus.OK);
    }

    @GetMapping(value = "/find-by-nama-supplier")
    public Response findByNamaPembeli(@RequestParam(value = "namaSupplier") String namaSupplier){
        List<SupplierDTO> data = service.findByNamaSupplier(namaSupplier);
        return new Response(data, data.isEmpty() ? "Barang tidak ditemukan" : "Barang ditemukan", HttpStatus.OK);
    }

    @GetMapping(value = "/{id_supplier}")
    public Response findById(@PathVariable int id_supplier){
        SupplierDTO data = service.findById(id_supplier);
        return new Response(data, data !=null ? "Data ditemukan": "Data tidak ditemukan", HttpStatus.OK);
    }

    @PutMapping(value = "/{id_supplier}")
    public Response updateSupplier(@RequestBody SupplierDTO param,@PathVariable int id_supplier){
        SupplierDTO data = service.updateSupplier(param, id_supplier);
        return new Response(data, data != null ? "Data berhasil diubah" : "Data gagal diubah", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id_supplier}")
    public Response DeleteSupplier(@PathVariable int id_supplier){
        if (service.deleteSupplier(id_supplier)){
            return new Response("Data berhasil dihapus", HttpStatus.OK);
        }
        else {
            return new Response("Data gagal dihapus", HttpStatus.OK);
        }

    }
}
