package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;
import java.util.Random;

public class D05_hoverCategoriesStepDef {

    Random random = new Random();
    Actions action = new Actions(Hooks.d);
    P03_homePage homePage = new P03_homePage();

    @Given("user go to Main page")
    public void userGoToMainPage() {
    }



    @When("user selects random product category")
    public void userSelectsRandomProductCategory() {
        int count = homePage.productCategory().size();


        //int max = count-1;   // you are selecting random value from 0 to 2 that's why  max = count-1
        int selectedUser =  random.nextInt(count)-2;
        System.out.println(selectedUser);
        System.out.println("count: "+count);
        System.out.println(selectedUser);
        action.moveToElement(homePage.productCategory().get(selectedUser)).perform();

        List<WebElement> profileLinks = Hooks.d.findElements(By.cssSelector("a[href*=\"/electronics\"]"));
        profileLinks.get(selectedUser).click();
    }

    @Then("directs to products of that category")
    public void directsToProductsOfThatCategory() {
        WebElement categoryTitle = Hooks.d.findElement(By.className("page-title"));
        String titleText = categoryTitle.getText().toLowerCase().trim();

    }
}
