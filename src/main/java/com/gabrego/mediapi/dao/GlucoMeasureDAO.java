package com.gabrego.mediapi.dao;

import com.gabrego.mediapi.entity.GlucoMeasure;

import java.util.List;

public interface GlucoMeasureDAO {
    public List<GlucoMeasure> findAll();

    public GlucoMeasure findById(int id);

    public List<GlucoMeasure> findByUserId(int id);

    public List<GlucoMeasure> findFirstTenByUserId(int id);

    public void save(GlucoMeasure glucoMeasure);

    public int deleteById(int id);

    public int deleteByUserId(int id);
}
