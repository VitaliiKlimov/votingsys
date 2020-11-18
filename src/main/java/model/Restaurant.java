package model;


public class Restaurant extends AbstractNamedEntity {
    private Menu menu;

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
