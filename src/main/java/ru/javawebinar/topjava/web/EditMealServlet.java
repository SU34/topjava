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

/**
 * Created by evg_uh on 06.08.17.
 */
public class EditMealServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(MealServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("doGET !!");
        log.debug("в обработке:",req.getAttribute("meal").toString());
        req.getRequestDispatcher("mealEdit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("update meal (method: POST)");
        int idToEdit = Integer.parseInt(req.getParameter("id"));
        log.debug("id to edit = {}", idToEdit);
        Meal mealToEdit = DataFromDB.getMealById(idToEdit);
        req.setAttribute("meal",mealToEdit);
        log.debug("set attribute mealToEdit");
        doGet(req, resp);
    }
}
