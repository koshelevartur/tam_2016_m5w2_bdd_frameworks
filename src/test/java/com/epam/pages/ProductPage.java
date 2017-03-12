package com.epam.pages;

import com.epam.framework.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Артур.
 */
public class ProductPage extends AbstractPage {
    @FindBy(id = "isCartBtn_btn")
    private WebElement addToCartButton;

    ProductPage(WebDriver driver) {
        super(driver);
    }

    public CartPage addProductToCart() {
        addToCartButton.click();
        return new CartPage(driver);
    }
}
