package com.ecommerce.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;


public class AddToCompareListStepDefinition {

    @Given("User navigates to Books category two")
    public void openBrowser() {
     Hooks.driver.findElement(By.linkText("Books")).click();
    }
    @And("User selects First Prize Pies book two")
    public void selectBook(){
        Hooks.driver.findElement(By.linkText("First Prize Pies")).click();
    }
    @When("User clicks on add to compare list")
    public void addToCompare() throws InterruptedException {
        Hooks.driver.findElement(By.cssSelector("#product-details-form > div:nth-child(2) > div.product-essential > div.overview > div.overview-buttons > div.compare-products > button")).click();
        Thread.sleep(1000);
    }
    @Then("Confirmation message appears that product has been added to compare list")
    public void addToCompareListConfirmation(){
        Assert.assertEquals("The product has been added to your product comparison",Hooks.driver.findElement(By.cssSelector("#bar-notification > div > p")).getText());
    }
}
