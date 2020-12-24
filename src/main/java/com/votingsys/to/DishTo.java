package com.votingsys.to;

import java.time.LocalDate;

/**
 * User: Vitaliy Klimov
 * Date: 21.12.2020
 */
public class DishTo extends BaseTo {

    private String description;

    private int price;

    private LocalDate date;

    private Integer restaurantId;

    public DishTo() {

    }

    public DishTo(Integer id, String description, int price, LocalDate date, Integer restaurantId) {
        super(id);
        this.description = description;
        this.price = price;
        this.date = date;
        this.restaurantId = restaurantId;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    @Override
    public String toString() {
        return "RestaurantTo{" +
                "id=" + id +
                ", restaurant id=" + restaurantId +
                ", date=" + date +
                ", description=" + description +
                ", price=" + price +
                '}';
    }
}
