package com.epam.shoppingcart;

import com.epam.framework.BaseTest;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created by Артур.
 */

@CucumberOptions(features = "src/test/resources/features/shopping_cart.feature",
        glue = "com.epam.shoppingcart.steps",
        format = {"pretty"},
        strict = true)

public class Runner extends AbstractTestNGCucumberTests {
    @BeforeTest
    public static void setUp() {
        BaseTest.init();
    }

    @AfterTest
    public static void tearDown() {
        BaseTest.close();
    }
}
