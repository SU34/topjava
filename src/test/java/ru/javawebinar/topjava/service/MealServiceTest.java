package ru.javawebinar.topjava.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.DbPopulator;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by hp_lu_evg on 01.09.17.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/spring-db.xml"})
public class MealServiceTest {

    @Autowired
    private MealService service;

    @Autowired
    private DbPopulator populator;

    @Before
    public void setUp() throws Exception {
        populator.execute();
    }


    @Test
    public void testGet() throws Exception {
        service.get(100005, 100001);
    }

    @Test
    public void testDelete() throws Exception {
        service.delete(100005, 100001);
    }

    @Test(expected = NotFoundException.class)
    public void testNoMealOfDeleted() {
        service.get(100005, 100001);
    }

    @Test
    public void getBetweenDates() throws Exception {
    }

    @Test(expected = NotFoundException.class)
    public void getBetweenDateTimes() throws Exception {

    }

    @Test
    public void testGetAll() throws Exception {
        service.getAll(100000);
    }

    @Test
    public void testSave() throws Exception {
        service.save(new Meal(LocalDateTime.now(), "SUPERRR", 2), 100000);

    }

    @Test
    public void testUpdate() throws Exception {
    }

}