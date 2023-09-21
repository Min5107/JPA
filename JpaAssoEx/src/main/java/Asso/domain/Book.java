package Asso.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("BOOK")
@Entity
public class Book extends Item{
    private String author;
    private String isbn;
}
