package com.votingsys.model;

import javax.persistence.Entity;
import javax.persistence.Table;

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

}
