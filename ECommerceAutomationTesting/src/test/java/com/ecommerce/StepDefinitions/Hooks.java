package com.ecommerce.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class Hooks {


   static WebDriver driver;
    @Before
    public static void open_browser(){

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
    }

    @After
    public static void  Close_browser(){

        driver.quit();
    }

}
