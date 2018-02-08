package com.arief.mvc.dao;

import com.arief.mvc.models.Penumpang;

import java.util.List;

public interface PenumpangDAO {
    void save(Penumpang p);
    Penumpang getOne(int idPenumpang);
    List<Penumpang> getAll();
    void delete(Penumpang p);
}
