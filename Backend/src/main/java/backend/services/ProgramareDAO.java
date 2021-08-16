package backend.services;

import backend.interfaces.IProgramareDAO;
import backend.mappers.PacientMapper;
import backend.mappers.ProgramareMapper;
import backend.models.ProgramareModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramareDAO implements IProgramareDAO {

    @Autowired
    private final JdbcTemplate jdbcTemplate;
    private final ProgramareMapper programareMapper;

    public ProgramareDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.programareMapper = new ProgramareMapper();
    }
    @Override
    public Integer addAppointment(ProgramareModel programareModel) {
        String query="insert into programari(programari.id_programari,programari.id_doctor,programari.id_pacient,programari.data_programare) values(?,?,?,?)";
        return jdbcTemplate.update(query,programareModel.id_programari,programareModel.id_doctor,programareModel.id_pacient,programareModel.data_programare);

    }

    @Override
    public List<ProgramareModel> getAllAppointments() {
        String query="select * from programari";
        return jdbcTemplate.query(query,programareMapper);
    }

    @Override
    public List<ProgramareModel> getAppointmentsByDoctor(String nume_doctor) {
        String query = "select * from programari where nume_doctor=?";
        return jdbcTemplate.query(query,programareMapper,nume_doctor);
    }
}
