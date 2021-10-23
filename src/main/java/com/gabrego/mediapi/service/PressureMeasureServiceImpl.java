package com.gabrego.mediapi.service;

import com.gabrego.mediapi.dao.PressureMeasureDAO;
import com.gabrego.mediapi.entity.PressureMeasure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PressureMeasureServiceImpl implements PressureMeasureService{
    @Autowired
    private PressureMeasureDAO pressureMeasureDAO;

    @Override
    public List<PressureMeasure> findAll() {
        return pressureMeasureDAO.findAll();
    }

    @Override
    public PressureMeasure findById(int id) {
        return pressureMeasureDAO.findById(id);
    }

    @Override
    public List<PressureMeasure> findByUserId(int id) {
        return pressureMeasureDAO.findByUserId(id);
    }

    @Override
    public List<PressureMeasure> findFirstTenByUserId(int id) {
        return pressureMeasureDAO.findFirstTenByUserId(id);
    }

    @Override
    public void save(PressureMeasure pressureMeasure) {
        pressureMeasureDAO.save(pressureMeasure);
    }

    @Override
    public int deleteById(int id) {
        return pressureMeasureDAO.deleteById(id);
    }

    @Override
    public int deleteByUserId(int id) {
        return pressureMeasureDAO.deleteByUserId(id);
    }
}
