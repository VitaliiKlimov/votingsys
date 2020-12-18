package com.votingsys.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractNamedEntity {


    public Restaurant() {

    }

    public Restaurant(String name) {
        this(null, name);
    }

    public Restaurant(Integer id, String name) {
        super.id = id;
        super.name = name;
    }

    public Restaurant(Restaurant restaurant) {
        super.id = restaurant.getId();
        super.name = restaurant.getName();
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @OrderBy("dateTime DESC")
    @JsonIgnore
    private List<Vote> votes;

}
