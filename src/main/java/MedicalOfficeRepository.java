import domain.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class MedicalOfficeRepository { //singleton

    private List<Appointment> appointmentList = new ArrayList<>();

    private static MedicalOfficeRepository medicalOfficeRepository_instance = null;

    public static MedicalOfficeRepository getInstance() {
        if (medicalOfficeRepository_instance == null) {
            medicalOfficeRepository_instance = new MedicalOfficeRepository();
        }
        return medicalOfficeRepository_instance;
    }

    private MedicalOfficeRepository() {
        Doctor doctor = Doctor.builder()
                .firstName("Sarah")
                .lastName("Pop")
                .email("sarahp@gmail.com")
                .specialty(MedicalSpecialty.CARDIOLOGY)
                .build();

        Patient patient = Patient.builder()
                .firstName("Elena")
                .lastName("Nicola")
                .email("enico@gmail.com")
                .build();
        Patient secondPatient = Patient.builder()
                .firstName("Stefania")
                .lastName("Rios")
                .email("stefrios@gmail.com")
                .build();

        Appointment appointment = Appointment.builder()
                .doctor(doctor)
                .patient(secondPatient)
                .appointmentStatus(AppointmentStatus.CANCELED)
                .build();
        Appointment secondAppointment = Appointment.builder()
                .doctor(doctor)
                .patient(patient)
                .date(Date.from(Instant.now().plus(2, ChronoUnit.DAYS)))
                .appointmentStatus(AppointmentStatus.SCHEDULED)
                .build();

        appointmentList.add(appointment);
        appointmentList.add(secondAppointment);
    }

}
