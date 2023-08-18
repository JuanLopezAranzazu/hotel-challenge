package dao;

import models.Guest;

import javax.persistence.EntityManager;
import java.util.List;

public class GuestDAO {
    private EntityManager em;

    public GuestDAO(EntityManager em){
        this.em = em;
    }

    public void createGuest(Guest newGuest){
        this.em.persist(newGuest);
    }

    public void updateGuest(Guest guest){
        this.em.merge(guest);
    }

    public void deleteGuest(Guest guest){
        guest=this.em.merge(guest);
        this.em.remove(guest);
    }

    public Guest getGuestById(Long guestId){
        return this.em.find(Guest.class,guestId);
    }

    public List<Guest> getGuests() {
        String jpql = "SELECT g FROM Guest AS g";
        return this.em.createQuery(jpql, Guest.class).getResultList();
    }
}
