package ru.javawebinar.topjava.my_tests;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by evg_uh on 06.08.17.
 */
public class Test {
    private static AtomicInteger counter = new AtomicInteger();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(counter.incrementAndGet());
        }
    }
}
