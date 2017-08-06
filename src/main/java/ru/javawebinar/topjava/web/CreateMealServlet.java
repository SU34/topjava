package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.model.DataFromDB;
import ru.javawebinar.topjava.model.Meal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created by evg_uh on 06.08.17.
 */
public class CreateMealServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(MealServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("doGET!");
        resp.sendRedirect("/topjava/meals");
        log.debug("sendRedirect(\"/topjava/meals\");");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("create meal (method: POST)");
        LocalDateTime ldt = LocalDateTime.parse(req.getParameter("dateTime"));
        String desc = req.getParameter("description");
        int calories = Integer.parseInt(req.getParameter("calories"));
        DataFromDB.mealsList.add(new Meal(ldt, desc, calories));
        log.debug("new Meal is added to mealList");
        doGet(req, resp);
    }
}
