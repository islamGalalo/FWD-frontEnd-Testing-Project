package com.ecommerce.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;


public class SearchStepDefinition {

    @Given("User clicks on search bar")
    public void search(){
    Hooks.driver.findElement(By.cssSelector("#small-searchterms")).click();
    }
    @When("User enters name of a product")
    public void enterProductName(){
        Hooks.driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("Apple");
    }
    @And("User clicks on search button")
    public void clickSearch(){
        Hooks.driver.findElement(By.cssSelector("#small-search-box-form > button")).click();
    }
    @Then("User finds product")
    public void searchConfirm(){
        Assert.assertTrue(Hooks.driver.findElement(By.linkText("Apple MacBook Pro 13-inch")).isDisplayed());

    }
}
