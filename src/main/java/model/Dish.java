package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "dishes")
public class Dish extends AbstractNamedEntity {

    @Column(name = "price", nullable = false)
    @NotNull
    private int price;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public Dish() {

    }

    public Dish(Integer id, String name, int price) {
        super(id, name);
        this.price = price;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
