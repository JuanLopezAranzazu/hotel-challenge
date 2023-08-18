package dao;

import models.Reservation;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReservationDAO {
    private EntityManager em;
    private double value=20;

    public ReservationDAO(EntityManager em){
        this.em = em;
    }

    public void createReservation(Reservation newReservation){
        long diff=newReservation.getEndDate().getTime()-newReservation.getStartDate().getTime();
        long days=TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
        newReservation.setValue(days*this.value);
        this.em.persist(newReservation);
    }

    public void updateReservation(Reservation reservation){
        this.em.merge(reservation);
    }

    public void deleteReservation(Reservation reservation){
        reservation=this.em.merge(reservation);
        this.em.remove(reservation);
    }

    public Reservation getReservationById(Long reservationId){
        return this.em.find(Reservation.class,reservationId);
    }

    public List<Reservation> getReservations() {
        String jpql = "SELECT r FROM Reservation AS r";
        return this.em.createQuery(jpql, Reservation.class).getResultList();
    }
}
