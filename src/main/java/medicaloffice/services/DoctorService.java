package medicaloffice.services;

import medicaloffice.entity.Doctor;
import medicaloffice.repository.PersonRepository;
import medicaloffice.exception.DoctorNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


@Service
public class DoctorService {

    //@Autowired
    private final PersonRepository repository;

    public DoctorService( PersonRepository repository) {
        this.repository = repository;
    }

   @Transactional(rollbackFor = SQLException.class)
    public void addDoctor(Doctor doctor) {

        repository.save(doctor);
        repository.insertPerson(2, 10L,"ana","popescu","ana@gmail.com");
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
