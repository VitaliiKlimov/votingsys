package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

/**
 * User: Vitaly Klimov
 * Date: 15.11.2020
 */

@Entity
@Table(name = "menus")
public class Menu extends AbstractBaseEntity {

    @Column(name = "date", nullable = false)
    @NotNull
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "rest_id")
    private Restaurant restaurant;

    @OneToMany
    private List<Dish> dishes;

    public Menu() {

    }

    public Menu(Integer id, LocalDate date) {
        super.id = id;
        this.date = date;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Dish> getDishes() {
        return dishes;
    }
}
