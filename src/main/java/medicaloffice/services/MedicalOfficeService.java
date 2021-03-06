package medicaloffice.services;


import medicaloffice.entity.Appointment;
import medicaloffice.repository.MedicalOfficeRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MedicalOfficeService {


    private final MedicalOfficeRepository repository;

    public MedicalOfficeService(MedicalOfficeRepository repository) {

        this.repository = repository;
    }

    public List<Appointment> findAll() {  // TODO: add DTO

        return repository.findAll();
    }

    public Appointment addAppointment(Appointment appointment) {
//        if (repository.findById(.getId()) != null) {
//            return null;
//        }
        Appointment saved = repository.save(appointment);
        return saved;

    }




//    public List<Appointment> listSpecificAppointments(AppointmentStatus status) {
//        return repository.getAppointmentList().stream().filter( a -> a.getStatus().equals(status)).collect(Collectors.toList());
//    }
}
