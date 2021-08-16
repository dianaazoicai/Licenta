package backend.mappers;

import backend.models.DoctorModel;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorMapper implements RowMapper<DoctorModel> {


    @Override
    public DoctorModel mapRow(ResultSet resultSet, int i) throws SQLException {
        return new DoctorModel(resultSet.getInt("id_doctor"),resultSet.getString("nume_doctor"), resultSet.getString("specializare"));
    }
}

