package com.ecommerce.StepDefinitions;

import com.ecommerce.Pages.CheckoutPageModel;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;


public class OrderStepDefinition {

    CheckoutPageModel model;

    @Given("User navigates to shopping cart and shopping cart has items")
    public void navigateToShoppingCart() {

        Hooks.driver.findElement(By.linkText("Books")).click();
        Hooks.driver.findElement(By.linkText("First Prize Pies")).click();
        Hooks.driver.findElement(By.cssSelector("#add-to-cart-button-38")).click();
        Hooks.driver.findElement(By.linkText("Shopping cart")).click();

    }

    @And("User clicks on agree terms of service")
    public void agreeTerms() {
        Hooks.driver.findElement(By.cssSelector("#termsofservice")).click();
    }

    @When("User clicks on checkout button")
    public void checkout() {

        Hooks.driver.findElement(By.id("checkout")).click();
        Hooks.driver.findElement(By.linkText("Log in")).click();
        Hooks.driver.findElement(By.id("Email")).sendKeys("test@test.com");
        Hooks.driver.findElement(By.id("Password")).sendKeys("123456789");
        Hooks.driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div > div > div > div.page-body > div.customer-blocks > div.returning-wrapper.fieldset > form > div.buttons > button")).click();
        Hooks.driver.findElement(By.cssSelector("#termsofservice")).click();
        Hooks.driver.findElement(By.id("checkout")).click();
    }

    @And("Fills shipment and payment data")
    public void validData() throws InterruptedException {
        model = new CheckoutPageModel(Hooks.driver);
        model.firstName().sendKeys("Islam");
        model.lastName().sendKeys("Galal");
      //  model.email().sendKeys("test@test.com");
        model.address1().sendKeys("test");
        model.country().sendKeys("Egypt");
        model.city().sendKeys("test");
        model.zipCode().sendKeys("test");
        model.phoneNumber().sendKeys("test");
        Thread.sleep(2000);
        model.continueButton1().click();
        Thread.sleep(2000);
        Hooks.driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        model.continueButton2().click();
        Thread.sleep(2000);
        model.continueButton3().click();
        Thread.sleep(2000);
        model.continueButton4().click();
        Thread.sleep(2000);
    }

    @And("Clicks on confirm button")
    public void confirmOrder() throws InterruptedException {
        Hooks.driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        model.confirmButton().click();
        Thread.sleep(2000);
    }

    @Then("Order Success Message Appears")
   public void confirmationMessage() {
       Assert.assertEquals("Your order has been successfully processed!", Hooks.driver.findElement(By.linkText("Your order has been successfully processed!")).getText());
   }


}
