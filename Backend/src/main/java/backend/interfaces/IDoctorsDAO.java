package backend.interfaces;

import backend.models.DoctorModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDoctorsDAO {
    Integer addDoctor(DoctorModel doctorModel);
    List<DoctorModel> getAllDoctors();
    List<DoctorModel> getDoctorBySpecialization(String specializare);
}
