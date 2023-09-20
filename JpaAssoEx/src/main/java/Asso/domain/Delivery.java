package Asso.domain;

import javax.persistence.*;

@Entity
public class Delivery {

    @Column(name = "DELIVERY_ID")
    @GeneratedValue
    @Id
    private long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;
    private String city;
    private String street;
    private String zipCode;
    private String status;
}
