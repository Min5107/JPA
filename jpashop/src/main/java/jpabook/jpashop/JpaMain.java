package jpabook.jpashop;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin(); // 트랜잭션 시작

        //code
        try {

            tx.commit(); // 트랜잭션 커밋
        } catch (Exception e){
            tx.rollback();
            e.printStackTrace();

        }finally {
            em.close();
        }

        emf.close();
    }
}
