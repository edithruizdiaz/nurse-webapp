package com.health.vitalsigns;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VitalSignsHistoryRowMapper implements RowMapper<VitalSignsHistory> {

    @Override
    public VitalSignsHistory mapRow(ResultSet rs, int rowNum) throws SQLException {

        VitalSignsHistory vitalSignsHistory= new VitalSignsHistory();
        vitalSignsHistory.setId(rs.getInt("id"));
        vitalSignsHistory.setPatientID(rs.getInt("id_patient"));
        vitalSignsHistory.setBpMax(rs.getString("bp_max"));
        vitalSignsHistory.setBpMin(rs.getString("bp_min"));
        vitalSignsHistory.setHrMax(rs.getString("hr_max"));
        vitalSignsHistory.setHrMin(rs.getString("hr_min"));
        vitalSignsHistory.setRegisteredDate(rs.getTimestamp("registered_date").toLocalDateTime());

        return vitalSignsHistory;
    }
}
