package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

/**
 * Created by evg_uh on 08.08.17.
 */
public class UsersUtil {
    public static final List<User> USERS = Arrays.asList(
            new User("Jackson", "1234", EnumSet.of(Role.ROLE_USER), 12, "teat@mail.com"),
            new User("Mike", "1234", EnumSet.of(Role.ROLE_USER), 12, "teat2@mail.com"),
            new User("Nike", "1234", EnumSet.of(Role.ROLE_USER), 12, "teat3@mail.com"),
            new User("Addidos", "1234", EnumSet.of(Role.ROLE_USER), 12, "teat4@mail.com"),
            new User("Nikolos", "1234", EnumSet.of(Role.ROLE_USER), 12, "teat5@mail.com")

    );

}
