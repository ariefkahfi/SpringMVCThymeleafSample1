package com.arief.mvc.dao.service;


import com.arief.mvc.dao.PesawatDAO;
import com.arief.mvc.models.Pesawat;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Service
public class PesawatService implements GenericService<Pesawat,String>{

    @Autowired
    private PesawatDAO pesawatDAO;
    @Autowired
    private TransactionTemplate template;

    public void save(final Pesawat pesawat) {
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                pesawatDAO.save(pesawat);
            }
        });
    }

    public void delete(final Pesawat pesawat) {
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                pesawatDAO.delete(pesawat);
            }
        });
    }

    public Pesawat getOne(final String s) {
        return template.execute(new TransactionCallback<Pesawat>() {
            public Pesawat doInTransaction(TransactionStatus transactionStatus) {
                Pesawat p  = pesawatDAO.getOne(s);
                Hibernate.initialize(p.getPenumpangList());
                return p;
            }
        });
    }

    public List<Pesawat> getAll() {
        return template.execute(new TransactionCallback<List<Pesawat>>() {
            public List<Pesawat> doInTransaction(TransactionStatus transactionStatus) {
                return pesawatDAO.getAll();
            }
        });
    }
}
