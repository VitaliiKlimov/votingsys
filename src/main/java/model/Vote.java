package model;

import java.time.LocalDateTime;

/**
 * User: Vitaliy Klimov
 * Date: 15.11.2020
 */
public class Vote extends AbstractBaseEntity {
    private User user;
    private Restaurant restaurant;
    private LocalDateTime dateTime;

    public Vote(LocalDateTime dateTime){
    this.dateTime = dateTime;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
