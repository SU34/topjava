package ru.javawebinar.topjava.repository.jdbc;

import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.service.AbstractUserServiceTest;

/**
 * Created by hp_lu_evg on 16.09.17.
 */
@ActiveProfiles(Profiles.JDBC)
public class JdbcAbstractUserServiceTest extends AbstractUserServiceTest {
}
