package backend.interfaces;

import backend.models.PacientModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPacientDAO {
    Integer addPacient(PacientModel pacientModel);
    List<PacientModel> getAllPacients();
    List<PacientModel> getPacientByCNP(String CNP);

}
