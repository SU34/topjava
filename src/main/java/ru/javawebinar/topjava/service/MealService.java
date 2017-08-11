package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;

public interface MealService {
    Meal save(Meal meal, int idUser);

    void delete(int id, int idUser) throws NotFoundException;

    Meal get(int id, int idUser) throws NotFoundException;

    void update(Meal meal, int idUser);

    List<Meal> getAll(int idUser);

}