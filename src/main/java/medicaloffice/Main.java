package medicaloffice;

import medicaloffice.domain.Appointment;
import medicaloffice.domain.AppointmentStatus;
import medicaloffice.domain.Doctor;
import medicaloffice.domain.MedicalSpecialty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class Main {

    public static final MedicalOfficeService medicalOfficeService = new MedicalOfficeService();
    private static final DoctorService DOCTOR_SERVICE =  new DoctorService();

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

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
        DOCTOR_SERVICE.addDoctor(doctor);

        System.out.println("Display all doctors");
        System.out.println(DOCTOR_SERVICE.findAll());

    }
}
@RestController
class FirstController{
    @GetMapping("/") // ii spunem ca pe path ul de route va face ceva
    public String getSomething(){
        return "Hello world";
    }

}
