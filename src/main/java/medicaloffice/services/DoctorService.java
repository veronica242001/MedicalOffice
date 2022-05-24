package medicaloffice.services;

import medicaloffice.entity.Doctor;
import medicaloffice.repository.PersonRepository;
import medicaloffice.rest.exception.DoctorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DoctorService {

    @Autowired
    private PersonRepository repository;


    public void addDoctor(Doctor doctor) {
        repository.save(doctor);
    }

    public List<Doctor> findAll() {
        return repository.findAllDoctors();
    }

    public Doctor findByName(String doctorName){
        Doctor doctor = repository.findFirstByLastName(doctorName);
        if(doctor == null ){
            throw new DoctorNotFoundException("Doctor not found");
        }
        return doctor;
    }

}
