package com.health.vitalsigns;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VitalSignsRepository {
    //    id serial NOT NULL,
//    id_patient int4 NULL,
//    registered_date varchar NULL,
//    bp_min varchar NULL,
//    bp_max varchar NULL,
//    hr_min varchar NULL,
//    hr_max varchar NULL,
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(VitalSignsHistory vsh) {
        return jdbcTemplate.update(
                "insert into vitalsigns_history (id_patient,registered_date,bp_min,bp_max,hr_min,hr_max) values(?,?,?,?,?,?)",
                vsh.getPatientID(),vsh.getRegisteredDate(),vsh.getBpMin(), vsh.getBpMax(), vsh.getHrMin(), vsh.getHrMax());
    }

    public VitalSignsHistory findById(Long id) {

        String sql = "SELECT * FROM vitalsigns_history WHERE ID = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new VitalSignsHistoryRowMapper());

    }


    public List<VitalSignsHistory> findAll() {

        String sql = "SELECT * FROM vitalsigns_history";

        List<VitalSignsHistory> vitalsigns = jdbcTemplate.query(
                sql,
                new VitalSignsHistoryRowMapper());

        return vitalsigns;
    }

    public int deleteById(Long id) {
        return jdbcTemplate.update(
                "delete vitalsigns_history where id = ?",
                id);
    }


}
