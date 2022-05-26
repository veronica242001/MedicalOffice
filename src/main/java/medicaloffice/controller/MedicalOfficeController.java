package medicaloffice.controller;

import medicaloffice.services.MedicalOfficeService;
import medicaloffice.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicalOfficeController {


    private final MedicalOfficeService medicalOfficeService;

    public MedicalOfficeController(MedicalOfficeService medicalOfficeService) {
        this.medicalOfficeService = medicalOfficeService;
    }

    @GetMapping("appointments")
    public List<Appointment> displayAllAppointments() {

        return medicalOfficeService.findAll();
    }

    @PostMapping("appointments")
    public ResponseEntity<?> createAppointment(@RequestBody Appointment appointment) {
        // TODO validation
        Appointment added = medicalOfficeService.addAppointment(appointment);
        return added != null ? ResponseEntity.ok(added) : ResponseEntity.badRequest().body("Customer already exists!");
    }

}
