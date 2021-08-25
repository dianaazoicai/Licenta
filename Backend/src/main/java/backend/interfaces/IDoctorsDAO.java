package backend.interfaces;

import backend.models.Doctor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDoctorsDAO {
    Integer addDoctor(Doctor doctor);
    List<Doctor> getAllDoctors();
    List<Doctor> getDoctorBySpecialization(String specialization);
}
