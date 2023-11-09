package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class P03_homePage {


    public void selectCurrency(String money){
        Select currency = new Select(Hooks.d.findElement(By.name("customerCurrency")));
        currency.selectByVisibleText(money);
    }

    public void searchProduct(String p){
        Hooks.d.findElement(By.id("small-searchterms")).sendKeys(p);
        Hooks.d.findElement(By.id("small-searchterms")).submit();
        // Hooks.d.findElement(By.xpath("//body/div[6]/div[1]/div[2]/div[2]/form[1]/button[1]")).click();
    }

    public List<WebElement> listPrices(){
        return Hooks.d.findElements(By.className("prices"));

    }


    public List<WebElement> productCategory(){
        return Hooks.d.findElements(By.className("item-box"));
    }

    public List<WebElement> listHomeSlider(){
        return Hooks.d.findElements(By.className("nivoSlider"));
    }

    public void socialLink(String link){
        Hooks.d.findElement(By.className(link)).click();
    }

    public List<WebElement> wishListButton(){
        return Hooks.d.findElements(By.className("buttons"));
    }






}
