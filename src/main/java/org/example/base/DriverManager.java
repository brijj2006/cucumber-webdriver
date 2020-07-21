package org.example.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@PropertySource("classpath:config/config.properties")
public class DriverManager {

    private static final Logger logger = Logger.getLogger(DriverManager.class);
    private WebDriver driver;
    DesiredCapabilities capabilities;

    @Value("${browser.name}")
    private String browserName;
    @Value("${app.implicit.timeout.sec}")
    private String implicitTimeout;

    public WebDriver getDriverInstance() {

        if (driver == null) {
            switch (browserName.toUpperCase()) {
                case "CHROME":
                    System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver");
                    driver = new ChromeDriver();
                    break;
                case "FIREFOX":
                    System.setProperty("webdriver.gecko.driver", "./src/main/resources/drivers/geckodriver");
                    capabilities = DesiredCapabilities.firefox();
                    capabilities.setCapability("marionette", true);
                    driver = new FirefoxDriver(capabilities);
                    break;
                case "IEEXPLORER":
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(implicitTimeout), TimeUnit.SECONDS);
        }
        logger.info("Initializing the browser instance as : " + browserName);
        return driver;
    }

}