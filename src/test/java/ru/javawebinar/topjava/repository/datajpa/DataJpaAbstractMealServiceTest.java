package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.service.AbstractMealServiceTest;

/**
 * Created by evg_uh on 15.09.17.
 */
@ActiveProfiles(Profiles.DATAJPA)
public class DataJpaAbstractMealServiceTest extends AbstractMealServiceTest {
}
