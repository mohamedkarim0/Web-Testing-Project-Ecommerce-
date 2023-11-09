package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.List;

public class D08_WishlistStepDef {

    SoftAssert sa = new SoftAssert();
    P03_homePage hp = new P03_homePage();
    @When("user click on wishlist button")
    public void user_click_on_wishlist_button() {
        List<WebElement> anchorElements = hp.wishListButton();
        anchorElements.get(2).click();
    }

    @Then("user added product to wishlist successfully")
    public void userAddedProductToWishlistSuccessfully() {

        WebDriverWait wait = new WebDriverWait(Hooks.d, Duration.ofSeconds(3));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bar-notification")));

        String bgColor = Hooks.d.findElement(By.className("bar-notification")).getCssValue("background-color");
        String hex = Color.fromString(bgColor).asHex();
        String qtyString = Hooks.d.findElement(By.className("bar-notification")).getCssValue("opacity");
        String qtyNum= qtyString.substring(1);
        int qtyValue = Integer.parseInt(qtyNum);


        sa.assertTrue(qtyValue > 0);
        sa.assertTrue(successMessage.isDisplayed());
        sa.assertEquals(hex, "#4bb07a");
        sa.assertAll();
    }


    @Then("user navigates to wishlist page")
    public void userNavigatesToWishlistPage() {
        WebDriverWait wait = new WebDriverWait(Hooks.d, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("bar-notification")));
        wait.until(ExpectedConditions.elementToBeClickable(By.className("ico-wishlist"))).click();

        String qtyString = Hooks.d.findElement(By.className("page-title")).getCssValue("min-height");
        String result = qtyString.replace("px", "").trim();
        int qtyValue = Integer.parseInt(result);

        String bgColor = Hooks.d.findElement(By.className("bar-notification")).getCssValue("background-color");
        String hex = Color.fromString(bgColor).asHex();

        sa.assertTrue(qtyValue > 0);
        sa.assertEquals(hex, "#4bb07a");
        sa.assertAll();

    }

}
