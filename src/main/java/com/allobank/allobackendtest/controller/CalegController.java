package com.allobank.allobackendtest.controller;

import java.util.List;
import java.util.UUID;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.allobank.allobackendtest.model.Caleg;

import com.allobank.allobackendtest.service.CalegService;

@RestController
@RequestMapping("/api/caleg")
public class CalegController {

    private final CalegService calegService;

    public CalegController(CalegService calegService) {
        this.calegService = calegService;
    }

    /**
     * Endpoint: GET /api/caleg
     * Deskripsi: Mendapatkan seluruh daftar calon legislatif.
     *
     * @return List dari seluruh calon legislatif.
     */
    @GetMapping
    public List<Caleg> getAllCaleg() {
        return calegService.getAllCaleg();
    }

    /**
     * Endpoint: GET /api/caleg/orderByNomorUrut
     * Deskripsi: Mendapatkan seluruh daftar calon legislatif yang diurutkan berdasarkan nomor urut.
     *
     * @return List dari seluruh calon legislatif yang diurutkan berdasarkan nomor urut.
     */
    @GetMapping("/orderByNomorUrut")
    public List<Caleg> getAllCalegOrderByNomorUrut() {
        return calegService.getAllCalegOrderByNoUrut();
    }

    /**
     * Endpoint: GET /api/caleg/filter?dapilId={dapilId}&partaiId={partaiId}
     * Deskripsi: Melakukan filter berdasarkan Dapil (dapilId) atau Partai (partaiId) atau keduanya.
     *            Ganti {dapilId} dan {partaiId} dengan UUID yang sesuai untuk melakukan filter berdasarkan nilai yang diinginkan.
     *
     * @param dapilId  UUID dari Dapil (Daerah Pemilihan). Opsional.
     * @param partaiId UUID dari Partai politik. Opsional.
     * @return List dari calon legislatif yang sesuai dengan filter yang diberikan.
     */

    @GetMapping("/filter")
    public List<Caleg> getCalegByFilter(
            @RequestParam(required = false) UUID dapilId,
            @RequestParam(required = false) UUID partaiId) {
        if (dapilId != null && partaiId != null) {
            return calegService.getCalegByPartaiAndDapil(partaiId, dapilId);
        } else if (dapilId != null) {
            return calegService.getCalegByDapil(dapilId);
        } else if (partaiId != null) {
            return calegService.getCalegByPartai(partaiId);
        } else {
            return calegService.getAllCaleg();
        }
    }
}