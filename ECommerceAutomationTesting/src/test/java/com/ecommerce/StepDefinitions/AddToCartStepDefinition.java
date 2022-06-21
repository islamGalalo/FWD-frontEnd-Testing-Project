package com.ecommerce.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;


public class AddToCartStepDefinition {
    @Given("User navigates to Books category one")
    public void openBrowser1() {

        Hooks.driver.findElement(By.linkText("Books")).click();
    }
    @And("User selects First Prize Pies book one")
    public void selectBook(){
        Hooks.driver.findElement(By.linkText("First Prize Pies")).click();
    }
    @When("User clicks on add to cart")
    public void addToCart() throws InterruptedException {
        Hooks.driver.findElement(By.cssSelector("#add-to-cart-button-38")).click();
        Thread.sleep(1000);
    }
    @Then("Confirmation message appears that product has been added to shopping car")
    public void addToCartConfirmation(){
        Assert.assertEquals("(1)",Hooks.driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[2]")).getText());

    }

}
