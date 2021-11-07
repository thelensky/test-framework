package ru.thelensky.testframework.config;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.context.annotation.*;

import java.net.URL;

@Configuration
public class AppConfig {

    @Bean
    public JSONObject jsonObject() {
        return new JSONObject();
    }

//    @Lazy
//    @Bean
//    WebDriver configWebDriverChrome () throws Exception {
//        URL resource = ClassLoader.getSystemClassLoader().getResource("drivers/chromedriver.exe");
//        assert resource != null;
//        try {
//            System.setProperty("webdriver.chrome.driver", resource.getPath());
//        } catch (Exception e) {
//            throw new Exception("Driver not installed");
//        }
//        ChromeOptions options = new ChromeOptions();
//        return new ChromeDriver(options);
//    }

    @Lazy
    @Bean
    @Primary
    public WebDriver webDriverFirefox() throws Exception {
        URL resource = ClassLoader.getSystemClassLoader().getResource("drivers/geckodriver.exe");
        assert resource != null;
        try {
            System.setProperty("webdriver.gecko.driver", resource.getPath());
        } catch (Exception e) {
            throw new Exception("Driver not installed");
        }
        FirefoxOptions options = new FirefoxOptions();
        options.setLegacy(true);
        return new FirefoxDriver(options);
    }
}
