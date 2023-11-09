package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class D03_currenciesStepDef {

    P03_homePage hp = new P03_homePage();
    SoftAssert sa = new SoftAssert();
    @Given("user go to home page")
    public void userGoToHomePage() {
    }

    @When("user selects {string} currency")
    public void userSelectsCurrency(String money) {
        hp.selectCurrency(money);

    }

    @Then("currency is updated successfully")
    public void currencyIsUpdatedSuccessfully() {
        List<WebElement> productCurrency = hp.listPrices();

        for (int i = 0; i < 3; i++) {
            String product = productCurrency.get(i).getText();
            Assert.assertTrue(product.contains("€"), "Euro symbol (€) is not found in product " + (i + 1));
        }
        sa.assertAll();
    }


}
