package com.gazt.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import com.gazt.pages.HomePage;
import com.gazt.pages.LoginPage;
import com.gazt.pages.RegisterPage;
import com.gazt.testbase.TestBase;

public class HomePageTest extends TestBase
{
	HomePage homepage;
	LoginPage loginpage;
	RegisterPage registerpage;
	
	Logger log = Logger.getLogger(HomePageTest.class);
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeClass
	public void setUp()
	{
		log.info("Invoking Parent class initialize method from setUp()");
		initialize();
		homepage = new HomePage();
	}
	
	@Test(priority=1)
	public void homePageTitleTest()
	{
		log.info("Verifying Home Page Title");
		String homepagetitle = homepage.validateHomePageTitle();
		Assert.assertEquals(homepagetitle, "WordPress.com: Create a Free Website or Blog");
	}
	
	@Test(priority=2)
	public void wordPressLogoTest()
	{
		log.info("Verifying WordPress Logo");
		boolean flag = homepage.validateWordPressImage();
		Assert.assertTrue(flag, "WordPress logo is not displayed on the HomePage");
	}
	
	@Test(priority=3)
	public void productLinkTest()
	{
		log.info("Verifying if Product Link is displayed on Home Page");
		boolean flag = homepage.validateProductLink();
		Assert.assertTrue(flag, "Product Link is displayed on the HomePage");
	}
	
	@Test(priority=4)
	public void featureLinkTest()
	{
		log.info("Verifying if Feature Link is displayed on Home Page");
		boolean flag = homepage.validateFeaturesLink();
		Assert.assertTrue(flag, "Feature Link is displayed on the HomePage");
	}
	
	@Test(priority=5)
	public void resourcesLinkTest()
	{
		log.info("Verifying if Resource Link is displayed on Home Page");
		boolean flag = homepage.validateResourcesLink();
		Assert.assertTrue(flag, "Resources Link is displayed on the HomePage");
	}
	
	@Test(priority=6)
	public void plansAndPricingTest()
	{
		log.info("Verifying if Plans and Pricing Link is displayed on Home Page");
		boolean flag = homepage.validatePlansandPricingLink();
		Assert.assertTrue(flag, "Plans and Pricing Link is displayed on the HomePage");
	}
	
	@Test(priority=7)
	public void loginLinkClick()
	{
		log.info("Verifying if Login Page is displayed by clicking Log In link from Home Page");
		loginpage = homepage.login();
		TestBase.driver.navigate().back();
	}
	
	@Test(priority=8)
	public void getStartedLinkClick()
	{	
		log.info("Verifying if Registration Page is displayed by clicking the Getting Started link from Home Page");
		registerpage = homepage.registerByGetStartedLink();
		TestBase.driver.navigate().back();
	}
	
	@Test(priority=9)
	public void startYourWebsiteButtonClick()
	{
		log.info("Verifying if Registration Page is displayed by clicking Start your Websire button from Home Page");
		registerpage = homepage.registerByStartYourWebsiteButton();
	}
	
	@AfterClass
	public void tearDown()
	{
		log.info("Closing driver object");
		TestBase.driver.close();
		homepage = null;
		loginpage = null;
		registerpage = null;
	}
}
