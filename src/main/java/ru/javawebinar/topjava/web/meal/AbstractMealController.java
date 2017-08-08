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

    public List<Meal> getAll() {
        log.info("get all");
        return service.getAll();
    }

    public Meal get(int id) {
        log.info("get {}", id);
        return service.get(id);
    }

    public Meal create(Meal meal) {
        log.info("create {}", meal);
        ValidationUtil.checkNew(meal);
        return service.save(meal);
    }

    public void update(Meal meal, int id) {
        log.info("update meal:{}, id:{}", meal, id);
        ValidationUtil.checkIdConsistent(meal, id);
        service.update(meal);
    }

    public void delete(int id) {
        log.info("delete");
        service.delete(id);
    }
}
