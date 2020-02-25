package com.health;

import com.health.patience.Patient;
import com.health.patience.PatientRepository;

import com.health.vitalsigns.VitalSignsHistory;
import com.health.vitalsigns.VitalSignsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class VitalSignsController {

    @Autowired
    private VitalSignsRepository repository;

    // Find
    @GetMapping("/vitalsigns")
    List<VitalSignsHistory> findAll() {
        return repository.findAll();
    }

    // Save
    @PostMapping("/vitalsigns")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    VitalSignsHistory newPatient(@RequestBody VitalSignsHistory newVS) {
        int id=repository.save(newVS);
        newVS.setId(id);
        return newVS;
    }

    @DeleteMapping("/vitalsigns/{id}")
    void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }

}