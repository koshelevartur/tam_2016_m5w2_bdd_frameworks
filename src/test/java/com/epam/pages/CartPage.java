package com.epam.pages;

import com.epam.framework.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

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

    private float totalSum = 0;
    private int productQuantity = 0;

    public CartPage(WebDriver driver) {
        super(driver);
        setProductQuantity();
        setTotalSum();
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
        System.out.println("---------------------");
        System.out.println(productName.getText());
        System.out.println(s);
        System.out.println("---------------------");
        return productName.getText().toLowerCase().contains(s.toLowerCase());
    }

    public float changingOfTotalSumAfterChanginQuantityByOne() {
        float totalSumBeforeChanging = totalSum;
        changeQuantityBy(1);
        float totalSumAfterChanging = totalSum;
        return (totalSumAfterChanging - totalSumBeforeChanging);
    }

    private void changeQuantityBy(int additionalProducts) {
        // #TODO Change Quantity Logic
    }

    public int getCurrentProductQuantity() {
        return productQuantity;
    }

    private void setTotalSum() {
        if (totalSumField.isDisplayed()) {
            totalSum = Float.parseFloat(totalSumField.getText());
        }
    }

    private void setProductQuantity() {
        if(productQuantityField.isDisplayed()) {
            productQuantity =  Integer.parseInt(productQuantityField.getAttribute("value"));
        }
    }


}
