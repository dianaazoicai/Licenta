package backend.controllers;

import backend.interfaces.IAppointmentDAO;
import backend.models.Appointment;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/programari", produces = MediaType.APPLICATION_JSON_VALUE)
public class AppointmentsController {

    @Qualifier("appointmentDAO")
    @Autowired
    private IAppointmentDAO programareDAO;

    @GetMapping()
    @ResponseBody
    public ResponseEntity<List<Appointment>> getAppointments(){
        List<Appointment> appointmentsList = programareDAO.getAllAppointments();
        return ResponseEntity.status(200).body(appointmentsList);
    }

    @GetMapping(value="/{nume_doctor}")
    @ResponseBody
    public ResponseEntity<List<Appointment>> getAppointmentsByDoctor(@PathVariable String nume_doctor){
        List<Appointment> appointments = programareDAO.getAppointmentsByDoctor(nume_doctor);
        return ResponseEntity.status(200).body(appointments);

    }
    @PostMapping()
    public ResponseEntity<?> addAppointment(@RequestBody Appointment model){
        var result = programareDAO.addAppointment(model);
        return ResponseEntity.status(200).body(result);
    }
}
