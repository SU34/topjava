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
 * Created by evg_uh on 06.08.17.
 */
public class DeleteMealServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(MealServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("delete meal started (method: POST)");
        int idToDel = Integer.parseInt(req.getParameter("id"));
        DataFromDB.mealWithExceedList.remove(idToDel);
        log.debug("mealWithExceed is delete (id = )" + idToDel);
        super.doPost(req, resp);
    }
}
