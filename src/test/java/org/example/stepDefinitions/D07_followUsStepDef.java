package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

public class D07_followUsStepDef {

    P03_homePage hp = new P03_homePage();

    @When("user press on facebook link")
    public void user_press_on_facebook_link() {
        WebDriverWait wait = new WebDriverWait(Hooks.d, Duration.ofSeconds(3));
        hp.socialLink("facebook");
        int initialWindowCount = Hooks.d.getWindowHandles().size();
        wait.until(ExpectedConditions.numberOfWindowsToBe(initialWindowCount));
        System.out.println("Tab count:"+initialWindowCount);
    }


    @Then("facebook link is opened in new tab")
    public void facebookLinkIsOpenedInNewTab() {
        ArrayList<String> tabs = new ArrayList<>(Hooks.d.getWindowHandles());
        Hooks.d.switchTo().window(tabs.get(1));
        Assert.assertEquals(Hooks.d.getCurrentUrl(), "https://www.facebook.com/nopCommerce", "URL assertion failed");
        Hooks.d.switchTo().window(tabs.get(0));
    }

    @When("user press on twitter link")
    public void userPressOnTwitterLink() {
        WebDriverWait wait = new WebDriverWait(Hooks.d, Duration.ofSeconds(3));
        hp.socialLink("twitter");
        int initialWindowCount = Hooks.d.getWindowHandles().size();
        wait.until(ExpectedConditions.numberOfWindowsToBe(initialWindowCount));
        System.out.println("Tab count:"+initialWindowCount);
    }

    @Then("twitter link is opened in new tab")
    public void twitterLinkIsOpenedInNewTab() {
        ArrayList<String> tabs = new ArrayList<>(Hooks.d.getWindowHandles());
        Hooks.d.switchTo().window(tabs.get(1));
        Assert.assertEquals(Hooks.d.getCurrentUrl(), "https://twitter.com/nopCommerce", "URL assertion failed");
        Hooks.d.switchTo().window(tabs.get(0));
    }

    @When("user press on rss link")
    public void userPressOnRssLink() {
        WebDriverWait wait = new WebDriverWait(Hooks.d, Duration.ofSeconds(3));
        hp.socialLink("rss");
        int initialWindowCount = Hooks.d.getWindowHandles().size();
        wait.until(ExpectedConditions.numberOfWindowsToBe(initialWindowCount));
        System.out.println("Tab count:"+initialWindowCount);
    }

    @Then("rss link is opened in new tab")
    public void rssLinkIsOpenedInNewTab() {
        Assert.assertEquals(Hooks.d.getCurrentUrl(), "https://demo.nopcommerce.com/news/rss/1", "URL assertion failed");
    }

    @When("user press on youtube link")
    public void userPressOnYoutubeLink() {
        WebDriverWait wait = new WebDriverWait(Hooks.d, Duration.ofSeconds(3));
        hp.socialLink("youtube");
        int initialWindowCount = Hooks.d.getWindowHandles().size();
        wait.until(ExpectedConditions.numberOfWindowsToBe(initialWindowCount));
        System.out.println("Tab count:"+initialWindowCount);
    }

    @Then("youtube link is opened in new tab")
    public void youtubeLinkIsOpenedInNewTab() {
        ArrayList<String> tabs = new ArrayList<>(Hooks.d.getWindowHandles());
        Hooks.d.switchTo().window(tabs.get(1));
        Assert.assertEquals(Hooks.d.getCurrentUrl(), "https://www.youtube.com/user/nopCommerce", "URL assertion failed");
        Hooks.d.switchTo().window(tabs.get(0));
    }
}

