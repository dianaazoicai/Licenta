package backend.models;

public class Doctor {
    public Integer id;
    public String name;
    public String specialization;

    public Doctor(Integer id, String name, String specialization){
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }
}
