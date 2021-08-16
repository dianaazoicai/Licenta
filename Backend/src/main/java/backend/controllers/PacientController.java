package backend.controllers;

import backend.interfaces.IPacientDAO;
import backend.models.PacientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PacientController {
    @Autowired
    private final IPacientDAO pacientDAO;

    public PacientController(IPacientDAO pacientDAO) {
        this.pacientDAO = pacientDAO;
    }

    @RequestMapping(value="/api/pacients", method = RequestMethod.GET)
    public ResponseEntity<?> getPacients(){
        var result = pacientDAO.getAllPacients();
        return ResponseEntity.status(200).body(result);
    }

    @RequestMapping(value="/api/pacients/add",method = RequestMethod.POST)
    public ResponseEntity<?>addPacient(@RequestBody PacientModel model){
        var result = pacientDAO.addPacient(model);
        return ResponseEntity.status(200).body(result);
    }
}
