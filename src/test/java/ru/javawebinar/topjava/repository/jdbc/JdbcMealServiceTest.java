package ru.javawebinar.topjava.repository.jdbc;

import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.service.MealServiceTest;

/**
 * Created by evg_uh on 15.09.17.
 */
@ActiveProfiles(Profiles.JDBC)
public class JdbcMealServiceTest extends MealServiceTest{
}
