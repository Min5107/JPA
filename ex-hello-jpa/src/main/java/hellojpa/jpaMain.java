package hellojpa;

import javax.persistence.*;
import java.awt.print.PrinterException;
import java.util.List;

public class jpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin(); // 트랜잭션 시작

        //code
        try {
            // 삽입 연산
            Member member = new Member();
            member.setId(1L);
            member.setUsername("HelloC");
            em.persist(member); // 삽입 연산

            // 조회 연산
//            Member findMember = em.find(Member.class, 3L);
//            System.out.println("id : " + findMember.getId());
//            System.out.println("name : " + findMember.getName());
            // 업데이트 연산
//              Member findMember = em.find(Member.class, 3L);
//              findMember.setName("GoodbyeC");
//            System.out.println("id : " + findMember.getId());
//            System.out.println("name : " + findMember.getName());
            //JPQL
//            List<Member> result = em.createQuery("select m from Member as m ", Member.class)
//                            .setFirstResult(0)
//                                    .setMaxResults(2)
//                                            .getResultList();
//            for (Member member : result){
//                System.out.println("Name : " + member.getName());
//            }
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
