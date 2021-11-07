package ru.thelensky.testframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.thelensky.testframework.util.UtilWebDriver;

@SpringBootApplication
public class TestFrameworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestFrameworkApplication.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(UtilWebDriver.class);
        UtilWebDriver util = context.getBean(UtilWebDriver.class);
        try {
            util.run();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

}
