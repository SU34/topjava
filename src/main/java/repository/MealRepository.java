package repository;

import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;

/**
 * Created by hp_lu_evg on 08.08.17.
 */
public interface MealRepository {
    Meal save(Meal meal);

    void delete(int id);

    Meal get(int id);

    Collection<Meal> getAll();
}
