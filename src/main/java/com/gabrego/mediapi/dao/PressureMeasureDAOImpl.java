package com.gabrego.mediapi.dao;

import com.gabrego.mediapi.entity.PressureMeasure;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PressureMeasureDAOImpl implements PressureMeasureDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<PressureMeasure> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<PressureMeasure> theQuery = currentSession.createQuery("FROM PressureMeasure ", PressureMeasure.class);
        return theQuery.getResultList();
    }

    @Override
    public PressureMeasure findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.getReference(PressureMeasure.class, id);
    }

    @Override
    public List<PressureMeasure> findByUserId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<PressureMeasure> theQuery = currentSession.createQuery("FROM PressureMeasure WHERE user_id.id=:idUser", PressureMeasure.class);
        theQuery.setParameter("idUser", id);
        return theQuery.getResultList();
    }

    @Override
    public List<PressureMeasure> findFirstTenByUserId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<PressureMeasure> theQuery = currentSession.createQuery("FROM PressureMeasure WHERE user_id.id=:idUser ORDER BY id DESC", PressureMeasure.class).setMaxResults(10);
        theQuery.setParameter("idUser", id);
        return theQuery.getResultList();
    }

    @Override
    public void save(PressureMeasure pressureMeasure) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(pressureMeasure);
    }

    @Override
    public int deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<PressureMeasure> theQuery = currentSession.createQuery("FROM PressureMeasure WHERE id=:idMeasure", PressureMeasure.class);
        theQuery.setParameter("idMeasure", id);
        return theQuery.executeUpdate();
    }

    @Override
    public int deleteByUserId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<PressureMeasure> theQuery = currentSession.createQuery("FROM PressureMeasure WHERE user_id.id=:idUser", PressureMeasure.class);
        theQuery.setParameter("idUser", id);
        return theQuery.executeUpdate();
    }
}
