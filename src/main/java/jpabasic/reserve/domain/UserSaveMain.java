package jpabasic.reserve.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;

public class UserSaveMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabegin");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et =  em.getTransaction();

        try {
            et.begin();
            User user = new User("user@user.com", "user", LocalDateTime.now());
            em.persist(user);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
