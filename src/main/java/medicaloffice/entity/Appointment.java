package medicaloffice.entity;

import lombok.*;
import medicaloffice.domain.*;

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
    private Long id;

    //private Date date;
    private AppointmentStatus status;

//    private Patient patient;
//    private Doctor doctor;
//    private Diagnosis diagnosis;
//    private Treatment treatment;

    @Builder
    public Appointment (Patient patient, Doctor doctor, Date date, AppointmentStatus appointmentStatus, Diagnosis diagnosis, Treatment treatment){

      //  this.date = date;
     this.status = appointmentStatus;
     this.patient = patient;
     this.doctor = doctor;
      this.diagnosis = diagnosis;
     this.treatment = treatment;
    }
     @ManyToOne(cascade = CascadeType.PERSIST)
     @JoinColumn( name="doctor_id")
     private Doctor doctor;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn( name="patient_id")
    private Patient patient;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn( name="diagnosis_id")
    private Diagnosis diagnosis;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn( name="treatment_id")
    private Treatment treatment;

}
