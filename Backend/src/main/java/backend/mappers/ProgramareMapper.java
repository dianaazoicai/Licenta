package backend.mappers;

import backend.models.PacientModel;
import backend.models.ProgramareModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProgramareMapper implements RowMapper<ProgramareModel> {
    @Override
    public ProgramareModel mapRow(ResultSet resultSet, int i) throws SQLException {
        return new ProgramareModel(resultSet.getInt("id_programari"),resultSet.getInt("id_doctor"), resultSet.getInt("id_pacient"),resultSet.getDate("data_programare"));
    }
}
