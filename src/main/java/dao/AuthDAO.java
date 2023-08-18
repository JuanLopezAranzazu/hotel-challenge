package dao;

import models.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.EntityManager;

public class AuthDAO {
    private EntityManager em;

    public AuthDAO(EntityManager em){
        this.em = em;
    }

    public boolean login(String username,String password){
        String jpql = "SELECT g FROM User AS g WHERE g.username=:username";
        User user=this.em.createQuery(jpql,User.class).setParameter("username",username).getSingleResult();
        if(user!=null){
            String passwordHash=user.getPassword();
            return BCrypt.checkpw(password,passwordHash);
        }
        return false;
    }
}
