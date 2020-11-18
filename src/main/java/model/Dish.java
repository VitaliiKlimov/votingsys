package model;

public class Dish extends AbstractBaseEntity {
    private String name;
    private int price;
    private Menu menu;

    public Dish(Integer id, String name, int price) {
        super(id);
        this.name = name;
        this.price = price;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
