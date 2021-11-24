package com.gabrego.mediapi.service;

import com.gabrego.mediapi.dao.GlucoUnitsDAO;
import com.gabrego.mediapi.entity.GlucoUnits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GlucoUnitsServiceImpl implements GlucoUnitsService{

    @Autowired
    private GlucoUnitsDAO glucoUnitsDAO;

    @Override
    public List<GlucoUnits> findAll() {
        return glucoUnitsDAO.findAll();
    }

    @Override
    public GlucoUnits findById(int id) {
        return glucoUnitsDAO.findById(id);
    }

    @Override
    public void save(GlucoUnits glucoUnits) {
        glucoUnitsDAO.save(glucoUnits);
    }

    @Override
    public int deleteById(int id) {
        return glucoUnitsDAO.deleteById(id);
    }
}
