package medicaloffice;

import medicaloffice.domain.Appointment;
import medicaloffice.domain.AppointmentStatus;

import java.util.List;
import java.util.stream.Collectors;

public class MedicalOfficeService {
    private static final MedicalOfficeRepository repository =  MedicalOfficeRepository.getInstance();

    public List<Appointment> listAllAppointments() {

        return repository.getAppointmentList();
    }
    public List<Appointment> listSpecificAppointments(AppointmentStatus status) {

        return repository.getAppointmentList().stream().filter( a -> a.getStatus().equals(status)).collect(Collectors.toList());
    }
}
