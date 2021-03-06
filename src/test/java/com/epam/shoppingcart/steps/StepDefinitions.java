package com.epam.shoppingcart.steps;

import com.epam.framework.BaseTest;
import com.epam.framework.CartState;
import com.epam.pages.CartPage;
import com.epam.pages.MainPage;
import com.epam.pages.SearchResultsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by Артур.
 */
public class StepDefinitions extends BaseTest {
    @Given("^I perform search of \"([^\"]*)\"$")
    public void iPerformSearchOf(String searchRequest) {
        driver.get("http://www.ebay.com/");
        new MainPage(driver).search(searchRequest);
    }

    @Given("^I open cart page$")
    public void iOpenCartPage() {
        new CartPage(driver).openCartPage();
    }

    @And("^Cart is not empty$")
    public void cartNotEmpty() {
        Assert.assertFalse(new CartPage(driver).isCartEmpty());
    }

    @And("^Quantity of product is more then (\\d+)$")
    public void productQuantityMoreThenOne(int value) {
        Assert.assertTrue(new CartPage(driver).getCurrentProductQuantity() > value);
    }

    @When("^I add first product to the cart$")
    public void iAddOpenedProductToCart() {
        new SearchResultsPage(driver).openFirstProduct().addProductToCart();
    }

    @When("^I delete all products from cart$")
    public void iDeleteAllItemsFromCart() {
        new CartPage(driver).deleteCartItems();
    }

    @When("^I increase quantity of product by (\\d+)$")
    public void iIncreaseQuantityOfProductBy(int value) {
        CartPage cartPage = new CartPage(driver);
        CartState.getInstance().setTotalSum(cartPage.getTotalSum());
        cartPage.changeQuantityBy(value);
    }

    @When("^I decrease quantity of product by (\\d+)$")
    public void iDecreaseQuantityOfProductBy(int value) {
        CartPage cartPage = new CartPage(driver);
        CartState.getInstance().setTotalSum(cartPage.getTotalSum());
        new CartPage(driver).changeQuantityBy(value * (-1));
    }

    @Then("^Cart page should open$")
    public void cartPageIsOpened() {
        Assert.assertTrue(driver.getCurrentUrl().contains("http://cart.payments.ebay.com"));
    }

    @Then("^Cart is empty$")
    public void cartIsEmpty() {
        Assert.assertTrue(new CartPage(driver).isCartEmpty());
    }

    @Then("^\"([^\"]*)\" is in the cart$")
    public void productIsInTheCart(String productName) {
        Assert.assertTrue(new CartPage(driver).productNameContains(productName));
    }

    @Then("^Cost should grow$")
    public void costShouldGrow() {
        Assert.assertTrue(new CartPage(driver).getTotalSum() - CartState.getInstance().getTotalSum() > 0);
    }

    @Then("^Cost should fall$")
    public void costShouldFall() {
        Assert.assertTrue(new CartPage(driver).getTotalSum() - CartState.getInstance().getTotalSum() < 0);
    }
}
