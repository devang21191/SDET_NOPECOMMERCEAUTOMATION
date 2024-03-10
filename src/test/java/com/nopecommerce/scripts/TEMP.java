package com.nopecommerce.scripts;

import com.nopecommerce.datadrivers.ReadPropertyFile;
import com.nopecommerce.pages.HomePage;
import com.nopecommerce.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TEMP {

    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = BaseTest.lauchBrowser("chrome", ReadPropertyFile.readData("url"));

//        driver = new ChromeDriver();
//        driver.get("https://demo.nopcommerce.com/");
    }

    @Test(priority = 0)
    public void addvalues() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.addValues("male", "Devang", "Sheth", "21", "January", "1991");
        Assert.assertEquals(driver.getCurrentUrl(), "www.google.com");

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
//        driver.quit();
    }
}
