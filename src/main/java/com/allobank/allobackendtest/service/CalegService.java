package com.allobank.allobackendtest.service;

import java.util.List;
import java.util.UUID;


import org.springframework.stereotype.Service;

import com.allobank.allobackendtest.model.Caleg;

import com.allobank.allobackendtest.repository.CalegRepo;

@Service
public class CalegService {

	private CalegRepo calegRepo;
	

	
	 public CalegService(CalegRepo calegRepo) {
        this.calegRepo = calegRepo;
    }

    /**
     * Mendapatkan seluruh daftar calon legislatif.
     *
     * @return List dari seluruh calon legislatif.
     */

    public List<Caleg> getAllCaleg() {
        return (List<Caleg>) calegRepo.findAll();
    }

    /**
     * Mendapatkan seluruh daftar calon legislatif yang diurutkan berdasarkan nomor urut secara ascending (menaik).
     *
     * @return List dari seluruh calon legislatif yang diurutkan berdasarkan nomor urut.
     */

    public List<Caleg> getAllCalegOrderByNoUrut() {
        return (List<Caleg>) calegRepo.findAllByOrderByNomorUrutAsc();
    }

    /**
     * Mendapatkan calon legislatif berdasarkan ID Dapil (Daerah Pemilihan).
     *
     * @param dapilId UUID dari Dapil.
     * @return List dari calon legislatif berdasarkan Dapil.
     */

    public List<Caleg> getCalegByDapil(UUID dapilId) {
        return (List<Caleg>) calegRepo.findByDapilId(dapilId);
    }

    /**
     * Mendapatkan calon legislatif berdasarkan ID Partai politik.
     *
     * @param partaiId UUID dari Partai politik.
     * @return List dari calon legislatif berdasarkan Partai politik.
     */

    public List<Caleg> getCalegByPartai(UUID partaiId) {
        return (List<Caleg>) calegRepo.findByPartaiId(partaiId);
    }

    /**
     * Mendapatkan calon legislatif berdasarkan ID Dapil (Daerah Pemilihan) dan ID Partai politik.
     *
     * @param partaiId UUID dari Partai politik.
     * @param dapilId  UUID dari Dapil.
     * @return List dari calon legislatif berdasarkan Partai dan Dapil.
     */
	
    public List<Caleg> getCalegByPartaiAndDapil(UUID partaiId, UUID dapilId) {
        return (List<Caleg>) calegRepo.findByDapilIdAndPartaiId(dapilId, partaiId);
    }
}
