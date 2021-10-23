package com.gabrego.mediapi.dao;

import com.gabrego.mediapi.entity.PressureMeasure;

import java.util.List;

public interface PressureMeasureDAO {
    public List<PressureMeasure> findAll();

    public PressureMeasure findById(int id);

    public List<PressureMeasure> findByUserId(int id);

    public List<PressureMeasure> findFirstTenByUserId(int id);

    public void save(PressureMeasure pressureMeasure);

    public int deleteById(int id);

    public int deleteByUserId(int id);
}
