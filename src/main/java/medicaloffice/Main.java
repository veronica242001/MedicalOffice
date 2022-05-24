package medicaloffice;


import medicaloffice.domain.Doctor;
import medicaloffice.domain.MedicalSpecialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
;

@SpringBootApplication
public class Main implements  CommandLineRunner {


    @Autowired //injectia campurilor se face dupa ce obiectul s-a creat
    private  DoctorService doctorService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);


    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Welcome to Medical Office Service");


//
//        System.out.println("Display all appointments");
//        List<Appointment> appointmentList = medicalOfficeService.listAllAppointments();
//        System.out.println(appointmentList);
//
//        System.out.println("Display all canceled appointments");
//        List<Appointment> appointmentList2 = medicalOfficeService.listSpecificAppointments(AppointmentStatus.CANCELED);
//        System.out.println(appointmentList2);

        Doctor doctor = Doctor.builder()
                .firstName("Maria")
                .lastName("Ene")
                .email("enem@gmail.com")
                .specialty(MedicalSpecialty.NEUROLOGY)
                .build();
        doctorService.addDoctor(doctor);

        System.out.println("Find Doctor by Name:");
        System.out.println(doctorService.findByName("Ene"));

        System.out.println("Display all doctors");
        System.out.println(doctorService.findAll());
    }
}
@RestController
class FirstController{
    @GetMapping("/") // ii spunem ca pe path ul de route va face ceva
    public String getSomething(){
        return "Hello world";
    }

}
