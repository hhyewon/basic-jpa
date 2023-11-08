package jpabasic.reserve.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UserUpdateMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabegin");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            User user = em.find(User.class, "user@user.com");
            if (user == null) {
                System.out.println("User 없음");
            } else {
                String newName = "이름" + (System.currentTimeMillis() % 100);
                user.changeName(newName);
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
