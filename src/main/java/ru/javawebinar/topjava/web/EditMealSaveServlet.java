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
 * Created by hp_lu_evg on 07.08.17.
 */
public class EditMealSaveServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(EditMealSaveServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("doGET!!!");
        resp.sendRedirect("/topjava/meals");
        log.debug("is redirect to /topjava/meals");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("doPOST");
        log.debug("starting get parameters");
        String desc = req.getParameter("description");
        int idToUpdate = Integer.parseInt(req.getParameter("id"));
        int calories = Integer.parseInt(req.getParameter("calories"));
        LocalDateTime ldt = LocalDateTime.parse(req.getParameter("dateTime"));
        log.debug("parameters is all read");
        Meal mealToUpdate = DataFromDB.getMealById(idToUpdate);
        DataFromDB.mealsList.remove(mealToUpdate);
        Meal newMeal = new Meal(idToUpdate, ldt, desc, calories);
        DataFromDB.mealsList.add(newMeal);
        log.debug("is added new Meal {}", newMeal);
        doGet(req,resp);
    }
}
