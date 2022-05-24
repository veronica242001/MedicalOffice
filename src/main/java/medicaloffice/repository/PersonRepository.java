package medicaloffice.repository;

import medicaloffice.entity.Doctor;
import medicaloffice.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAll();

    @Query(value = "SELECT p FROM Person p WHERE person_type=1")
    List<Doctor> findAllDoctors();


    Doctor findFirstByLastName(String lastName);

    @Modifying // adnotare care specifica ca nu vrem sa furnizeze un rezultat
    @Query(value = "INSERT INTO Person (person_type, id, first_name, last_name, email) VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void insertPerson(int person_type, Long id, String firstName, String lastName, String email);


}
