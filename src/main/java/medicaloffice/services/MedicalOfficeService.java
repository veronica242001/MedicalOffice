package medicaloffice.services;


import medicaloffice.entity.Appointment;
import medicaloffice.repository.MedicalOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MedicalOfficeService {

    @Autowired
    private MedicalOfficeRepository repository;

    public List<Appointment> findAll() {  // TODO: add DTO
        return repository.findAll();
    }


//    public List<Appointment> listSpecificAppointments(AppointmentStatus status) {
//        return repository.getAppointmentList().stream().filter( a -> a.getStatus().equals(status)).collect(Collectors.toList());
//    }
}
