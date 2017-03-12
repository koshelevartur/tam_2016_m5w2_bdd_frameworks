package com.epam.framework;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Артур.
 */
public class BaseTest {
    protected static WebDriver driver;
    private static final int IMPLICIT_WAIT_TIMEOUT = 5;

    public static void init() {
        driver = WebDriverCreator.getDriverInstance();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void close() {
        driver.close();
    }
}
