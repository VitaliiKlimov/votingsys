package model;

import java.time.LocalDate;
import java.util.List;

/**
 * User: Vitaly Klimov
 * Date: 15.11.2020
 */
public class Menu extends AbstractBaseEntity {
    private LocalDate date;
    private Restaurant restaurant;
    private List<Dish> dishes;


    public Menu(Integer id, LocalDate date) {
        super.id = id;
        this.date = date;
    }

    public void setRestaurant(Restaurant restaurant){
        this.restaurant = restaurant;
    }

    public List<Dish> getDishes() {
        return dishes;
    }
}
