package com.votingsys.to;

import java.util.Objects;

/**
 * User: Vitaliy Klimov
 * Date: 19.12.2020
 */
public class RestaurantTo {
    private Integer id;
    private final String name;
    private final int votes;

    public RestaurantTo(Integer id, String name, int votes) {
        this.id = id;
        this.name = name;
        this.votes = votes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getVotes() {
        return votes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantTo restaurantTo = (RestaurantTo) o;
        return  votes == restaurantTo.votes &&
                Objects.equals(id, restaurantTo.id) &&
                Objects.equals(name, restaurantTo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, votes);
    }

    @Override
    public String toString() {
        return "RestaurantTo{" +
                "id=" + id +
                ", name=" + name +
                ", votes=" + votes +
                '}';
    }
}
