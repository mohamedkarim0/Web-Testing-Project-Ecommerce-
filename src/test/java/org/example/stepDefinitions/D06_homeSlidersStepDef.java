package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class D06_homeSlidersStepDef {
    P03_homePage hp = new P03_homePage();
    WebDriverWait wait = new WebDriverWait(Hooks.d, Duration.ofSeconds(4));
    @Given("user go to slider in home page")
    public void userGoToSliderInHomePage() {
    }

    @When("click on first slider Iphone pro")
    public void clickOnFirstSliderIphonePro() {
        List<WebElement> anchorElements = hp.listHomeSlider();
        anchorElements.get(0).click();
    }

    @Then("it directs to Iphone pro product page")
    public void itDirectsToIphoneProProductPage() {
        wait.until(ExpectedConditions.urlContains("https://demo.nopcommerce.com/nokia-lumia-1020"));
        Assert.assertEquals("https://demo.nopcommerce.com/iphone-6",Hooks.d.getCurrentUrl());
       //assert Hooks.d.getCurrentUrl().equals("https://demo.nopcommerce.com/nokia-lumia-1020") : "URL assertion failed";
    }




    @When("click on second slider Galaxy ultra")
    public void clickOnSecondSliderGalaxyUltra() {
        List<WebElement> anchorElements = hp.listHomeSlider();
        anchorElements.get(0).click();
    }

    @Then("it directs to Galaxy ultra product page")
    public void itDirectsToGalaxyUltraProductPage() {
        Assert.assertEquals("https://demo.nopcommerce.com/nokia-lumia-1020",Hooks.d.getCurrentUrl());
        //assert Hooks.d.getCurrentUrl().equals("https://demo.nopcommerce.com/nokia-lumia-1020") : "URL assertion failed";
    }


}
