package Asso;

import Asso.domain.Member;
import Asso.domain.Team;
import org.hibernate.internal.build.AllowSysOut;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin(); // 트랜잭션 시작

        //code
        try {
            Team team = new Team();
            team.setName("TeamA");
            // team.getMembers().add(member); // 연관관계가 적용되지 못함(mappedBy가 team에 적용되어 있기 때문에 member로 선택해야함)
            em.persist(team);

            Member member = new Member();
            member.setName("member1");
            member.setTeam(team);
            em.persist(member);

            Member findMember = em.find(Member.class, member.getId());
            Team findTeam = findMember.getTeam();
            System.out.println("findTeam = " + findTeam.getName());

            List<Member> members = findMember.getTeam().getMembers();

            for (Member m : members){
                System.out.println("m = " + m.getName());
            }

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