package com.votingsys.repository;

import com.votingsys.model.Dish;
import java.time.LocalDate;
import java.util.List;
import static com.votingsys.model.AbstractBaseEntity.START_SEQ;

/**
 * User: Vitaliy Klimov
 * Date: 30.11.2020
 */
public class DishTestData {
    public static final TestMatcher<Dish> DISH_MATCHER = TestMatcher.usingIgnoringFieldsComparator(Dish.class, "restaurant");

    public static final int DISH_ID = START_SEQ + 6;
    public static final int RESTAURANT1_ID = START_SEQ + 2;
    public static final int RESTAURANT2_ID = START_SEQ + 3;

    public static final Dish dish1 = new Dish(DISH_ID, "Борщ", LocalDate.now(), 1500);
    public static final Dish dish2 = new Dish(DISH_ID + 1, "Картофельное пюре", LocalDate.now(), 1000);
    public static final Dish dish3 = new Dish(DISH_ID + 2, "Компот", LocalDate.now(), 500);
    public static final Dish dish4 = new Dish(DISH_ID + 3, "Лагман", LocalDate.now(), 1000);
    public static final Dish dish5 = new Dish(DISH_ID + 4, "Плов", LocalDate.of(2020,10,28), 700);
    public static final Dish dish6 = new Dish(DISH_ID + 5, "Чай", LocalDate.of(2020,10,28), 400);

    public static List<Dish> menu1 = List.of(dish1, dish2, dish3);
    public static List<Dish> menu2 = List.of(dish5, dish6);

    public static Dish getNew() {
        return new Dish(DISH_ID, "Новое блюдо", LocalDate.now(), 800);
    }

    public static Dish getUpdated() {
        return new Dish(DISH_ID, "Обновленный борщ", LocalDate.now(), 1700);
    }
}
