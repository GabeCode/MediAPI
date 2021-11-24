package com.gabrego.mediapi.controller;

import com.gabrego.mediapi.entity.GlucoMeasure;
import com.gabrego.mediapi.entity.GlucoUnits;
import com.gabrego.mediapi.entity.PressureMeasure;
import com.gabrego.mediapi.entity.User;
import com.gabrego.mediapi.service.GlucoMeasureService;
import com.gabrego.mediapi.service.GlucoUnitsService;
import com.gabrego.mediapi.service.PressureMeasureService;
import com.gabrego.mediapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping("/measurement/units")
public class MeasureUnitsRestController {

    @Autowired
    private GlucoUnitsService glucoUnitsService;


    @GetMapping("/")
    public List<GlucoUnits> findAllGlucoseUnits() { return glucoUnitsService.findAll(); }

    @GetMapping("/{glucoId}")
    public GlucoUnits getGlucoseMeasureById(@PathVariable int glucoId){
        GlucoUnits glucoUnits = glucoUnitsService.findById(glucoId);

        if(glucoUnits == null) {
            System.out.println("No encontrado");
            return new GlucoUnits();
        }
        System.out.println(glucoUnits);
        return glucoUnits;
    }

    @PostMapping("/")
    public GlucoUnits addGlucoseMeasure(@RequestBody GlucoUnits glucoUnits) {
        glucoUnits.setId(0);
        glucoUnitsService.save(glucoUnits);
        return glucoUnits;

    }

    @PutMapping("/")
    public GlucoUnits updateGlucoseMeasure(@RequestBody GlucoUnits glucoUnits) {
        glucoUnitsService.save(glucoUnits);
        return glucoUnits;
    }

    @DeleteMapping("/{measureId}")
    public int deleteGlucoseMeasureById(@PathVariable int measureId) {

        GlucoUnits glucoUnits = glucoUnitsService.findById(measureId);

        if(glucoUnits == null) {
            return 0;
        }

        return glucoUnitsService.deleteById(measureId);
    }


}
