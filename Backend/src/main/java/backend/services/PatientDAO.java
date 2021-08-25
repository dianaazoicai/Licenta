package backend.services;

import backend.interfaces.IPatientDAO;
import backend.mappers.PacientMapper;
import backend.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientDAO implements IPatientDAO {
    @Autowired
    private final JdbcTemplate jdbcTemplate;
    private final PacientMapper pacientMapper;

    public PatientDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.pacientMapper = new PacientMapper();
    }
    @Override
    public Integer addPatient(Patient patient) {
        String query="insert into pacienti(pacienti.id_pacient,pacienti.nume_pacient,pacienti.CNP,pacienti.telefon,pacienti.adresa,pacienti.email) values(?,?,?,?,?,?)";
        return jdbcTemplate.update(query, patient.id, patient.name, patient.CNP,
            patient.phoneNumber, patient.address, patient.email);
    }

    @Override
    public List<Patient> getAllPatients() {
        String query="select * from pacienti";
        return jdbcTemplate.query(query,pacientMapper);
    }

    @Override
    public List<Patient> getPatientByCNP(String CNP) {
        String query="select * from pacienti where CNP=?";
        List<Patient> patientList = jdbcTemplate.query(query,pacientMapper,CNP);
        return patientList;
    }
}
