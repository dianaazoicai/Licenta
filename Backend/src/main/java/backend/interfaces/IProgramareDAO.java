package backend.interfaces;

import backend.models.ProgramareModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProgramareDAO {
    Integer addAppointment(ProgramareModel programareModel);
    List<ProgramareModel> getAllAppointments();
    List<ProgramareModel> getAppointmentsByDoctor(String nume_doctor);
}
