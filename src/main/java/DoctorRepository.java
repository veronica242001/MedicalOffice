import domain.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorRepository {

    private static final List<Doctor> doctors = new ArrayList<>();


    public void addDoctor( Doctor doctor){
        doctors.add(doctor);
    }
    public List<Doctor> displayDoctors(){
        return doctors;
    }

}
