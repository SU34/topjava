package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.model.DataFromDB;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;

/**
 * Created by evg_uh on 06.08.17.
 */
public class DeleteMealServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(MealServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("method GET");

        resp.sendRedirect("/topjava/meals");
        log.debug("sendRedirect to /topjava/meals");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("delete meal started (method: POST)");
        int idToDel = Integer.parseInt(req.getParameter("id"));
        log.debug("идентификатор еды, который выделен для удаления {}", idToDel);
        Meal mealToDel = DataFromDB.mealsList.stream()
                .filter(ml -> ml.getId() == idToDel)
                .iterator().next();
        log.debug("будет удален следующий объект: %s", mealToDel);
        DataFromDB.mealsList.remove(mealToDel);
        log.warn("удален следующий объект: {}", mealToDel);
        doGet(req, resp);
    }
}
