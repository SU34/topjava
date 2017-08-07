package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.model.Meal;
import repository.MealInMemoryRepository;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


/**
 * Created by hp_lu_evg on 06.08.17.
 */
public class MealServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(MealServlet.class);
    private MealInMemoryRepository repository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        repository = new MealInMemoryRepository();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("doPost start");
        req.setCharacterEncoding("UTF-8");
        log.debug("action == save");
        String desc = req.getParameter("description");
        log.debug("description:{}", desc);
        LocalDateTime dateTime = LocalDateTime.parse(req.getParameter("dateTime"));
        log.debug("dateTime:{}", dateTime);
        int calories = Integer.valueOf(req.getParameter("calories"));
        log.debug("calories:{}", calories);
        Meal mealToSave = new Meal(dateTime, desc, calories);

        String paramId = req.getParameter("id");
        if (paramId != null && !paramId.isEmpty()) {
            log.debug("id:[{}]", paramId);
            mealToSave.setId(Integer.valueOf(paramId));
        }
        log.debug("сформирован объект на сохранение {}", mealToSave);
        repository.save(mealToSave);
        resp.sendRedirect("/topjava/meals");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("doGet start");
        String action = req.getParameter("action");

        if (action == null) {
            log.debug("action == null");
            List<MealWithExceed> withExceeded = MealsUtil.getWithExceeded(repository.getAll(), 2000);
            req.setAttribute("meals", withExceeded);
            req.getRequestDispatcher("meals.jsp").forward(req, resp);
        } else if (action.equals("delete")) {
            log.debug("action == delete");
            int idToDel = getId(req);
            repository.delete(idToDel);
            resp.sendRedirect("meals");
        } else if (action.equals("new")) {
            log.debug("action == new");
            req.setAttribute("meal", new Meal(LocalDateTime.now(), "", 0));
            req.getRequestDispatcher("mealEdit.jsp").forward(req, resp);
        } else if (action.equals("edit")) {
            log.debug("action == edit");
            req.setAttribute("meal", repository.get(getId(req)));
            req.getRequestDispatcher("mealEdit.jsp").forward(req, resp);
        }

    }

    private int getId(HttpServletRequest req) {
        String paramId = Objects.requireNonNull(req.getParameter("id"));
        return Integer.valueOf(paramId);
    }
}
