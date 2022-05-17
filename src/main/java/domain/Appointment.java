package domain;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
public class Appointment {

    private Patient patient;
    private Doctor doctor;
    private Date date;
    private AppointmentStatus status;
    private Diagnosis diagnosis;
    private Treatment treatment;

    @Builder
    public Appointment ( Patient patient, Doctor doctor, Date date, AppointmentStatus appointmentStatus, Diagnosis diagnosis, Treatment treatment){
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.status = appointmentStatus;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

}
