package ru.javawebinar.topjava.repository.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoryMealRepositoryImpl implements MealRepository {
    private static final Logger log = LoggerFactory.getLogger(InMemoryUserRepositoryImpl.class);
    private Map<Integer, Meal> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        MealsUtil.MEALS.forEach(m -> save(m, 2));

    }

    @Override
    public Meal save(Meal meal, int idUser) {
        if (meal.isNew()) {
            meal.setId(counter.incrementAndGet());
            meal.setOwnerUserId(idUser);
        }
        repository.put(meal.getId(), meal);
        return meal;
    }

    @Override
    public void delete(int id) {
        repository.remove(id);
    }

    @Override
    public Meal get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Meal> getAll() {
        log.info("get all");
        List<Meal> meals = new ArrayList<>();
        meals.addAll(repository.values());
        log.debug("success conver to list<Meal>");
        meals.sort((meal, t1) -> -1 * meal.getDateTime().compareTo(t1.getDateTime()));
        log.debug("all:{}", meals);
        return meals;
    }
}

