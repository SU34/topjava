package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;

@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealRepository repository;

    @Override
    public Meal save(Meal meal) {
        return repository.save(meal, AuthorizedUser.id());
    }

    @Override
    public void delete(int id) throws NotFoundException {
        Meal meal = repository.get(id);
        if (meal.getOwnerUserId() != AuthorizedUser.id()) throw new NotFoundException("you can't to delete this meal");
        repository.delete(id);
    }

    @Override
    public Meal get(int id) throws NotFoundException {
        Meal meal = repository.get(id);
        if (meal.getOwnerUserId() != AuthorizedUser.id()) throw new NotFoundException("you can't to see this meal");
        else return meal;
    }

    @Override
    public void update(Meal meal) {
        if (meal.getOwnerUserId()!=AuthorizedUser.id()) throw new NotFoundException("you cant's update this meal");
        repository.save(meal, AuthorizedUser.id());
    }

    @Override
    public List<Meal> getAll() {
        return (List<Meal>) repository.getAll();
    }
}