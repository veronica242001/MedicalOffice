package medicaloffice.services;

import medicaloffice.entity.Doctor;
import medicaloffice.entity.Person;
import medicaloffice.repository.PersonRepository;
import medicaloffice.exception.DoctorNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Service
public class DoctorService {

    //@Autowired
    private final PersonRepository repository;

    public DoctorService(PersonRepository repository) {

        this.repository = repository;
    }

    @Transactional(rollbackFor = SQLException.class)
    public Doctor addDoctor(Doctor doctor) {

        if( repository.findFirstByLastName(doctor.getLastName()) != null){
            return null;
        }
        Doctor saved = repository.save(doctor);
        return saved;
       // repository.insertPerson(2, 10L, "ana", "popescu", "ana@gmail.com");
    }

    public List<Doctor> findAll() {

        return repository.findAllDoctors();
    }

    public Doctor findByName(String doctorName) {
        Doctor doctor = repository.findFirstByLastName(doctorName);
        if (doctor == null) {
            throw new DoctorNotFoundException("Doctor not found");
        }
        return doctor;
    }

    public Doctor findById(Long doctorId){
        Optional<Person> doctorOptional = repository.findById(doctorId);
        if( ! doctorOptional.isPresent()){
            throw new DoctorNotFoundException("Doctor not found");
        }
        return (Doctor) doctorOptional.get();
    }

}
