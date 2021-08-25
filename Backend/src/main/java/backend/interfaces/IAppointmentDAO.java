package backend.interfaces;

import backend.models.Appointment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAppointmentDAO {
    Integer addAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();
    List<Appointment> getAppointmentsByDoctor(String doctorName);
}
