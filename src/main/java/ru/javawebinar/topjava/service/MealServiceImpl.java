package ru.javawebinar.topjava.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public Meal save(Meal meal, int idUser) {
        return repository.save(meal, idUser);
    }

    @Override
    public void delete(int id, int idUser) throws NotFoundException {
        if (repository.get(id, idUser) == null)
            throw new NotFoundException("you can't to delete this meal");
        repository.delete(id, idUser);
    }

    @Override
    public Meal get(int id, int idUser) throws NotFoundException {
        if (repository.get(id, idUser) == null)
            throw new NotFoundException("you can't to see this meal");
        return repository.get(id, idUser);
    }

    @Override
    public void update(Meal meal, int idUser) {
        if (meal.getOwnerUserId() != idUser)
            throw new NotFoundException("you cant's update this meal");
        log.debug("prepare to update {}, by user id:{}", meal,idUser);
        repository.save(meal, idUser);
    }

    @Override
    public List<Meal> getAll(int idUser) {
        return repository.getAll(idUser)
                .stream()
                .filter(m -> m.getOwnerUserId() == idUser)
                .collect(Collectors.toList());
    }
}