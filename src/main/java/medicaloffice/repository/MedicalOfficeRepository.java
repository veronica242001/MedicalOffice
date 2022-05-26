package medicaloffice.repository;


import medicaloffice.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MedicalOfficeRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAll();


}
