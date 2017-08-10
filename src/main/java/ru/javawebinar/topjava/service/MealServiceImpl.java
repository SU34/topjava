package ru.javawebinar.topjava.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealServiceImpl implements MealService {

    private static Logger log = LoggerFactory.getLogger(MealServiceImpl.class);
    @Autowired
    private MealRepository repository;

    @Override
    public Meal save(Meal meal) {
        return repository.save(meal, AuthorizedUser.id());
    }

    @Override
    public void delete(int id) throws NotFoundException {
        if (repository.get(id, AuthorizedUser.id()) == null)
            throw new NotFoundException("you can't to delete this meal");
        repository.delete(id, AuthorizedUser.id());
    }

    @Override
    public Meal get(int id) throws NotFoundException {
        if (repository.get(id, AuthorizedUser.id()) == null)
            throw new NotFoundException("you can't to see this meal");
        return repository.get(id, AuthorizedUser.id());
    }

    @Override
    public void update(Meal meal) {
        if (meal.getOwnerUserId() != AuthorizedUser.id())
            throw new NotFoundException("you cant's update this meal");
        log.debug("prepare to update {}, by user id:{}", meal,AuthorizedUser.id());
        repository.save(meal, AuthorizedUser.id());
    }

    @Override
    public List<Meal> getAll() {
        return repository.getAll(AuthorizedUser.id())
                .stream()
                .filter(m -> m.getOwnerUserId() == AuthorizedUser.id())
                .collect(Collectors.toList());
    }
}