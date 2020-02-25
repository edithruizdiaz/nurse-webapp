package com.health;

import com.health.patience.Patient;
import com.health.patience.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PatientController {

    @Autowired
    private PatientRepository repository;

    // Find
    @GetMapping("/patient")
    List<Patient> findAll() {
        return repository.findAll();
    }

    // Save
    @PostMapping("/patient")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    Patient newPatient(@RequestBody Patient newPatient) {
        int id=repository.saveNew(newPatient);
        newPatient.setId(id);
        return newPatient;
    }

    @DeleteMapping("/patient/{id}")
    void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
