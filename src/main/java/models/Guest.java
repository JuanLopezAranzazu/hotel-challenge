package models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "guests")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guest_id")
    private Long guestId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private Date birthdate;
    private String nationality;
    @Column(name = "phone_number")
    private String phoneNumber;
    @ManyToOne
    private Reservation reservation;

    public Guest(){}

    public Guest(String firstName, String lastName, Date birthdate, String nationality, String phoneNumber, Reservation reservation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.nationality = nationality;
        this.phoneNumber = phoneNumber;
        this.reservation = reservation;
    }

    public Long getGuestId() {
        return guestId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}

