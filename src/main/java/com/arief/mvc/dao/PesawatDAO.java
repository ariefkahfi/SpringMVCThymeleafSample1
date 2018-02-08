package com.arief.mvc.dao;

import com.arief.mvc.models.Pesawat;

import java.util.List;

public interface PesawatDAO {
    void save(Pesawat p);
    List<Pesawat> getAll();
    Pesawat getOne(String idPesawat);
    void delete(Pesawat p);
}
