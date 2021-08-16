package backend.models;

public class DoctorModel {
    public String nume_doctor;
    public Integer id_doctor;
    public String specializare;

    public DoctorModel(Integer id_doctor, String nume_doctor, String specializare){
        this.id_doctor=id_doctor;
        this.nume_doctor=nume_doctor;
        this.specializare=specializare;
    }
}
