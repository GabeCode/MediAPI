package com.gabrego.mediapi.dao;

import com.gabrego.mediapi.entity.GlucoMeasure;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class GlucoMeasureDAOImpl implements GlucoMeasureDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<GlucoMeasure> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<GlucoMeasure> theQuery = currentSession.createQuery("FROM GlucoMeasure", GlucoMeasure.class);
        return theQuery.getResultList();
    }

    @Override
    public GlucoMeasure findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.getReference(GlucoMeasure.class, id);
    }

    @Override
    public List<GlucoMeasure> findByUserId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<GlucoMeasure> theQuery = currentSession.createQuery("FROM GlucoMeasure WHERE user_id.id=:idUser", GlucoMeasure.class);
        theQuery.setParameter("idUser", id);
        return theQuery.getResultList();
    }

    @Override
    public List<GlucoMeasure> findFirstTenByUserId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<GlucoMeasure> theQuery = currentSession.createQuery("FROM GlucoMeasure WHERE user_id.id=:idUser ORDER BY id DESC", GlucoMeasure.class).setMaxResults(10);
        theQuery.setParameter("idUser", id);
        return theQuery.getResultList();
    }

    @Override
    public void save(GlucoMeasure glucoMeasure) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(glucoMeasure);
    }

    @Transactional
    @Override
    public int deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<GlucoMeasure> theQuery = currentSession.createQuery("FROM GlucoMeasure WHERE id=:idMeasure", GlucoMeasure.class);
        theQuery.setParameter("idMeasure", id);
        return theQuery.executeUpdate();
    }

    @Override
    public int deleteByUserId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<GlucoMeasure> theQuery = currentSession.createQuery("FROM GlucoMeasure WHERE user_id.id=:idUser", GlucoMeasure.class);
        theQuery.setParameter("idUser", id);
        return theQuery.executeUpdate();
    }
}
