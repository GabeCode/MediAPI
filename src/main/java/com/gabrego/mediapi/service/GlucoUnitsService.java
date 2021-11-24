package com.gabrego.mediapi.service;

import com.gabrego.mediapi.entity.GlucoUnits;

import java.util.List;

public interface GlucoUnitsService {
    public List<GlucoUnits> findAll();

    public GlucoUnits findById(int id);

    public void save(GlucoUnits glucoUnits);

    public int deleteById(int id);
}
