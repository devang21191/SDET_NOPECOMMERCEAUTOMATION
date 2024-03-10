package com.nopecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nopecommerce.seleniumdrivers.WebElementActions;

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(id = "Email")
	private WebElement emailTxt;
	
	@FindBy(name = "Password")
	private WebElement passwordTxt;
	
	@FindBy(xpath = "//button[text()='Log in']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//div[@class = 'message-error validation-summary-errors']")
	public WebElement errorMsg;
	
	@FindBy(xpath = "//a[text()='Forgot password?']")
	private WebElement forgotPasswordLnk;
	
	@FindBy(xpath = "send-email")
	private WebElement recorverBtn;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public void loginToApp(String email, String password) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(emailTxt));
		WebElementActions.enterInputIntoTextField(emailTxt, email, "Enter input to email field on login page");
		WebElementActions.enterInputIntoTextField(passwordTxt, password, "Enter input to password field on login page");
		WebElementActions.clickOnElement(loginBtn, "Click on login button on login page");
	}
	
	public void recoverCredentails(String email) {
		WebElementActions.clickOnElement(forgotPasswordLnk, "forgot password link on login page");
		WebElementActions.enterInputIntoTextField(emailTxt, email, "Enter recovery email in login page");
		WebElementActions.clickOnElement(recorverBtn, "click on recover button in login page");
	}

}
