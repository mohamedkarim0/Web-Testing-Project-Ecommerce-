package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_login {

    public WebElement loginLink(){
        return Hooks.d.findElement(By.className("ico-login"));
    }

    public void enterEmail(String email){
        Hooks.d.findElement(By.id("Email")).sendKeys(email);
    }

    public void enterPassword(String pass){
        Hooks.d.findElement(By.id("Password")).sendKeys(pass);
    }

    public void pressLoginButton(){
        Hooks.d.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
    }

    public  WebElement myAccount()
    {
        return Hooks.d.findElement(By.className("ico-account"));
    }

    public WebElement unsuccessfulLogin(){
        return  Hooks.d.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]"));
    }
}
