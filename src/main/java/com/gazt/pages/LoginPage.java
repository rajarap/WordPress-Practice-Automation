package com.gazt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gazt.testbase.TestBase;

public class LoginPage extends TestBase
{
	//Page Factory - OR
	@FindBy(xpath="//a[@class='masterbar__item masterbar__item-logo']")
	WebElement wordpresslogin_logo;
	
	@FindBy(xpath="//a[@class='masterbar__item']")
	WebElement signup_lnk;
	
	@FindBy(xpath="//div[@class='login__form-header']")
	WebElement loginaccount_header;
	
	@FindBy(xpath="//input[@id='usernameOrEmail']")
	WebElement email_txtbox;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement continue_btn;
	
	@FindBy(xpath="//button[@class='social-buttons__button button']")
	WebElement google_btn;
	
	@FindBy(xpath="//a[text()='Email me a login link']")
	WebElement email_lnk;
	
	@FindBy(xpath="//a[text()='Lost your password?']")
	WebElement forgotpwd_lnk;
	
	@FindBy(xpath="//a[text()='Back to WordPress.com']")
	WebElement backtohomepage_lnk;
	
	//Initializing Page Objects
	public LoginPage()
	{
		PageFactory.initElements(TestBase.driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle()
	{
		return TestBase.driver.getTitle();
	}
	
	public boolean validateLogo()
	{
		return wordpresslogin_logo.isDisplayed();
	}
	
	public boolean validateSignUpLink()
	{
		return signup_lnk.isDisplayed();
	}
	
	public boolean validateLoginAccountHeader()
	{
		return loginaccount_header.isDisplayed();
	}
	
	public boolean validateEmailAddressTextBox()
	{
		return email_txtbox.isDisplayed();
	}
	
	public boolean validateContinueButton()
	{
		return continue_btn.isDisplayed();
	}
	
	public boolean validateGoogleContinueButton()
	{
		return google_btn.isDisplayed();
	}
	
	public boolean validateEmailMeLink()
	{
		return email_lnk.isDisplayed();
	}
	
	public boolean validateLostYourPassword()
	{
		return forgotpwd_lnk.isDisplayed();
	}
	
	public boolean validateBackToHomePageLink()
	{
		return backtohomepage_lnk.isDisplayed();
	}
	
	public HomePage goBackToHomePageLink()
	{
		backtohomepage_lnk.click();
		return new HomePage();
	}
	
	public boolean validateUserNameTextBox()
	{
		return email_lnk.isDisplayed();
	}
	
	public void enterUserName(String username)
	{
		email_txtbox.sendKeys(username);
	
	}
	
	public LoginPasswordPage clickContinueButton()
	{
		continue_btn.click();
		return new LoginPasswordPage();
	}

}
