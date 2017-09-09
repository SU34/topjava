package ru.javawebinar.topjava.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@NamedQueries({
        @NamedQuery(name = Meal.DELETE, query =
                "delete from Meal m where m.id = :id and m.user.id = :user_id"),
        @NamedQuery(name = Meal.GET_BY_ID_AND_USER, query =
                "select mm from Meal mm where mm.id = :id and mm.user.id = :user_id"),
        @NamedQuery(name = Meal.GET_ALL, query =
                "select mm from Meal mm where mm.user.id = :user_id order by mm.dateTime desc"),
        @NamedQuery(name = Meal.GET_BETWEEN_DATE_BY_USER, query =
                "select mm from Meal mm where mm.dateTime between :start_date and :end_date and mm.user.id = :user_id order by mm.dateTime desc"),
        @NamedQuery(name = Meal.DELETE_ALL, query =
                "delete from Meal mm where mm.user.id = :user_id")
})

@Entity
@Table(name = "meals")
public class Meal extends BaseEntity {

    public static final String DELETE = "Meals.del";
    public static final String GET_BY_ID_AND_USER = "Meals.getByIdAndUser";
    public static final String GET_ALL = "Meals.getAll";
    public static final String GET_BETWEEN_DATE_BY_USER = "Meals.betweenDateByUser";
    public static final String DELETE_ALL = "Meals.deleteAll";

    @Column(name = "date_time", nullable = false)
    @NotNull
    private LocalDateTime dateTime;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "calories")
    private int calories;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Meal() {
    }

    public Meal(LocalDateTime dateTime, String description, int calories) {
        this(null, dateTime, description, calories);
    }

    public Meal(Integer id, LocalDateTime dateTime, String description, int calories) {
        super(id);
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }

    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                '}';
    }
}
