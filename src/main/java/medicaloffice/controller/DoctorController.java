package medicaloffice.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicaloffice.services.DoctorService;
import medicaloffice.entity.Doctor;
import medicaloffice.dto.DoctorOutputDTO;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController //face automat si adnotarea de Autowired
@Slf4j // pentru log uri
public class DoctorController {

    private final ModelMapper modelMapper;
    private final DoctorService doctorService;

    //se pune constructor pentru a se putea face UnitTeste
    public DoctorController(ModelMapper modelMapper, DoctorService doctorService) {
        this.modelMapper = modelMapper;
        this.doctorService = doctorService;
    }

    @GetMapping("doctors")
    public ResponseEntity<?> getDoctors() {
        List<Doctor> doctorsWithPrivateStuff = doctorService.findAll(); // folosim model mapper
        List<DoctorOutputDTO> doctorsDTO = doctorsWithPrivateStuff.stream()
                .map(doctor -> modelMapper.map(doctor, DoctorOutputDTO.class))
                .collect(Collectors.toList());

        log.debug("hey, our first log --> current doctors={}", doctorsDTO);
        return ResponseEntity.ok(doctorsDTO);
    }

    @PostMapping("doctors")
    public ResponseEntity<?> createDoctor(@RequestBody Doctor doctor){
        //TODO validation
       Doctor added =  doctorService.addDoctor(doctor);

       return added != null ? ResponseEntity.ok(added) : ResponseEntity.badRequest().body("Doctor already exists");
    }

    @GetMapping("doctors/{doctorName}")
    public ResponseEntity<?> getDoctor(@PathVariable Long doctorId) {

        return ResponseEntity.ok( modelMapper.map(doctorService.findById(doctorId), DoctorOutputDTO.class));
    }
}
