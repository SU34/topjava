package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.util.ValidationUtil;

import java.util.List;

/**
 * Created by hp_lu_evg on 09.08.17.
 */
public abstract class AbstractMealController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MealService service;

    public List<Meal> getAll(int idUser) {
        log.info("get all");
        return service.getAll(idUser);
    }

    public Meal get(int id, int idUser) {
        log.info("get {}", id);
        return service.get(id, idUser);
    }

    public Meal create(Meal meal, int idUser) {
        log.info("create {}", meal);
        ValidationUtil.checkNew(meal);
        return service.save(meal, idUser);
    }

    public void update(Meal meal, int idMeal, int idUser) {
        log.info("update meal:{}, idMeal:{}, idUser:{}", meal, idMeal, idUser);
        ValidationUtil.checkIdConsistent(meal, idMeal);
        service.update(meal, idUser);
    }

    public void delete(int id, int idUser) {
        log.info("delete");
        service.delete(id, idUser);
    }
}
