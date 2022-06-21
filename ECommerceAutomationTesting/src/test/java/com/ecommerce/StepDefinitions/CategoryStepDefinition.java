package com.ecommerce.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

public class CategoryStepDefinition {
    Actions actions;
    WebElement element;

    @Given("User hovers on computers category")
    public void openBrowser() throws InterruptedException {

        actions = new Actions(Hooks.driver);
        element = Hooks.driver.findElement(By.linkText("Computers"));
        actions.moveToElement(element).build().perform();
        Thread.sleep(2000);
    }

    @When("User selects Desktop item category")
    public void selectDesktop() {
        actions.moveToElement(Hooks.driver.findElement(By.linkText("Desktops"))).click().build().perform();
    }

    @Then("User finds Desktop products")
    public void categoryConfirmation() {
        Assert.assertTrue(Hooks.driver.findElement(By.linkText("Build your own computer")).isDisplayed());

    }

}
