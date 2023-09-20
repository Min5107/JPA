//package Asso.domain;
//
//import javax.persistence.*;
//
//// 다대다 두개의 테이블에서 가져와서 맵핑
//@Entity
//public class Category_Item {
//
//    @Id
//    @GeneratedValue
//    private long id;
//
//    @ManyToOne
//    @JoinColumn(name = "ITEM_ID")
//    private Item item;
//
//    @ManyToOne
//    @JoinColumn(name = "CATEGORY")
//    private Category category;
//
//}
