package Asso.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("ALBUM")
@Entity
public class Album extends Item{
    private String artist;
    private String etc;
}
