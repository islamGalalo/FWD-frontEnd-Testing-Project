package com.ecommerce.StepDefinitions;

import com.ecommerce.Pages.LoginPageModel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;




public class LoginStepDefinition {
    LoginPageModel model;
    @Given("user navigates to login page")
    public void openBrowser() throws InterruptedException {
     Hooks.driver.findElement(By.linkText("Log in")).click();
        Thread.sleep(2000);

    }
    @When("user enter valid username and password and clicks the login button")
    public void enterValidData(){
       model= new LoginPageModel(Hooks.driver);
       model.loginSteps("test@test.com","123456789",Hooks.driver);
    }
    @Then("user login successfully")
    public void checkLogin(){

        Assert.assertEquals("Log out",Hooks.driver.findElement(By.linkText("Log out")).getText());

    }
}
