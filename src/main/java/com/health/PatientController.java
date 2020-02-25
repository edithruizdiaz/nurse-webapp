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
    ResponseMsg newPatient(@RequestBody Patient newPatient) {
        int id=repository.saveNew(newPatient);
        ResponseMsg rsp=new ResponseMsg();
        if(id==1){
            rsp.setStatus("200");
            rsp.setCode("101");
            rsp.setMessage("Patient added successfully");
        }
        return rsp;
    }

    @DeleteMapping("/patient/{id}")
    void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
