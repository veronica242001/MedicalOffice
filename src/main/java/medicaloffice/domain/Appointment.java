package medicaloffice.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "appointment_key_sequence_generator")
    @SequenceGenerator(name = "appointment_key_sequence_generator", sequenceName = "appointment_sequence", allocationSize = 1)


    private Date date;
    private AppointmentStatus status;

//    private Patient patient;
//    private Doctor doctor;
//    private Diagnosis diagnosis;
//    private Treatment treatment;

    @Builder
    public Appointment ( Patient patient, Doctor doctor, Date date, AppointmentStatus appointmentStatus, Diagnosis diagnosis, Treatment treatment){

        this.date = date;
        this.status = appointmentStatus;
//        this.patient = patient;
//        this.doctor = doctor;
//        this.diagnosis = diagnosis;
//        this.treatment = treatment;
    }

}
