package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.model.DataFromDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by hp_lu_evg on 06.08.17.
 */
public class MealServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(MealServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("start MealServlet");

        req.setAttribute("meals", DataFromDB.getSortedMealWithExceed());
        log.debug("set attribute mealsList");

        req.getRequestDispatcher("meals.jsp").forward(req, resp);
        log.debug("forward to meals");
    }
}
