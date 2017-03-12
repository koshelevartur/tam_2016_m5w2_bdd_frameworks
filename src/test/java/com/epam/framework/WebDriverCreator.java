package com.epam.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Артур.
 */
class WebDriverCreator {
    private static WebDriver driver;

    private WebDriverCreator() {
    }

    static WebDriver getDriverInstance(){
        if(driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }
}
