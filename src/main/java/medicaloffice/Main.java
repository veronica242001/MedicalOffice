package medicaloffice;


import medicaloffice.entity.Doctor;
import medicaloffice.domain.MedicalSpecialty;
import medicaloffice.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
;

@SpringBootApplication
public class Main implements  CommandLineRunner {


    @Autowired //injectia campurilor se face dupa ce obiectul s-a creat
    private DoctorService doctorService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);


    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Welcome to Medical Office Service");

    }
}

//@RestController
//class FirstController{
//    @GetMapping("/") // ii spunem ca pe path ul de route va face ceva
//    public String getSomething(){
//        return "Hello world";
//    }
//
//}
