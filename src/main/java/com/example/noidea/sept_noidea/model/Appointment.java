package com.example.noidea.sept_noidea.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "appointment")
@EntityListeners(AuditingEntityListener.class)
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAppointment", nullable = false)
    private int idAppointment;

    @Column(nullable = false)
    private int UID; //patient id

    @Column(name = "DoctorID", nullable = false)
    private int doctorId;

    @Column(name = "DT", nullable = false)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss")
//    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dateTime;


    @Column(name = "DF", nullable = false)
    private int deleteFlag;

    @Column(name = "Appointmentcol")
    private String AppointmentCol;

    public Appointment() {
    }

    public int getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public int getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getAppointmentCol() {
        return AppointmentCol;
    }

    public void setAppointmentCol(String appointmentCol) {
        AppointmentCol = appointmentCol;
    }

    public Appointment(int idAppointment, int UID, int doctorId, Date dateTime, int deleteFlag, String appointmentCol) {
        this.idAppointment = idAppointment;
        this.UID = UID;
        this.doctorId = doctorId;
        this.dateTime = dateTime;
        this.deleteFlag = deleteFlag;
        AppointmentCol = appointmentCol;
    }
}
