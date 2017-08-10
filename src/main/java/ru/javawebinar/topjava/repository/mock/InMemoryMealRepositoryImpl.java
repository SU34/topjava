package ru.javawebinar.topjava.repository.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class InMemoryMealRepositoryImpl implements MealRepository {
    private static final Logger log = LoggerFactory.getLogger(InMemoryUserRepositoryImpl.class);
    private Map<Integer, Meal> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        MealsUtil.MEALS.forEach(m -> save(m, 2));
    }

    @Override
    public Meal save(Meal meal, int userId) {
        if (meal.isNew()) {
            meal.setId(counter.incrementAndGet());
            meal.setOwnerUserId(userId);
        }
        repository.put(meal.getId(), meal);
        log.debug("is puting {}", meal);
        return meal;
    }

    @Override
    public void delete(int id, int userId) {
        log.info("prepare to delete meal:{} by userId{}", repository.get(id), userId);
        if (repository.get(id).getOwnerUserId() == userId) repository.remove(id);
    }

    @Override
    public Meal get(int id, int userId) {
        log.info("get meal[id={}] from user[id={}]", id, userId);
        return (repository.get(id).getOwnerUserId() == userId) ? repository.get(id) : null;
    }

    @Override
    public List<Meal> getAll(int idUser) {
        log.info("get all by user[id={}]", idUser);
        List<Meal> mealList = new ArrayList<>();
        mealList.addAll(repository.values());
        log.debug("is initialization completed. mealList:{}", mealList);
        List<Meal> result = mealList.stream()
                .filter(meal -> (meal.getOwnerUserId() != null && meal.getOwnerUserId() == idUser))
                .sorted((x, y) -> -1 * (x.getDateTime().compareTo(y.getDateTime())))
                .collect(Collectors.toList());
        log.debug("return result:{}", result);
        return result;
    }
}