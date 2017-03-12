package com.epam.pages;

import com.epam.framework.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Артур.
 */
public class SearchResultsPage extends AbstractPage {
    @FindBy(xpath = "//ul[@id='ListViewInner']/li[1]/h3/a")
    private WebElement firstResult;
    @FindBy(xpath = "//*[contains(@class,'tgl_button last_b')]")
    private WebElement buyNowButton;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage openFirstProduct() {
        buyNowButton.click();
        firstResult.click();
        return new ProductPage(driver);
    }
}
