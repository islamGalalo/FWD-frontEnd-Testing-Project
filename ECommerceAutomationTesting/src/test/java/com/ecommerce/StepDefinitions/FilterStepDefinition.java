package com.ecommerce.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;



public class FilterStepDefinition {

    @Given("User at Apparel category and shoes sub category")
    public void navigateToShoes(){
     Hooks.driver.navigate().to("https://demo.nopcommerce.com/shoes");
    }

    @When("User filters color to red")
    public void redFilter(){
        Hooks.driver.findElement(By.cssSelector("#attribute-option-15")).click();
    }

    @Then("User sees red shoes only")
    public void filterConfirmation(){
        Assert.assertTrue(Hooks.driver.findElement(By.linkText("adidas Consortium Campus 80s Running Shoes")).isDisplayed());

    }
}
