package com.ecommerce.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;


public class AddToWishlistStepDefinition {

    @Given("User navigates to Books category three")
    public void openBrowser3(){
        Hooks.driver.findElement(By.linkText("Books")).click();
    }
    @And("User selects First Prize Pies book three")
    public void selectBook(){
        Hooks.driver.findElement(By.linkText("First Prize Pies")).click();
    }
    @When("User clicks on wishlist")
    public void addToWishlist() throws InterruptedException {
        Hooks.driver.findElement(By.cssSelector("#add-to-wishlist-button-38")).click();
        Thread.sleep(1000);
    }
    @Then("Confirmation message appears that product has been added to wishlist")
    public void addToWishlistConfirmation(){
        Assert.assertEquals("The product has been added to your wishlist",Hooks.driver.findElement(By.cssSelector("#bar-notification > div > p")).getText());
    }
}
