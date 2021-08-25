package backend.mappers;

import backend.models.Patient;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PacientMapper implements RowMapper<Patient> {


    @Override
    public Patient mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Patient(resultSet.getInt("id_pacient"),resultSet.getString("nume_pacient"), resultSet.getString("CNP"),resultSet.getString("telefon"), resultSet.getString("adresa"), resultSet.getString("email") );
    }
}
