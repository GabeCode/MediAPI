package com.gabrego.mediapi.service;

import com.gabrego.mediapi.entity.GlucoMeasure;

import java.util.List;


public interface GlucoMeasureService {
    public List<GlucoMeasure> findAll();

    public GlucoMeasure findById(int id);

    public List<GlucoMeasure> findByUserId(int id);

    public List<GlucoMeasure> findFirstTenByUserId(int id);

    public void save(GlucoMeasure glucoMeasure);

    public int deleteById(int id);

    public int deleteByUserId(int id);
}
