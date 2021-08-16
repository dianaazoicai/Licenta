package backend.models;

public class PacientModel {
    public Integer id_pacient;
    public String nume_pacient;
    public String CNP;
    public String telefon;
    public String adresa;
    public String email;
    public PacientModel(Integer id_pacient,String nume_pacient,String CNP,String telefon,String adresa,String email)
    {
        this.id_pacient=id_pacient;
        this.nume_pacient=nume_pacient;
        this.CNP=CNP;
        this.telefon=telefon;
        this.adresa=adresa;
        this.email=email;
    }
}
