package com.gazt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gazt.testbase.TestBase;

public class HomePage extends TestBase
{
	//Page Factory - OR
	@FindBy(xpath="//ul[@class='x-nav-list']//li//a[@title='Log In' and @role='menuitem']")
	WebElement logIn_lnk;
	
	@FindBy(xpath="//a[@role='menuitem']/span[text()='WordPress.com']")
	WebElement wordpress_logo;
	
	@FindBy(xpath="//button[@role='menuitem' and @data-dropdown-trigger='products']")
	WebElement product_lnk;
	
	@FindBy(xpath="//a[@title='Features' and @data-dropdown-trigger='features']")
	WebElement features_lnk;
	
	@FindBy(xpath="//button[@role='menuitem' and @data-dropdown-trigger='resources']")
	WebElement resources_lnk;
	
	@FindBy(xpath="//li[@class='x-nav-item x-nav-item--wide']//a[@role='menuitem' and @title='Plans & Pricing']")
	WebElement plansandpricing_lnk;
	
	@FindBy(xpath="//a[@role='menuitem' and @title='Get Started']")
	WebElement getstarted_lnk;
	
	@FindBy(xpath="//a[@id='hero-cta']")
	WebElement startyouwebsite_btn;
	
	//Initializing Page Objects
	public HomePage()
	{
		PageFactory.initElements(TestBase.driver, this);
	}
	
	//Actions
	public String validateHomePageTitle()
	{
		return TestBase.driver.getTitle();
	}
	
	public boolean validateWordPressImage()
	{
		return wordpress_logo.isDisplayed();
	}
	
	public boolean validateProductLink()
	{
		return product_lnk.isDisplayed();
	}
	
	public boolean validateFeaturesLink()
	{
		return features_lnk.isDisplayed();
	}
	
	public boolean validateResourcesLink()
	{
		return resources_lnk.isDisplayed();
	}
	
	public boolean validatePlansandPricingLink()
	{
		return plansandpricing_lnk.isDisplayed();
	}
	
	public boolean validateGetStartedLink()
	{
		return getstarted_lnk.isDisplayed();
	}
	
	public boolean validateLogInLink()
	{
		return logIn_lnk.isDisplayed();
	}	
	
	public LoginPage login()
	{
		logIn_lnk.click();
		return new LoginPage();
	}
	
	public RegisterPage registerByGetStartedLink()
	{
		getstarted_lnk.click();
		return new RegisterPage();
	}
	
	public RegisterPage registerByStartYourWebsiteButton()
	{
		startyouwebsite_btn.click();
		return new RegisterPage();
	}
	
}
