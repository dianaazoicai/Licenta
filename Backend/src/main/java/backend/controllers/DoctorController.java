package backend.controllers;
import backend.interfaces.IDoctorsDAO;
import backend.models.DoctorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class DoctorController {
    @Autowired
    private final IDoctorsDAO doctorDAO;

    public DoctorController(IDoctorsDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }

    @GetMapping("/api/doctors")
    @ResponseBody
    public ResponseEntity<?>getDoctors(){
        var result =doctorDAO.getAllDoctors();
        return ResponseEntity.status(200).body(result);
    }
    @GetMapping(value="/api/doctors/{specializare}")
    @ResponseBody
    public ResponseEntity<?>getDoctorBySpecialization(@PathVariable String specializare){
        var result =doctorDAO.getDoctorBySpecialization(specializare);
        return ResponseEntity.status(200).body(result);

    }
    @PostMapping(value="/api/doctors/add")

    public ResponseEntity<?>addDoctor(@RequestBody DoctorModel model){
        var result = doctorDAO.addDoctor(model);
        return ResponseEntity.status(200).body(result);
    }

}
