package org.example;

import dao.AuthDAO;
import dao.GuestDAO;
import dao.ReservationDAO;
import dao.UserDAO;
import models.Guest;
import models.Reservation;
import models.User;
import utils.JPAUtils;
import javax.persistence.EntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EntityManager em = new JPAUtils().getEntityManager();
        em.getTransaction().begin();

        UserDAO userDAO=new UserDAO(em);
        GuestDAO guestDAO=new GuestDAO(em);
        ReservationDAO reservationDAO=new ReservationDAO(em);
        AuthDAO authDAO=new AuthDAO(em);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        /*User newUser=new User("admin","admin");
        userDAO.createUser(newUser);*/

        /*User user=userDAO.getUserById(1l);
        userDAO.deleteUser(user);*/

        /*System.out.println(authDAO.login("admin","admin1")?"yes":"no");*/

        /*try {
            Date startDate = dateFormat.parse("2023-08-02");
            Date endDate = dateFormat.parse("2023-08-08");
            Reservation newReservation=new Reservation(startDate,endDate,"Tarjeta de Crédito");
            reservationDAO.createReservation(newReservation);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }*/

        /*try {
            Date birthdate = dateFormat.parse("2001-01-02");
            Reservation reservation=reservationDAO.getReservationById(2l);
            if(reservation!=null) {
                Guest guest = new Guest("guest", "guest", birthdate, "Colombia", "3110000000",reservation);
                guestDAO.createGuest(guest);
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }*/

        em.getTransaction().commit();
        em.close();
    }
}