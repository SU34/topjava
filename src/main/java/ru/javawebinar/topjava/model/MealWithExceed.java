package ru.javawebinar.topjava.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class MealWithExceed {
    private static Logger logger = LoggerFactory.getLogger(MealWithExceed.class);
    private int id;

    private final LocalDateTime dateTime;

    private final String description;

    private final int calories;

    private final boolean exceed;

    public MealWithExceed(int id, LocalDateTime dateTime, String description, int calories, boolean exceed) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.exceed = exceed;
        this.id = id;
        logger.debug("is create object:" + this);
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "MealWithExceed{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ", exceed=" + exceed +
                '}';
    }

    public boolean isExceed() {
        return exceed;
    }

}
