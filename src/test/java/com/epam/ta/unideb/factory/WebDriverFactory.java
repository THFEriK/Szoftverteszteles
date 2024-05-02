package com.epam.ta.unideb.factory;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Component
public class WebDriverFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger((WebDriverFactory.class));

    public static WebDriver webDriver;

    public static WebDriver getInstance() {
        if (webDriver == null) {
            webDriver = setUpChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
        return webDriver;
    }

    private static WebDriver setUpChromeDriver() {
        WebDriverManager.chromedriver().setup();

        LOGGER.info("ChromeDriver was created");
        return new ChromeDriver(
                new ChromeOptions()
                        .addArguments("--remote-allow-origins=*")
                        .addArguments("--no-sandbox")
                        .addArguments("--disable-dev-shm-usage")
        );
    }

    public void closeWebDriver() {
        if(Objects.nonNull(webDriver)){
            webDriver.close();
            webDriver.quit();
            webDriver = null;
            LOGGER.info("WebDriver has been closed");
        }
    }
}
