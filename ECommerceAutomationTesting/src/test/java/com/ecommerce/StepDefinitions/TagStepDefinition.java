package com.ecommerce.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;


public class TagStepDefinition {

    @Given("User navigates to electronics category")
    public void electronicsCategory(){
      Hooks.driver.navigate().to("https://demo.nopcommerce.com/electronics");
        Hooks.driver.findElement(By.cssSelector("#small-searchterms")).click();

    }
    @When("User selects camera tag")
    public void tagSelection(){
        Hooks.driver.findElement(By.linkText("camera")).click();
    }
    @Then("User finds cameras products")
    public void tagConfirmation(){
        Assert.assertTrue(Hooks.driver.findElement(By.linkText("Nikon D5500 DSLR")).isDisplayed());

    }
}
