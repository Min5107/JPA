package Asso.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("MOVIE")
@Entity
public class Movie extends Item{
    private String director;
    private String actor;
}
