package ru.javawebinar.topjava.web.meal;

import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;

import java.util.List;

@Controller
public class MealRestController extends AbstractMealController {

    @Override
    public List<Meal> getAll(int idUser) {
        return super.getAll(idUser);
    }

    @Override
    public Meal get(int id, int idUser) {
        return super.get(id, idUser);
    }

    @Override
    public Meal create(Meal meal, int idUser) {
        return super.create(meal, idUser);
    }

    @Override
    public void update(Meal meal, int id, int idUser) {
        super.update(meal, id, idUser);
    }

    @Override
    public void delete(int id, int idUser) {
        super.delete(id, idUser);
    }
}