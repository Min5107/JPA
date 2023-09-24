package Asso.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    // GeneratedValue 생략해도 Default AUTO임
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private long id;

    private String name;
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
    @Embedded
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }



}
