package com.arief.mvc.dao.service;

import java.io.Serializable;
import java.util.List;

public interface GenericService <T , ID extends Serializable> {
    void save(T t);
    void delete(T t);
    T getOne(ID id);
    List<T> getAll();
}
