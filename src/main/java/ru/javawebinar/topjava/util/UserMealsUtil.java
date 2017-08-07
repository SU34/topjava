package ru.javawebinar.topjava.util;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;

/**
 * Created by evg_uh on 06.08.17.
 */
public class UserMealsUtil {
    private static final Logger log = LoggerFactory.getLogger(UserMealsUtil.class);
    public static AtomicInteger idMeals = new AtomicInteger();

    public static final List<Meal> MEAL_LIST = new CopyOnWriteArrayList<>();

    static {
        log.debug("________________________________________");
        log.debug("MEAL_LIST - start initialization");
        MEAL_LIST.add(new Meal(LocalDateTime.of(2016, 2, 3, 3, 1), "Test01", 33));
        MEAL_LIST.add(new Meal(LocalDateTime.of(2016, 1, 3, 3, 1), "Test02", 313));
        MEAL_LIST.add(new Meal(LocalDateTime.of(2016, 3, 3, 3, 1), "Test02", 313));
        MEAL_LIST.add(new Meal(LocalDateTime.of(2016, 1, 3, 13, 1), "Test03", 3));
        MEAL_LIST.add(new Meal(LocalDateTime.of(2017, 2, 3, 3, 1), "Test04", 3233));
        MEAL_LIST.add(new Meal(LocalDateTime.of(2017, 2, 3, 5, 1), "Test04", 33));
        MEAL_LIST.add(new Meal(LocalDateTime.of(2017, 2, 3, 3, 21), "Test04", 33));
        MEAL_LIST.forEach(ml -> log.debug(ml.toString()));
        log.debug("MEAL_LIST - initialization completed");
        log.debug("________________________________________");
    }

    public static List<MealWithExceed> getWithExceedSorted() {
        List<MealWithExceed> mealWithExceedList = MealsUtil.getFilteredWithExceeded(MEAL_LIST, LocalTime.MIN, LocalTime.MAX, 1000);
        mealWithExceedList.sort(Comparator.comparing(MealWithExceed::getDateTime));
        log.debug("выдаем getWithExceedSorted :");
        mealWithExceedList.forEach(mwe -> log.debug(mwe.toString()));
        log.debug("_______________________________________________________");
        return mealWithExceedList;
    }

    public static Meal getMealById(int idMeal) {
        return MEAL_LIST.stream()
                .filter(ml -> ml.getId() == idMeal)
                .iterator().next();
    }

    public static void delById(int idMeal) {
        MEAL_LIST.remove(getMealById(idMeal));
    }
}
