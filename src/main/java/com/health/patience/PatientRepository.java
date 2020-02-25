package com.health.patience;

import com.health.patience.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class PatientRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int saveNew(Patient patient) {
        return jdbcTemplate.update(
                "insert into patient (first_name,last_name,age,gender) values(?,?,?,?)",
                patient.getFirstName(), patient.getLastName(), patient.getAge(),patient.getGender());
    }

    public Patient findById(Long id) {

        String sql = "SELECT * FROM patient WHERE ID = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new PatientRowMapper());

    }


    public List<Patient> findAll() {

        String sql = "SELECT * FROM patient";

        List<Patient> patients = jdbcTemplate.query(
                sql,
                new PatientRowMapper());

        return patients;
    }


    public int deleteById(Long id) {
        return jdbcTemplate.update(
                "delete patient where id = ?",
                id);
    }


}