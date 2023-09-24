package Asso.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "PARENT_ID") // Slef Join
    private Category parent;
    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();


    // 다대다 따로 만들지 않고 자동으로 만드는 방법
    @ManyToMany
    // 테이블 명
    @JoinTable(name = "CATEGORY_ITEM",
    joinColumns = @JoinColumn(name = "CATEGORY_ID"),
    inverseJoinColumns = @JoinColumn(name = "ITEM_ID")) // 테이블 생성시 상대 테이블에서 가져올 FK
    private List<Item> items = new ArrayList<>();


}
