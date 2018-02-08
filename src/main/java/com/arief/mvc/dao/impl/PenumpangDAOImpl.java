package com.arief.mvc.dao.impl;


import com.arief.mvc.dao.PenumpangDAO;
import com.arief.mvc.models.Penumpang;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PenumpangDAOImpl implements PenumpangDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Penumpang p) {
        sessionFactory
                .getCurrentSession()
                .save(p);
    }

    public Penumpang getOne(int idPenumpang) {
        return sessionFactory
                .getCurrentSession()
                .get(Penumpang.class,idPenumpang);
    }

    public List<Penumpang> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Penumpang").list();
    }


    public void deleteRelation(int idPenumpang ,String idPesawat){
        sessionFactory
                .getCurrentSession()
                .createSQLQuery("delete from pesawat_penumpang" +
                        " where id_pesawat = " +
                        ":id_pesawat " +
                        "and id_penumpang = :id_penumpang")
                .setParameter("id_pesawat",idPesawat)
                .setParameter("id_penumpang",idPenumpang)
                .executeUpdate();
    }

    public void delete(Penumpang p) {
        sessionFactory
                .getCurrentSession()
                .delete(p);
    }
}
