package com.allobank.allobackendtest.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.allobank.allobackendtest.model.Caleg;

@Repository
public interface CalegRepo extends CrudRepository<Caleg, UUID> {

    // Mengambil seluruh calon legislatif yang diurutkan berdasarkan nomor urut secara ascending (menaik)
    public List<Caleg> findAllByOrderByNomorUrutAsc();
    
    // Mengambil calon legislatif berdasarkan ID Dapil (Daerah Pemilihan)
    public List<Caleg> findByDapilId(UUID dapilId);

    // Mengambil calon legislatif berdasarkan ID Partai politik
    public List<Caleg> findByPartaiId(UUID partaiId);
    
    // Mengambil calon legislatif berdasarkan ID Dapil dan ID Partai politik
    public List<Caleg> findByDapilIdAndPartaiId(UUID dapilId, UUID partaiId);
}

