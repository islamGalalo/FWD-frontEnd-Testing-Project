package com.ecommerce.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;


public class CurrencyStepDefinition {

     @Given("User clicks on drop list")
    public void dropListClick(){

         Hooks.driver.findElement(By.cssSelector("#customerCurrency")).click();
     }

     @When("User clicks on Euro")
    public void selectEuro(){
         Hooks.driver.findElement(By.cssSelector("#customerCurrency > option:nth-child(2)")).click();
     }
     @Then("User find the price of products in Euro")
    public void currencyConfirmation(){
      Hooks.driver.navigate().to("https://demo.nopcommerce.com/desktops");
         Assert.assertTrue(Hooks.driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div > div.center-2 > div > div.page-body > div.products-container > div.products-wrapper > div > div > div:nth-child(1) > div > div.details > div.add-info > div.prices > span")).getText().contains("€"));

     }
}
