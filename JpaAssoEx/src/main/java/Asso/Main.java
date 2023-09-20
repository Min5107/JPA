package Asso;

import Asso.domain.Member;
import Asso.domain.Order;
import Asso.domain.OrderItem;
import Asso.domain.OrderStatus;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.time.LocalDateTime;
import java.util.Date;



public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin(); // 트랜잭션 시작

        // LocalDateTime 초기화
        LocalDateTime localDateTime = LocalDateTime.now();

        try {
            Member member = new Member();
//            member.setName("윤형우");
//            // setCity 부분 수정 (Member 엔티티에 city 관련 프로퍼티가 없는 경우)
//            member.setCity("윤형우시");
//            em.persist(member);

            Order order = new Order();
            order.setId(15L);
//            order.setOrderDate(localDateTime);
//            order.setStatus(OrderStatus.ORDER);
//            order.setMember(member);
//            em.persist(order);

//            OrderItem orderItem = new OrderItem();
//            orderItem.setOrder(order);
//            em.persist(orderItem);

            Order findOrder = em.find(Order.class, order.getId());
            Member findMember = findOrder.getMember();


            System.out.println("출력 : " + findMember.getName());
            System.out.println("출력 : " + findMember.getId() + " " + findMember.getCity());
            System.out.println("출력 : " + findOrder.getId());

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
