package com.nopecommerce.pages;

import com.nopecommerce.seleniumdrivers.WebElementActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//input[@id='gender-male']")
    WebElement maleGender;
    @FindBy(xpath = "//input[@id='gender-female']")
    WebElement femaleGender;
    @FindBy(xpath = "//input[@id='FirstName']")
    WebElement firstNameInput;
    @FindBy(xpath = "//input[@id='LastName']")
    WebElement lastNameInput;
    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    WebElement dayOfBirthDDL;
    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    WebElement monthOfBirthDDL;
    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    WebElement yearOfBirthDDL;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void addValues(String gender, String firstName, String lastName, String dayDOB, String monthDOB, String yearDOB) throws Exception{

        switch (gender) {
            case "male", "Male", "MALE" ->
                    WebElementActions.clickOnElement(maleGender, "Select Male Gender Radio");
            case "female", "Female", "FEMALE" ->
                    WebElementActions.clickOnElement(femaleGender, "Select Male Gender Radio");
        }

        WebElementActions.enterInputIntoTextField(firstNameInput, firstName, "Enter input to First Name field on Register page");
        WebElementActions.enterInputIntoTextField(lastNameInput, lastName, "Enter input to Last Name field on Register page");


        WebElementActions.selectDropDownValue(dayOfBirthDDL, dayDOB, "Select a Day of the DOB");
        WebElementActions.selectDropDownValue(monthOfBirthDDL, monthDOB, "Select a Month of the DOB");
        WebElementActions.selectDropDownValue(yearOfBirthDDL, yearDOB, "Select a Year of the DOB");



    }




}
