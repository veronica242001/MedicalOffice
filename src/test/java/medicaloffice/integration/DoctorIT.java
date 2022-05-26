package medicaloffice.integration;

import medicaloffice.controller.DoctorController;
import medicaloffice.dto.DoctorOutputDTO;
import medicaloffice.entity.Doctor;
import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
public class DoctorIT {

    @Autowired
    private DoctorController doctorController;

    @Test
    public void test_doctorsComponent(){

        //list all doctors and check that there is no doctor added
        ResponseEntity<?> getDoctorsResponse = doctorController.getDoctors();
        assertNotNull(" ", getDoctorsResponse);
        assertEquals("", SC_OK, getDoctorsResponse.getStatusCode().value());
        assertTrue("", getDoctorsResponse.getBody() instanceof List);

        List<DoctorOutputDTO> result = (List<DoctorOutputDTO>) getDoctorsResponse.getBody();
        //assertTrue("", result.isEmpty());

        //add new doctor
        Doctor doctor = Doctor.builder().firstName("Ana").lastName("Ene").build();
        ResponseEntity<?> addDoctorResponse = doctorController.createDoctor(doctor);
        assertNotNull(" ", addDoctorResponse);
        assertEquals("", SC_OK, addDoctorResponse.getStatusCode().value());
        assertTrue("", addDoctorResponse.getBody() instanceof Doctor);

        Doctor added = (Doctor) addDoctorResponse.getBody();
        assertEquals("", "Ana", added.getFirstName());
        assertEquals("", "Ene", added.getLastName());


        //get the doctor
        Long doctorId = added.getId();
        ResponseEntity<?> getDoctorResponse = doctorController.getDoctor(doctorId);
        assertEquals("", SC_OK, getDoctorResponse.getStatusCode().value());
        assertTrue("", getDoctorResponse.getBody() instanceof DoctorOutputDTO);

        DoctorOutputDTO getDoctor = (DoctorOutputDTO) getDoctorResponse.getBody();
        assertEquals("", "Ana", getDoctor.getFirstName());


        //add the same doctor and check that 400 is returned
        addDoctorResponse = doctorController.createDoctor(doctor);
        assertEquals("", "Doctor already exists", addDoctorResponse.getBody());

    }
}
