package jpabasic.reserve.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UserGetMain {
    public static void main(String[] arg) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabegin");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            User user = em.find(User.class, "user1@user.com");
            if (user == null) {
                System.out.println("User 없음");
            } else {
                System.out.printf("User 있음: email=%s, name=%s, createDate=%s\n", user.getEmail(), user.getName(), user.getCreateDate());
            }

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
