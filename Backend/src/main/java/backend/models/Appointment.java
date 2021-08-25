package backend.models;

import java.util.Date;

public class Appointment {
    public Integer id;
    public Integer doctorId;
    public Integer patientId;
    public Date appointmentDate;
    public Appointment(Integer id, Integer doctorId, Integer patientId, Date appointmentDate) {
        this.id = id;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.appointmentDate = appointmentDate;
    }
}
