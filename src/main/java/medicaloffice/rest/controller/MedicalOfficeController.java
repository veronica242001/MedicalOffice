package medicaloffice.rest.controller;

import medicaloffice.Main;
import medicaloffice.domain.Appointment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicalOfficeController {
    @GetMapping("/allappointments")
    public List<Appointment> displayAllAppointments(){
        return Main.medicalOfficeService.listAllAppointments();
    }
}
