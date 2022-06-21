package com.ecommerce.StepDefinitions;

import com.ecommerce.Pages.ResetPasswordPageModel;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;


public class ResetPasswordStepDefinition {


    @Given("User navigates to login page")
    public void openBrowser() {
      Hooks.driver.findElement(By.linkText("Log in")).click();
    }
    @When("User Clicks on Forgot Password")
    public void clickForgotButton(){
        Hooks.driver.findElement(By.linkText("Forgot password?")).click();
    }
    @And("User enters his email address and clicks on recover")
    public void recoverySteps(){
        ResetPasswordPageModel model = new ResetPasswordPageModel(Hooks.driver);
        model.email().sendKeys("test@test.com");
        model.recoverButton().click();
    }
    @Then("A message appears that says \"Email with instructions has been sent to you.\"")
    public void recoverPassword(){
        Assert.assertEquals("Email with instructions has been sent to you.", Hooks.driver.findElement(By.cssSelector("#bar-notification > div > p")).getText());

    }

}
