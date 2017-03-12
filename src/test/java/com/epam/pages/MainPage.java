package com.epam.pages;

import com.epam.framework.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Артур.
 */
public class MainPage extends AbstractPage {
    @FindBy(id = "gh-ac")
    private WebElement searchField;
    @FindBy(id = "gh-btn")
    private WebElement searchButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage search(String searchRequest) {
        searchField.sendKeys(searchRequest);
        searchButton.click();
        return new SearchResultsPage(driver);
    }
}
