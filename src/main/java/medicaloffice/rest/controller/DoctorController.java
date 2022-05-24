package medicaloffice.rest.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicaloffice.services.DoctorService;
import medicaloffice.entity.Doctor;
import medicaloffice.rest.dto.DoctorOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController //face automat si adnotarea de Autowired
@RequiredArgsConstructor // genereaza constructorul
@Slf4j // pentru log uri
public class DoctorController {

    private final ModelMapper modelMapper;
    @Autowired
    private DoctorService doctorService;

    @GetMapping("doctors")
    public List<DoctorOutputDTO> getDoctors() {
        List<Doctor> doctorsWithPrivateStuff = doctorService.findAll(); // folosim model mapper
        List<DoctorOutputDTO> doctorsDTO = doctorsWithPrivateStuff.stream()
                .map(doctor -> modelMapper.map(doctor, DoctorOutputDTO.class))
                .collect(Collectors.toList());

        log.debug("hey, our first log --> current doctors={}", doctorsDTO);
        return doctorsDTO;
    }

//    @PostMapping("doctors")
//    public void createDoctor(@RequestBody Doctor doctor){
//        //TODO validation
//        doctorService.addDoctor(doctor);
//    }

    @GetMapping("doctors/{doctorName}")
    public Doctor getDoctor(@PathVariable String doctorName) {
        return doctorService.findByName(doctorName);
    }
}
