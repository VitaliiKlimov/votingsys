package model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractNamedEntity {

    @OneToOne
    private Menu menu;

    public Restaurant() {

    }

    public Restaurant(Integer id, String name) {
        super.id = id;
        super.name = name;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
    }
}
