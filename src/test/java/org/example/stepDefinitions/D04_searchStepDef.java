package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class D04_searchStepDef {

    SoftAssert sa = new SoftAssert();
    P03_homePage hp = new P03_homePage();

    @Given("user go to the home page")
    public void UserGoToTheHomePage(){
        
    }

    @When("user search a product as  a name {string}")
    public void userSearchAProductAsAName(String product) {
        hp.searchProduct(product);

        List<WebElement> listProductsDescription = Hooks.d.findElements(By.id("description"));
        for(int i =0 ; i <= listProductsDescription.size();i++)
        {
            String productDescription = listProductsDescription.get(i).getText().toLowerCase();
            product = product.toLowerCase();
            Assert.assertTrue(productDescription.contains(product));
        }
    }

    @Then("product is found")
    public void productIsFound() {
       sa.assertTrue(Hooks.d.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="));
        System.out.printf("numbers of result = %d",hp.listPrices().size());
        sa.assertAll();
    }


    @When("user search a product as sku {string}")
    public void userSearchAProductAsSku(String skuSearch) {
        hp.searchProduct(skuSearch);
    }

    @And("user select first result")
    public void userSelectFirstResult() {
        Hooks.d.findElement(By.className("product-item")).click();
    }

    @Then("selected product is found by sku")
    public void selectedProductIsFoundBySku() {
        String productSKU = Hooks.d.findElement(By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[4]/div[1]/span[2]")).getText();
        Assert.assertTrue(productSKU.contains("SCI_FAITH"));
    }

    @Then("selected product is found by {string}")
    public void selectedProductIsFoundBy(String searchSku) {
        String productSKU = Hooks.d.findElement(By.className("sku")).getText();
        Assert.assertTrue(productSKU.contains(searchSku));
    }
}
