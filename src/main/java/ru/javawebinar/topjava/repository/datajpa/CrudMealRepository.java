package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

public interface CrudMealRepository extends JpaRepository<Meal, Integer> {

    @Transactional
    @Modifying
    @Query("delete from Meal mm where mm.id = ?1 and mm.user.id = ?2")
    int delete(int id, int userId);

    @Modifying
    @Query("select m from Meal m where m.id = ?1")
    List<Meal> getAllByUser(int id);

    @Modifying
    @Query("select m from Meal m where m.id = ?1 and m.user.id = ?2")
    Meal getByIdAndUser(int idMeal, int idUser);

    @Modifying
    @Query("select mm from Meal mm where mm.dateTime >= ?1 and mm.dateTime<= ?2 and mm.user.id = ?3")
    List<Meal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId);

}
