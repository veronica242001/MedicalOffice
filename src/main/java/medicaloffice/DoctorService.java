package medicaloffice;

import medicaloffice.domain.Doctor;
import medicaloffice.rest.exception.DoctorNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DoctorService {

    private static final List<Doctor> doctors = new ArrayList<>();


    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public List<Doctor> findAll() {
        return doctors;
    }

    public Doctor findById(String doctorId){
        return doctors.stream().filter(doctor -> doctor.getFirstName().equals(doctorId))
                .findFirst()
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found"));
    }

}
