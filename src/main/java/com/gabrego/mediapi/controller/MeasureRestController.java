package com.gabrego.mediapi.controller;

import com.gabrego.mediapi.entity.GlucoMeasure;
import com.gabrego.mediapi.entity.User;
import com.gabrego.mediapi.service.GlucoMeasureService;
import com.gabrego.mediapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping("/measurement/glucose")
public class MeasureRestController {

    @Autowired
    private GlucoMeasureService glucoMeasureService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<GlucoMeasure> findAllGlucoseMeasures() { return glucoMeasureService.findAll(); }

    @GetMapping("/{glucoId}")
    public GlucoMeasure getGlucoseMeasureById(@PathVariable int glucoId){
        GlucoMeasure glucoMeasure = glucoMeasureService.findById(glucoId);

        if(glucoMeasure == null) {
            System.out.println("No encontrado");
            return new GlucoMeasure();
        }
        System.out.println(glucoMeasure);
        return glucoMeasure;
    }

    @GetMapping("/user/{userId}")
    public List<GlucoMeasure> getGlucoseMeasureByUserId(@PathVariable int userId){
        List<GlucoMeasure> glucoMeasures = glucoMeasureService.findByUserId(userId);

        if(glucoMeasures == null) {
            System.out.println("No encontrado");
            return Collections.emptyList();
        }
        return glucoMeasures;
    }

    @PostMapping("/")
    public GlucoMeasure addGlucoseMeasure(@RequestBody GlucoMeasure glucoMeasure) {
        glucoMeasure.setId(0);
        User user = userService.findById(glucoMeasure.getUser_id().getId());
        glucoMeasure.setUser_id(user);
        glucoMeasureService.save(glucoMeasure);
        return glucoMeasure;

    }

    @PutMapping("/")
    public GlucoMeasure updateMedicalRecord(@RequestBody GlucoMeasure glucoMeasure) {

        glucoMeasureService.save(glucoMeasure);
        User user = userService.findById(glucoMeasure.getUser_id().getId());
        glucoMeasure.setUser_id(user);
        return glucoMeasure;
    }

    @DeleteMapping("/{measureId}")
    public int deleteMedicalRecordById(@PathVariable int measureId) {

        GlucoMeasure glucoMeasure = glucoMeasureService.findById(measureId);

        if(glucoMeasure == null) {
            return 0;
        }

        return glucoMeasureService.deleteById(measureId);
    }

    @DeleteMapping("/user/{userId}")
    public int deleteMedicalPatientByUserId(@PathVariable int userId) {

        List<GlucoMeasure> glucoMeasure = glucoMeasureService.findByUserId(userId);


        if(glucoMeasure == null) {
            return 0;
        }

        return glucoMeasureService.deleteByUserId(userId);
    }
}
