package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by evg_uh on 06.08.17.
 */
public class DataFromDB {
    private static final Logger log = LoggerFactory.getLogger(DataFromDB.class);
    public static AtomicInteger idMealWithExceed = new AtomicInteger();

    public static List<MealWithExceed> mealWithExceedList = new CopyOnWriteArrayList<>();

    static {
        log.debug("list of meals - start initialization");
        mealWithExceedList.add(new MealWithExceed(idMealWithExceed.incrementAndGet(), LocalDateTime.now(), "aaaaa", 23, false));
        mealWithExceedList.add(new MealWithExceed(idMealWithExceed.incrementAndGet(), LocalDateTime.of(2016, 2, 3, 3, 1), "bbb", 33, true));
        mealWithExceedList.add(new MealWithExceed(idMealWithExceed.incrementAndGet(), LocalDateTime.of(2017, 2, 3, 3, 1), "ccccc", 33, false));
        log.debug("list of meals - initialization completed");
    }

    public static List<MealWithExceed> getSortedMealWithExceed() {
        mealWithExceedList.sort(Comparator.comparing(MealWithExceed::getDateTime));
        return mealWithExceedList;
    }
}
