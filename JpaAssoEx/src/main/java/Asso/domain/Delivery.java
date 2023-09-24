package Asso.domain;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Delivery {

    @Column(name = "DELIVERY_ID")
    @GeneratedValue
    @Id
    private long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;
    private String city;
    private String street;
    private String zipCode;
    private String status;
}
