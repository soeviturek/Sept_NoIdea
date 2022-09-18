package com.noidea.rest.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Availability {
    private String id;

    private String doctorId;

    private //"dd.MM.yyyy HH:mm:ss"
    LocalDateTime dateTime;

    private String completeFlag;
    private String deleteFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getCompleteFlag() {
        return completeFlag;
    }

    public void setCompleteFlag(String completeFlag) {
        this.completeFlag = completeFlag;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return "Availability{" +
                "id='" + id + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", dateTime=" + dateTime +
                ", completeFlag='" + completeFlag + '\'' +
                ", deleteFlag='" + deleteFlag + '\'' +
                '}';
    }
}
