package ru.javawebinar.topjava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.UserService;

import java.util.List;

/**
 * Created by evg_uh on 24.09.17.
 */
@Controller
@RequestMapping(value = "/tests")
public class TestController {

    private final UserService userService;

    @Autowired
    public TestController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/one")
    public String startTestOne(ModelMap model) {
        List<Meal> users = userService.testMethodSpecialOne();
        model.addAttribute("meals", users);
        return "testPage";
    }
}
