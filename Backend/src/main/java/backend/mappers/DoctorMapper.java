package backend.mappers;

import backend.models.Doctor;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorMapper implements RowMapper<Doctor> {


    @Override
    public Doctor mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Doctor(resultSet.getInt("id_doctor"),resultSet.getString("nume_doctor"), resultSet.getString("specializare"));
    }
}

