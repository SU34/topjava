package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.model.Meal;
import repository.MealInMemoryRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;


/**
 * Created by hp_lu_evg on 06.08.17.
 */
public class MealServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(MealServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("doGet start");
        String action = req.getParameter("action");

        if (action == null) {
            req.setAttribute("meals", MealInMemoryRepository.getWithExceedSorted());
            req.getRequestDispatcher("meals.jsp").forward(req, resp);
        } else if (action.equals("delete")) {
            int idToDel = getId(req);
            MealInMemoryRepository.delete(idToDel);
            resp.sendRedirect("meals");
        } else if (action.equals("new")) {
            req.setAttribute("meal", new Meal(LocalDateTime.now(), "", 0));
            req.getRequestDispatcher("mealEdit.jsp").forward(req, resp);
        } else if (action.equals("edit")) {
            req.setAttribute("meal", MealInMemoryRepository.get(getId(req)));
            req.getRequestDispatcher("mealEdit.jsp").forward(req, resp);
        } else if (action.equals("save")) {

        }

    }

    private int getId(HttpServletRequest req) {
        String paramId = Objects.requireNonNull(req.getParameter("id"));
        return Integer.valueOf(paramId);
    }
}
