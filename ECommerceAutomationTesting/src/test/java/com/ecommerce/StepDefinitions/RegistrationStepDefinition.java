package com.ecommerce.StepDefinitions;

import com.ecommerce.Pages.RegistrationPageModel;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class RegistrationStepDefinition {

    RegistrationPageModel model;

    @Given("User navigates to register page")
    public void openBrowser() {
        Hooks.driver.findElement(By.linkText("Register")).click();
        model = new RegistrationPageModel(Hooks.driver);
    }

    @When("User enters first name and last name")
    public void enterName() {
        model.firstName().sendKeys("test");
     model.lastName().sendKeys("test");
    }

    @And("User enters email")
    public void enterEmail() {
        model.email().sendKeys("test@test.com");
    }

    @And("User enters password")
    public void enterPassword() {
        model.password().sendKeys("123456789");
    }

    @And("User confirms password and clicks register button")
    public void confirmPassword() {
        model.confirmPassword().sendKeys("123456789");
        model.registerButton().click();
    }

    @Then("User registers successfully")
    public void registeredSuccessfully() {
        Assert.assertTrue(Hooks.driver.findElement(By.linkText("Log out")).isDisplayed());

    }
}
