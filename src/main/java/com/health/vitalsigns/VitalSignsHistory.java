package com.health.vitalsigns;
import java.time.LocalDateTime;

public class VitalSignsHistory {

//    id serial NOT NULL,
//    id_patient int4 NULL,
//    registered_date varchar NULL,
//    bp_min varchar NULL,
//    bp_max varchar NULL,
//    hr_min varchar NULL,
//    hr_max varchar NULL,

    private int id;
    private int patientID;
    private LocalDateTime registeredDate;
    private String bpMin;
    private String bpMax;
    private String hrMin;
    private String hrMax;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public LocalDateTime getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDateTime registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getBpMin() {
        return bpMin;
    }

    public void setBpMin(String bpMin) {
        this.bpMin = bpMin;
    }

    public String getBpMax() {
        return bpMax;
    }

    public void setBpMax(String bpMax) {
        this.bpMax = bpMax;
    }

    public String getHrMin() {
        return hrMin;
    }

    public void setHrMin(String hrMin) {
        this.hrMin = hrMin;
    }

    public String getHrMax() {
        return hrMax;
    }

    public void setHrMax(String hrMax) {
        this.hrMax = hrMax;
    }

    @Override
    public String toString() {
        return "VitalSignsHistory{" +
                "id=" + id +
                ", patientID=" + patientID +
                ", registeredDate=" + registeredDate +
                ", bpMin='" + bpMin + '\'' +
                ", bpMax='" + bpMax + '\'' +
                ", hrMin='" + hrMin + '\'' +
                ", hrMax='" + hrMax + '\'' +
                '}';
    }
}
