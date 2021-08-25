package backend.controllers;
import backend.interfaces.IDoctorsDAO;
import backend.models.Doctor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api/doctors", produces = MediaType.APPLICATION_JSON_VALUE)
public class DoctorController {

    @Qualifier("doctorsDAO")
    @Autowired
    private IDoctorsDAO doctorDAO;

    @GetMapping()
    @ResponseBody
    public ResponseEntity<List<Doctor>> getDoctors(){
        List<Doctor> doctorList = doctorDAO.getAllDoctors();
        return ResponseEntity.status(200).body(doctorList);
    }
    @GetMapping(value="/{specialization}")
    @ResponseBody
    public ResponseEntity<List<Doctor>>getDoctorBySpecialization(@PathVariable String specialization){
        List<Doctor> doctorList = doctorDAO.getDoctorBySpecialization(specialization);
        return ResponseEntity.status(200).body(doctorList);

    }
    @PostMapping(value="/add")
    public ResponseEntity<?>addDoctor(@RequestBody Doctor doctor){
        var result = doctorDAO.addDoctor(doctor);
        return ResponseEntity.status(200).body(result);
    }

}
