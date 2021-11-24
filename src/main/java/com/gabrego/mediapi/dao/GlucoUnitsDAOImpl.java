package com.gabrego.mediapi.dao;

import com.gabrego.mediapi.entity.GlucoMeasure;
import com.gabrego.mediapi.entity.GlucoUnits;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class GlucoUnitsDAOImpl implements GlucoUnitsDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<GlucoUnits> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<GlucoUnits> theQuery = currentSession.createQuery("FROM GlucoUnits ", GlucoUnits.class);
        return theQuery.getResultList();
    }

    @Override
    public GlucoUnits findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.getReference(GlucoUnits.class, id);
    }

    @Override
    public void save(GlucoUnits glucoUnits) {
        Session currentSession = entityManager.unwrap(Session.class);
        Transaction transaction = currentSession.beginTransaction();
        currentSession.saveOrUpdate(glucoUnits);
        transaction.commit();
    }

    @Override
    public int deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<GlucoUnits> theQuery = currentSession.createQuery("FROM GlucoUnits WHERE id=:idUnits");
        theQuery.setParameter("idUnits", id);
        return theQuery.executeUpdate();
    }
}
