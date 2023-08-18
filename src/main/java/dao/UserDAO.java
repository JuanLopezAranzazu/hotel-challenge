package dao;

import models.Guest;
import models.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.EntityManager;

public class UserDAO {
    private EntityManager em;

    public UserDAO(EntityManager em){
        this.em = em;
    }

    public void createUser(User newUser){
        String passwordHash = BCrypt.hashpw(newUser.getPassword(),BCrypt.gensalt());
        newUser.setPassword(passwordHash);
        this.em.persist(newUser);
    }

    public void deleteUser(User user){
        user=this.em.merge(user);
        this.em.remove(user);
    }

    public User getUserById(Long userId){
        return this.em.find(User.class,userId);
    }
}
