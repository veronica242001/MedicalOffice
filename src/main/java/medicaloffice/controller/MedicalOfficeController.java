package medicaloffice.controller;

import medicaloffice.services.MedicalOfficeService;
import medicaloffice.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicalOfficeController {

    @Autowired
    private MedicalOfficeService medicalOfficeService;

    @GetMapping("/allappointments")
    public List<Appointment> displayAllAppointments() {
        return medicalOfficeService.findAll();
    }
}
