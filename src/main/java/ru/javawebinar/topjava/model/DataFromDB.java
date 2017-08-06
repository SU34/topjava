package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.util.MealsUtil;

/**
 * Created by evg_uh on 06.08.17.
 */
public class DataFromDB {
    private static final Logger log = LoggerFactory.getLogger(DataFromDB.class);
    public static AtomicInteger idMeals = new AtomicInteger();

    public static List<Meal> mealsList = new CopyOnWriteArrayList<>();

    static {
        log.debug("list of meals - start initialization");
        mealsList.add(new Meal(idMeals.incrementAndGet(), LocalDateTime.of(2016, 2, 3, 3, 1), "Test01", 33));
        mealsList.add(new Meal(idMeals.incrementAndGet(), LocalDateTime.of(2016, 1, 3, 3, 1), "Test02", 313));
        mealsList.add(new Meal(idMeals.incrementAndGet(), LocalDateTime.of(2016, 3, 3, 3, 1), "Test02", 313));
        mealsList.add(new Meal(idMeals.incrementAndGet(), LocalDateTime.of(2016, 1, 3, 13, 1), "Test03", 3));
        mealsList.add(new Meal(idMeals.incrementAndGet(), LocalDateTime.of(2017, 2, 3, 3, 1), "Test04", 3233));
        mealsList.add(new Meal(idMeals.incrementAndGet(), LocalDateTime.of(2017, 2, 3, 5, 1), "Test04", 33));
        mealsList.add(new Meal(idMeals.incrementAndGet(), LocalDateTime.of(2017, 2, 3, 3, 21), "Test04", 33));
        log.debug("list of meals - initialization completed");
        mealsList.forEach(ml -> log.debug(ml.toString()));
        log.debug("________________________________________");
    }

    public static List<MealWithExceed> getSortedMealWithExceed() {
        LocalTime startTime = LocalTime.of(0, 0, 0);
        LocalTime endTime = LocalTime.of(23, 0);
        List<MealWithExceed> mealWithExceedList = MealsUtil.getFilteredWithExceeded(mealsList, startTime, endTime, 1000);
        mealWithExceedList.sort(Comparator.comparing(MealWithExceed::getDateTime));
        log.debug("создан MealWithExceed:");
        mealWithExceedList.forEach(mwe -> log.debug(mwe.toString()));
        log.debug("_______________________________________________________");
        return mealWithExceedList;
    }
}
