package org.example.stepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver d = null;

    @Before
    public static void OpenBrowser() {
        System.setProperty("webDriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
        d = new ChromeDriver();
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        d.get("https://demo.nopcommerce.com/");
    }

    @After
    public static void quitDriver() throws InterruptedException
    { Thread.sleep(3000);
        d.quit();
    }

}
