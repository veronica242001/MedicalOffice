package medicaloffice.repository;

import medicaloffice.entity.Doctor;
import medicaloffice.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAll();

    @Query(value = "SELECT p FROM Person p WHERE person_type=1")
    List<Doctor> findAllDoctors();

    //@Query(value = "SELECT p FROM Person p WHERE person_type=1 AND lastName= lastName")
    Doctor findFirstByLastName(String lastName);
}
