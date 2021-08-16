package backend.controllers;

import backend.interfaces.IProgramareDAO;
import backend.models.ProgramareModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProgramariController {
    @Autowired
    private final IProgramareDAO programareDAO;

    public ProgramariController(IProgramareDAO programareDAO) {
        this.programareDAO = programareDAO;
    }

    @GetMapping("/api/programari")
    @ResponseBody
    public ResponseEntity<?> getAppointments(){
        var result =programareDAO.getAllAppointments();
        return ResponseEntity.status(200).body(result);
    }
    @GetMapping(value="/api/programari/{nume_doctor}")
    @ResponseBody
    public ResponseEntity<?>getAppointmentsByDoctor(@PathVariable String nume_doctor){
        var result =programareDAO.getAppointmentsByDoctor(nume_doctor);
        return ResponseEntity.status(200).body(result);

    }
    @PostMapping(value="/api/programari/add")

    public ResponseEntity<?>addAppointment(@RequestBody ProgramareModel model){
        var result = programareDAO.addAppointment(model);
        return ResponseEntity.status(200).body(result);
    }
}
