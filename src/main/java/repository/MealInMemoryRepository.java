package repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;

/**
 * Created by evg_uh on 06.08.17.
 */
public class MealInMemoryRepository implements MealRepository {
    private static final Logger log = LoggerFactory.getLogger(MealInMemoryRepository.class);
    private AtomicInteger genId = new AtomicInteger(0);
    private Map<Integer, Meal> repository = new ConcurrentHashMap<>();

    {
        log.debug("________________________________________");
        log.debug("repository - start initialization");
        save(new Meal(LocalDateTime.of(2016, 2, 3, 3, 1), "Завтрак", 33));
        save(new Meal(LocalDateTime.of(2016, 1, 3, 3, 1), "Полдник", 313));
        save(new Meal(LocalDateTime.of(2016, 3, 3, 3, 1), "Обед", 313));
        save(new Meal(LocalDateTime.of(2016, 1, 3, 13, 1), "Ужин", 3));
        save(new Meal(LocalDateTime.of(2017, 2, 3, 3, 1), "Ужин", 3233));
        save(new Meal(LocalDateTime.of(2017, 2, 3, 5, 1), "Обед", 33));
        save(new Meal(LocalDateTime.of(2017, 2, 3, 3, 21), "Завтрак", 33));
        log.debug("repository - initialization completed");
        log.debug("________________________________________");
    }

    @Override
    public Meal save(Meal meal) {
        if (meal.checkId()) {
            meal.setId(genId.incrementAndGet());
        }
        return repository.put(meal.getId(), meal);
    }

    @Override
    public Meal get(int idMeal) {
        return repository.get(idMeal);
    }

    @Override
    public Collection<Meal> getAll() {
        return repository.values();
    }

    @Override
    public void delete(int idMeal) {
        repository.remove(idMeal);
    }

    public List<MealWithExceed> getWithExceedSorted() {
        return null;
    }
}
