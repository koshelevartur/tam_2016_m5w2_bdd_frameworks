package com.epam.pages;

import com.epam.framework.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Артур.
 */
public class CartPage extends AbstractPage {
    @FindBys(@FindBy(xpath = "//a[contains(@class,'actionLink')]"))
    private List<WebElement> deleteButtons;
    @FindBy(id = "empty-sc")
    private WebElement emptyCartMsg;
    @FindBy(xpath = "//a[contains(@id,'_title')]")
    private WebElement productName;
    @FindBy(xpath = "//input[contains(@id,'qty_')]")
    private WebElement productQuantityField;
    @FindBy(id = "asyncTotal")
    private WebElement totalSumField;
    @FindBy(xpath = "//a[contains(@id,'ul_')]")
    private WebElement refreshButton;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage openCartPage() {
        driver.get("https://cart.payments.ebay.com/sc/view");
        return new CartPage(driver);
    }

    public void deleteCartItems() {
        while (deleteButtons.size() > 0) {
            deleteButtons.get(0).click();
            openCartPage();
        }
    }

    public boolean isCartEmpty(){
        try {
            return emptyCartMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean productNameContains(String s) {
        return productName.getText().toLowerCase().contains(s.toLowerCase());
    }

    public CartPage changeQuantityBy(int quantityDif) {
        int newQuantity = Integer.parseInt(productQuantityField.getAttribute("value")) + quantityDif;
        productQuantityField.clear();
        productQuantityField.sendKeys(String.valueOf(newQuantity));
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(refreshButton));
        refreshButton.click();
        return new CartPage(driver);
    }

    public int getCurrentProductQuantity() {
        return Integer.parseInt(productQuantityField.getAttribute("value"));
    }

    public float getTotalSum() {
        return Float.parseFloat(totalSumField.getText().replace(',', '.').replaceAll("[^\\d.]+|\\.(?!\\d)", ""));
    }
}
