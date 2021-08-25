package backend.controllers;

import backend.interfaces.IPatientDAO;
import backend.models.Patient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/pacients", produces = MediaType.APPLICATION_JSON_VALUE)
public class PacientController {

    @Qualifier("patientDAO")
    @Autowired
    private IPatientDAO pacientDAO;

    @GetMapping()
    public ResponseEntity<List<Patient>> getPacients(){
        List<Patient> patientList = pacientDAO.getAllPatients();
        return ResponseEntity.status(200).body(patientList);
    }

    @PostMapping
    public ResponseEntity<?>addPacient(@RequestBody Patient model){
        var result = pacientDAO.addPatient(model);
        return ResponseEntity.status(200).body(result);
    }
    @GetMapping(value="/{CNP}")
    public ResponseEntity<List<Patient>>getPacientByCNP(@PathVariable String CNP){
        List<Patient> patientList = pacientDAO.getPatientByCNP(CNP);
        return ResponseEntity.status(200).body(patientList);

    }
}
