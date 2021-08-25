package backend.services;

import backend.interfaces.IDoctorsDAO;
import backend.mappers.DoctorMapper;
import backend.models.Doctor;
import org.springframework.jdbc.core.JdbcTemplate;
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
    public Integer addDoctor(Doctor doctor) {
        String query="insert into personalcentrumedical(personalcentrumedical.id_doctor,personalcentrumedical.nume_doctor,personalcentrumedical.specializare) values(?,?,?)";
        return jdbcTemplate.update(query, doctor.id, doctor.name, doctor.specialization);

    }

    @Override
    public List<Doctor> getAllDoctors() {
        String query="select * from personalcentrumedical";
        return jdbcTemplate.query(query,doctorMapper);
    }

    @Override
    public List<Doctor> getDoctorBySpecialization(String specialization) {
        String query = "select * from personalcentrumedical where specializare=?";
        return jdbcTemplate.query(query,doctorMapper, specialization);
    }
}
