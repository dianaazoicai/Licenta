package backend.services;

import backend.interfaces.IAppointmentDAO;
import backend.mappers.ProgramareMapper;
import backend.models.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentDAO implements IAppointmentDAO {

    @Autowired
    private final JdbcTemplate jdbcTemplate;
    private final ProgramareMapper programareMapper;

    public AppointmentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.programareMapper = new ProgramareMapper();
    }
    @Override
    public Integer addAppointment(Appointment appointment) {
        String query="insert into programari(programari.id_programari,programari.id_doctor,programari.id_pacient,programari.data_programare) values(?,?,?,?)";
        return jdbcTemplate.update(query, appointment.id, appointment.doctorId,
            appointment.patientId, appointment.appointmentDate);

    }

    @Override
    public List<Appointment> getAllAppointments() {
        String query="select * from programari";
        return jdbcTemplate.query(query,programareMapper);
    }

    @Override
    public List<Appointment> getAppointmentsByDoctor(String doctorName) {
        String query = "select * from programari where nume_doctor=?";
        return jdbcTemplate.query(query,programareMapper, doctorName);
    }
}
