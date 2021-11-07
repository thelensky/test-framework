package ru.thelensky.testframework.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import ru.thelensky.testframework.config.AppConfig;

import java.util.Timer;
import java.util.TimerTask;

@Service
public class UtilWebDriver {

    public void run() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        final WebDriver driver = context.getBean(WebDriver.class);
        driver.get("https://yandex.ru");
        driver.findElement(By.id("text")).sendKeys("hello world");
        driver.findElement(By.tagName("form")).submit();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                driver.close();
                System.exit(0);
            }
        }, 5000);
    }
}
