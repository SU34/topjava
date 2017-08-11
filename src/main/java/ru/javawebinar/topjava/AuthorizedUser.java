package ru.javawebinar.topjava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static ru.javawebinar.topjava.util.MealsUtil.DEFAULT_CALORIES_PER_DAY;

public class AuthorizedUser {
    public static final Logger log = LoggerFactory.getLogger(AuthorizedUser.class);
    public static int id;

    public static void setId(int id) {
        AuthorizedUser.id = id;
        log.info(" -> is authorized now user_id = {}", id);
    }

    public static int id() {
        return id;
    }

    public static int getCaloriesPerDay() {
        return DEFAULT_CALORIES_PER_DAY;
    }
}