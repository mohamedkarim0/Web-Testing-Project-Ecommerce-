package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {
    SoftAssert sa = new SoftAssert();
    P02_login lp = new P02_login();


    @Given("user go to login page")
    public void userGoToLoginPage() {
        lp.loginLink().click();
    }

    @When("user login with valid {string} and {string}")
    public void userLoginWithValidAnd(String email, String pass) {
        lp.enterEmail(email);
        lp.enterPassword(pass);
    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        lp.pressLoginButton();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        sa.assertEquals(Hooks.d.getCurrentUrl(),"https://demo.nopcommerce.com/");
        sa.assertTrue(lp.myAccount().isDisplayed());
        sa.assertAll();
    }

    @When("user login with invalid {string} and {string}")
    public void userLoginWithInvalidAnd(String email, String pass) {
        lp.enterEmail(email);
        lp.enterPassword(pass);
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
       sa.assertTrue(lp.unsuccessfulLogin().getText().contains("Login was unsuccessful."));
        String color = lp.unsuccessfulLogin().getCssValue("color");
        Assert.assertEquals(color,"rgba(228, 67, 75, 1)");
        sa.assertAll();

    }
}
