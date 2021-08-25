package backend.models;

public class Patient {
    public Integer id;
    public String name;
    public String CNP;
    public String phoneNumber;
    public String address;
    public String email;
    public Patient(Integer id, String name, String CNP, String phoneNumber, String address, String email) {
        this.id = id;
        this.name = name;
        this.CNP=CNP;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email= email;
    }
}
