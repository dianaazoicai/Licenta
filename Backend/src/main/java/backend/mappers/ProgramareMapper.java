package backend.mappers;

import backend.models.Appointment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProgramareMapper implements RowMapper<Appointment> {
    @Override
    public Appointment mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Appointment(resultSet.getInt("id_programari"),resultSet.getInt("id_doctor"), resultSet.getInt("id_pacient"),resultSet.getDate("data_programare"));
    }
}
