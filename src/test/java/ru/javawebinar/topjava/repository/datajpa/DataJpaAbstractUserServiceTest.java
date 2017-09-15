package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.service.AbstractUserServiceTest;

/**
 * Created by hp_lu_evg on 16.09.17.
 */
@ActiveProfiles(Profiles.DATAJPA)
public class DataJpaAbstractUserServiceTest extends AbstractUserServiceTest {
}
