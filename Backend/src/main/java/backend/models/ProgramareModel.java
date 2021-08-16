package backend.models;

import java.util.Date;

public class ProgramareModel {
    public Integer id_programari;
    public Integer id_doctor;
    public Integer id_pacient;
    public Date data_programare;
    public ProgramareModel(Integer id_programari,Integer id_doctor,Integer id_pacient,Date data_programare)
    {
        this.id_programari=id_programari;
        this.id_doctor=id_doctor;
        this.id_pacient=id_pacient;
        this.data_programare=data_programare;
    }
}
