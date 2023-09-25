package hellojpa;

import hellojpa.domain.Member;
import hellojpa.domain.Team;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
        tx.begin(); // 트랜잭션 시작

        try {
            Team team = new Team();
            team.setName("군산");
            em.persist(team);

            Member member = new Member();
            member.setUsername("윤형우");
            member.setAge(10);
            member.setTeam(team);
            em.persist(member);



            Query query1 = em.createQuery("SELECT m.username, m.age, t.name FROM Member m JOIN m.team t");
            List<Object[]> result1 = query1.getResultList();

            for (Object[] memberData : result1) {
                String username = (String) memberData[0];
                Integer age = (Integer) memberData[1];
                String name = (String) memberData[2];
                System.out.println("Username: " + username + ", Age: " + age + " TeamName " + name );
            }


//            TypedQuery<Member> query = em.createQuery("select m from Member m where m.username = :username", Member.class);
//            query.setParameter("username", "윤형우");
//            Member result = query.getSingleResult();

            Member query = em.createQuery("select m from Member m where m.username = :username", Member.class)
                    .setParameter("username", "윤형우")
                    .getSingleResult();

            System.out.println(query.getAge());

        tx.commit(); // 트랜잭션 커밋
    } catch (Exception e) {
        tx.rollback();
        e.printStackTrace();
    } finally {
        em.close();
    }

        emf.close();
}
}