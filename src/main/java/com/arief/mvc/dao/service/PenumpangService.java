package com.arief.mvc.dao.service;

import com.arief.mvc.dao.PenumpangDAO;
import com.arief.mvc.dao.impl.PenumpangDAOImpl;
import com.arief.mvc.models.Penumpang;
import com.arief.mvc.models.Tiket;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Service
public class PenumpangService implements GenericService<Penumpang,Integer>{

    @Autowired
    private PenumpangDAO penumpangDAO;
    @Autowired
    private TransactionTemplate template;

    public void save(final Penumpang penumpang) {
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                penumpangDAO.save(penumpang);
            }
        });
    }


    public void delete(final Penumpang penumpang) {
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                PenumpangDAOImpl pDAOImpl = (PenumpangDAOImpl)penumpangDAO;
                pDAOImpl.deleteRelation(penumpang.getIdPenumpang(),penumpang.getPesawat().getIdPesawat());
                penumpangDAO.delete(penumpang);
            }
        });
    }

    public Penumpang getOne(final Integer integer) {
        return template.execute(new TransactionCallback<Penumpang>() {
            public Penumpang doInTransaction(TransactionStatus transactionStatus) {
                Penumpang p = penumpangDAO.getOne(integer);

                Hibernate.initialize(p.getPesawat());
                Hibernate.initialize(p.getTiket());

                return p;
            }
        });
    }

    public List<Penumpang> getAll() {
        return template.execute(new TransactionCallback<List<Penumpang>>() {
            public List<Penumpang> doInTransaction(TransactionStatus transactionStatus) {
                return penumpangDAO.getAll();
            }
        });
    }
}
