package com.gabrego.mediapi.service;

import com.gabrego.mediapi.dao.GlucoMeasureDAO;
import com.gabrego.mediapi.entity.GlucoMeasure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GlucoMeasureServiceImpl implements GlucoMeasureService {

    @Autowired
    private GlucoMeasureDAO glucoMeasureDAO;

    @Override
    public List<GlucoMeasure> findAll() {
        return glucoMeasureDAO.findAll();
    }

    @Override
    public GlucoMeasure findById(int id) {
        return glucoMeasureDAO.findById(id);
    }

    @Override
    public List<GlucoMeasure> findByUserId(int id) {
        return glucoMeasureDAO.findByUserId(id);
    }

    @Override
    public List<GlucoMeasure> findFirstTenByUserId(int id) {
        return glucoMeasureDAO.findFirstTenByUserId(id);
    }

    @Override
    public void save(GlucoMeasure glucoMeasure) {
        glucoMeasureDAO.save(glucoMeasure);
    }

    @Override
    public int deleteById(int id) {
        return glucoMeasureDAO.deleteById(id);
    }

    @Override
    public int deleteByUserId(int id) {
        return glucoMeasureDAO.deleteByUserId(id);
    }
}
