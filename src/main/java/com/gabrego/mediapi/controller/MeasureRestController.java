package com.gabrego.mediapi.controller;

import com.gabrego.mediapi.entity.GlucoMeasure;
import com.gabrego.mediapi.entity.PressureMeasure;
import com.gabrego.mediapi.entity.User;
import com.gabrego.mediapi.service.GlucoMeasureService;
import com.gabrego.mediapi.service.PressureMeasureService;
import com.gabrego.mediapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping("/measurement")
public class MeasureRestController {

    @Autowired
    private GlucoMeasureService glucoMeasureService;

    @Autowired
    private PressureMeasureService pressureMeasureService;

    @Autowired
    private UserService userService;

    @GetMapping("/glucose/")
    public List<GlucoMeasure> findAllGlucoseMeasures() { return glucoMeasureService.findAll(); }

    @GetMapping("/glucose/{glucoId}")
    public GlucoMeasure getGlucoseMeasureById(@PathVariable int glucoId){
        GlucoMeasure glucoMeasure = glucoMeasureService.findById(glucoId);

        if(glucoMeasure == null) {
            System.out.println("No encontrado");
            return new GlucoMeasure();
        }
        System.out.println(glucoMeasure);
        return glucoMeasure;
    }

    @GetMapping("/glucose/user/{userId}")
    public List<GlucoMeasure> getGlucoseMeasureByUserId(@PathVariable int userId){
        List<GlucoMeasure> glucoMeasures = glucoMeasureService.findByUserId(userId);

        if(glucoMeasures == null) {
            System.out.println("No encontrado");
            return Collections.emptyList();
        }
        return glucoMeasures;
    }

    @PostMapping("/glucose/")
    public GlucoMeasure addGlucoseMeasure(@RequestBody GlucoMeasure glucoMeasure) {
        glucoMeasure.setId(0);
        User user = userService.findById(glucoMeasure.getUser_id().getId());
        glucoMeasure.setUser_id(user);
        glucoMeasureService.save(glucoMeasure);
        return glucoMeasure;

    }

    @PutMapping("/glucose/")
    public GlucoMeasure updateGlucoseMeasure(@RequestBody GlucoMeasure glucoMeasure) {

        glucoMeasureService.save(glucoMeasure);
        User user = userService.findById(glucoMeasure.getUser_id().getId());
        glucoMeasure.setUser_id(user);
        return glucoMeasure;
    }

    @DeleteMapping("/glucose/{measureId}")
    public int deleteGlucoseMeasureById(@PathVariable int measureId) {

        GlucoMeasure glucoMeasure = glucoMeasureService.findById(measureId);

        if(glucoMeasure == null) {
            return 0;
        }

        return glucoMeasureService.deleteById(measureId);
    }

    @DeleteMapping("/glucose/user/{userId}")
    public int deleteGlucoseMeasureByUserId(@PathVariable int userId) {

        List<GlucoMeasure> glucoMeasure = glucoMeasureService.findByUserId(userId);


        if(glucoMeasure == null) {
            return 0;
        }

        return glucoMeasureService.deleteByUserId(userId);
    }

    @GetMapping("/pressure/")
    public List<PressureMeasure> findAllPressureMeasures() { return pressureMeasureService.findAll(); }

    @GetMapping("/pressure/{pressureId}")
    public PressureMeasure getPressureMeasureById(@PathVariable int pressureId){
        PressureMeasure pressureMeasure = pressureMeasureService.findById(pressureId);

        if(pressureMeasure == null) {
            System.out.println("No encontrado");
            return new PressureMeasure();
        }
        System.out.println(pressureMeasure);
        return pressureMeasure;
    }

    @GetMapping("/pressure/user/{userId}")
    public List<PressureMeasure> getPressureMeasureByUserId(@PathVariable int userId){
        List<PressureMeasure> pressureMeasures = pressureMeasureService.findByUserId(userId);

        if(pressureMeasures == null) {
            System.out.println("No encontrado");
            return Collections.emptyList();
        }
        return pressureMeasures;
    }

    @PostMapping("/pressure/")
    public PressureMeasure addPressureMeasure(@RequestBody PressureMeasure pressureMeasure) {
        pressureMeasure.setId(0);
        User user = userService.findById(pressureMeasure.getUser_id().getId());
        pressureMeasure.setUser_id(user);
        pressureMeasureService.save(pressureMeasure);
        return pressureMeasure;

    }

    @PutMapping("/pressure/")
    public PressureMeasure updatePressureMeasure(@RequestBody PressureMeasure pressureMeasure) {
        pressureMeasureService.save(pressureMeasure);
        User user = userService.findById(pressureMeasure.getUser_id().getId());
        pressureMeasure.setUser_id(user);
        return pressureMeasure;
    }

    @DeleteMapping("/pressure/{measureId}")
    public int deletePressureMeasureById(@PathVariable int measureId) {

        PressureMeasure pressureMeasure = pressureMeasureService.findById(measureId);

        if(pressureMeasure == null) {
            return 0;
        }

        return pressureMeasureService.deleteById(measureId);
    }

    @DeleteMapping("/pressure/user/{userId}")
    public int deletePressureMeasureByUserId(@PathVariable int userId) {

        List<PressureMeasure> pressureMeasures = pressureMeasureService.findByUserId(userId);


        if(pressureMeasures == null) {
            return 0;
        }

        return glucoMeasureService.deleteByUserId(userId);
    }
}
