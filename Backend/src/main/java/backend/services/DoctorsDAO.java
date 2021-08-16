package backend.services;

import backend.interfaces.IDoctorsDAO;
import backend.mappers.DoctorMapper;
import backend.models.DoctorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DoctorsDAO implements IDoctorsDAO {

    private final JdbcTemplate jdbcTemplate;
    private final DoctorMapper doctorMapper;

    public DoctorsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.doctorMapper = new DoctorMapper();
    }

    @Override
    public Integer addDoctor(DoctorModel doctorModel) {
        String query="insert into personalcentrumedical(personalcentrumedical.id_doctor,personalcentrumedical.nume_doctor,personalcentrumedical.specializare) values(?,?,?)";
        return jdbcTemplate.update(query,doctorModel.id_doctor,doctorModel.nume_doctor,doctorModel.specializare);

    }

    @Override
    public List<DoctorModel> getAllDoctors() {
        String query="select * from personalcentrumedical";
        return jdbcTemplate.query(query,doctorMapper);
    }

    @Override
    public List<DoctorModel> getDoctorBySpecialization(String specializare) {
        String query = "select * from personalcentrumedical where specializare=?";
        return jdbcTemplate.query(query,doctorMapper,specializare);
    }
}
