import domain.Appointment;
import domain.AppointmentStatus;
import domain.Doctor;
import domain.MedicalSpecialty;

import java.util.List;

public class Main {

    private static MedicalOfficeService medicalOfficeService = new MedicalOfficeService();
    private static DoctorRepository doctorRepository =  new DoctorRepository();

    public static void main(String[] args) {

        System.out.println("Welcome to Medical Office Service");

        System.out.println("Display all appointments");
        List<Appointment> appointmentList = medicalOfficeService.listAllAppointments();
        System.out.println(appointmentList);

        System.out.println("Display all canceled appointments");
        List<Appointment> appointmentList2 = medicalOfficeService.listSpecificAppointments(AppointmentStatus.CANCELED);
        System.out.println(appointmentList2);

        Doctor doctor = Doctor.builder()
                .firstName("Sarah")
                .lastName("Pop")
                .email("sarahp@gmail.com")
                .specialty(MedicalSpecialty.CARDIOLOGY)
                .build();
        doctorRepository.addDoctor(doctor);

        System.out.println("Display all doctors");
        System.out.println(doctorRepository.displayDoctors());

    }
}
