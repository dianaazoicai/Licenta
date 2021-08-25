package backend.services;

import backend.interfaces.IPacientDAO;
import backend.mappers.PacientMapper;
import backend.models.PacientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacientDAO implements IPacientDAO {
    @Autowired
    private final JdbcTemplate jdbcTemplate;
    private final PacientMapper pacientMapper;

    public PacientDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.pacientMapper = new PacientMapper();
    }
    @Override
    public Integer addPacient(PacientModel pacientModel) {
        String query="insert into pacienti(pacienti.id_pacient,pacienti.nume_pacient,pacienti.CNP,pacienti.telefon,pacienti.adresa,pacienti.email) values(?,?,?,?,?,?)";
        return jdbcTemplate.update(query,pacientModel.id_pacient,pacientModel.nume_pacient,pacientModel.CNP,pacientModel.telefon,pacientModel.adresa,pacientModel.email);
    }

    @Override
    public List<PacientModel> getAllPacients() {
        String query="select * from pacienti";
        return jdbcTemplate.query(query,pacientMapper);
    }

    @Override
    public List<PacientModel> getPacientByCNP(String CNP) {
        String query="select * from pacienti where CNP=?";
        var result= jdbcTemplate.query(query,pacientMapper,CNP);
        return result;
    }
}
