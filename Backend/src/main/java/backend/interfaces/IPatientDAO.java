package backend.interfaces;

import backend.models.Patient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPatientDAO {
    Integer addPatient(Patient patient);
    List<Patient> getAllPatients();
    List<Patient> getPatientByCNP(String CNP);

}
