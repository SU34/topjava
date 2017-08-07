package ru.javawebinar.topjava.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.MealInMemoryRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Meal {
    private static final Logger log = LoggerFactory.getLogger(Meal.class);
    private Integer id;
    private final LocalDateTime dateTime;

    private final String description;

    private final int calories;

    public Meal(LocalDateTime dateTime, String description, int calories) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        id = MealInMemoryRepository.genIdMeals.incrementAndGet();
        log.trace("is created {}", this);
    }

    public Meal(int id, LocalDateTime dateTime, String description, int calories) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.id = id;
        log.trace("is created {}", this);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean checkId() {
        return id == null;
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

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }

    public int getId() {
        return id;
    }

    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                '}';
    }
}
