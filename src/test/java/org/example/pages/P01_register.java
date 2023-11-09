package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class P01_register {

    public void selectGender(String gender)
    {
        if(gender.matches("male"))
            Hooks.d.findElement(By.id("gender-male")).click();
        if(gender.matches("female"))
            Hooks.d.findElement(By.id("gender-female")).click();
    }
    public void enterFirstName(String firstname)
    {
        Hooks.d.findElement(By.id("FirstName")).sendKeys(firstname);
    }

    public void enterLastName(String lastname)
    {
        Hooks.d.findElement(By.id("LastName")).sendKeys(lastname);
    }

    public void enterDateOfBirth(String d, String m, String y)
    {
        Select sDay = new Select(Hooks.d.findElement(By.name("DateOfBirthDay")));
        Select sMonth = new  Select(Hooks.d.findElement(By.name("DateOfBirthMonth")));
        Select sYear = new  Select(Hooks.d.findElement(By.name("DateOfBirthYear")));
        sDay.selectByValue(d);
        sMonth.selectByValue(m);
        sYear.selectByValue(y);
    }
    public void enterEmail(String email)
    {
        Hooks.d.findElement(By.id("Email")).sendKeys(email);
        // testBase.d.findElement(By.id("ConfirmEmail")).sendKeys(email);
    }

    public void enterCompany(String companyName)
    {
        Hooks.d.findElement(By.id("Company")).sendKeys(companyName);
    }

    public void unsubscribeNews()
    {
        Hooks.d.findElement(By.id("Newsletter")).click();
    }

    public void enterPassword(String pass)
    {
        Hooks.d.findElement(By.id("Password")).sendKeys(pass);
        Hooks.d.findElement(By.id("ConfirmPassword")).sendKeys(pass);
    }

    public  void pressRegisterButton()
    {
        Hooks.d.findElement(By.id("register-button")).click();
    }


    public WebElement registeredMessage()
    {
        return Hooks.d.findElement(By.className("result"));
    }
}
