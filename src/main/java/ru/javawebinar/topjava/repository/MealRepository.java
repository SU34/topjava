package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;

import java.util.Collection;

public interface MealRepository {
    Meal save(Meal Meal, int idUser);

    void delete(int id);

    Meal get(int id);

    Collection<Meal> getAll();
}
