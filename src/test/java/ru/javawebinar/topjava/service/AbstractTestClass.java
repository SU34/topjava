package ru.javawebinar.topjava.service;

import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.rules.Stopwatch;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * Created by evg_uh on 15.09.17.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:spring/spring-app.xml","classpath:spring/spring-db.xml"})
public class AbstractTestClass {
    protected static Logger resultLog = LoggerFactory.getLogger("result");

    @Rule
    ExpectedException thrown = ExpectedException.none();

    protected static StringBuilder results = new StringBuilder();

    @Rule
    protected Stopwatch stopwatch = new Stopwatch() {
        @Override
        protected void finished(long nanos, Description description) {
            String result = String.format("%-25s %7d", description.getMethodName(), TimeUnit.MILLISECONDS.toMillis(nanos));
            results.append(result).append('\n');
            resultLog.info(result + " ms\n");
        }
    };

    static {
        // needed only for java.util.logging (postgres driver)
        SLF4JBridgeHandler.install();
    }

    @AfterClass
    public static void printResult() {
        resultLog.info("\n---------------------------------" +
                "\nTest                 Duration, ms" +
                "\n---------------------------------\n" +
                results +
                "---------------------------------\n");
    }

}
