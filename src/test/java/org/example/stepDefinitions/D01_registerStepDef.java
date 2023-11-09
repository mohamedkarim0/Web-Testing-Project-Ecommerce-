package org.example.stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class D01_registerStepDef {

    P01_register rp = new P01_register();
    @Given("user go to register page")
    public void goRegisterPage()
    {
        WebElement registerBtn = Hooks.d.findElement(By.cssSelector("a[href=\"/register?returnUrl=%2F\"]"));
        registerBtn.click();
        //rp.registerLink().click();
    }


    @When("user selects the gender {string}")
    public void userSelectsTheGender(String g) {
        rp.selectGender(g);
    }

    @And("user enters his first name {string} and last name {string}")
    public void userEntersHisFirstNameAndLastName(String firstname, String lastname) {
        rp.enterFirstName(firstname);
        rp.enterLastName(lastname);
    }

    @And("user enter his birth date day {string} month {string} year {string}")
    public void userEnterHisBirthDateDayMonthYear(String d, String m, String y) {
        rp.enterDateOfBirth(d,m,y);
    }

    @And("user enters his mail {string}")
    public void userEntersHisMail(String email) {
        rp.enterEmail(email);
    }

    @And("user enter company's name {string}")
    public void userEnterCompanySName(String company) {
        rp.enterCompany(company);
    }

    @And("user  wants unsubscribe to newsletters")
    public void userWantsUnsubscribeToNewsletters() {
        rp.unsubscribeNews();
    }

    @And("user enters and confirm his password {string}")
    public void userEntersAndConfirmHisPassword(String pass) {
        rp.enterPassword(pass);
    }

    @Then("registration complete")
    public void registrationComplete() {
        rp.pressRegisterButton();
        Assert.assertTrue(rp.registeredMessage().isDisplayed());
        String color = rp.registeredMessage().getCssValue("color");
        Assert.assertEquals(color,"rgba(76, 177, 124, 1)");
    }
}
