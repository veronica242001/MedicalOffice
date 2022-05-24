package medicaloffice.repository;


import medicaloffice.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MedicalOfficeRepository extends JpaRepository<Appointment, Long> {


    List<Appointment> findAll();

//    private MedicalOfficeRepository() {
//        Appointment appointment = Appointment.builder()
//                .doctor(doctor)
//                .patient(secondPatient)
//                .appointmentStatus(AppointmentStatus.CANCELED)
//                .build();
//        Appointment secondAppointment = Appointment.builder()
//                .doctor(doctor)
//                .patient(patient)
//                .date(Date.from(Instant.now().plus(2, ChronoUnit.DAYS)))
//                .appointmentStatus(AppointmentStatus.SCHEDULED)
//                .build();

//    }

}
