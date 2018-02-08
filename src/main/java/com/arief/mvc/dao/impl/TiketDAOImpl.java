package com.arief.mvc.dao.impl;

import com.arief.mvc.dao.TiketDAO;
import com.arief.mvc.models.Tiket;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TiketDAOImpl implements TiketDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public Tiket getOne(String tiketId) {
        return sessionFactory
                .getCurrentSession()
                .get(Tiket.class,tiketId);
    }
}
