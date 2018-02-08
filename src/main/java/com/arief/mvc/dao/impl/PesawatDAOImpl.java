package com.arief.mvc.dao.impl;

import com.arief.mvc.dao.PesawatDAO;
import com.arief.mvc.models.Pesawat;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PesawatDAOImpl implements PesawatDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Pesawat p) {
        sessionFactory
                .getCurrentSession()
                .save(p);
    }

    public List<Pesawat> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Pesawat").list();
    }

    public Pesawat getOne(String idPesawat) {
        return sessionFactory
                .getCurrentSession()
                .get(Pesawat.class,idPesawat);
    }

    public void delete(Pesawat p) {
        sessionFactory
                .getCurrentSession()
                .delete(p);
    }
}
