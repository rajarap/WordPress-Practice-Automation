package com.gazt.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import com.gazt.pages.HomePage;
import com.gazt.pages.LoginPage;
import com.gazt.pages.LoginPasswordPage;
import com.gazt.testbase.TestBase;

public class LoginPageTest extends TestBase
{
	HomePage homepage;
	LoginPage loginpage;
	LoginPasswordPage loginpasswordpage;
	
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeClass
	public void setUp()
	{
		log.info("Invoking TestBase initialize method from setUp() from Login Page Test");
		initialize();
		homepage = new HomePage();
		loginpage = new LoginPage();
		loginpage = homepage.login();
	}
	
	@AfterClass
	public void tearDown()
	{
		log.info("Closing LoginPageTest driver window");
		driver.close();
		homepage = null;
		loginpage = null;
		loginpasswordpage = null;
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		log.info("Verifying Login Page Title");
		String loginpagetitle = loginpage.validateLoginPageTitle();
		Assert.assertEquals(loginpagetitle, "Log In - WordPress.com");
	}
	
	@Test(priority=2)
	public void loginPageWPLogoTest()
	{
		log.info("Verifying WordPress Logo on Login Page");
		boolean flag = loginpage.validateLogo();
		Assert.assertTrue(flag, "WordPress logo is not displayed on the LoginPage");
	}
	
	@Test(priority=3)
	public void signUpLinkTest()
	{
		log.info("Verifying Sign Up Link on Login Page");
		boolean flag = loginpage.validateSignUpLink();
		Assert.assertTrue(flag, "Sign Up link is not displayed on the LoginPage");
	}
	
	@Test(priority=4)
	public void loginAccountHeaderTest()
	{
		log.info("Verifying Login Account Header text on Login Page");
		boolean flag = loginpage.validateLoginAccountHeader();
		Assert.assertTrue(flag, "Login Account Header Text is not displayed on the LoginPage");
	}
	
	@Test(priority=5)
	public void emailAdressTest()
	{
		log.info("Validating username in the Login Page");
		boolean flag = loginpage.validateUserNameTextBox();
		Assert.assertTrue(flag, "Login Username Text Box is not displayed on the LoginPage");
	}
	
	@Test(priority=6)
	public void continueButton()
	{
		log.info("Validating continue button in the Login Page");
		boolean flag = loginpage.validateContinueButton();
		Assert.assertTrue(flag, "Continue button is not displayed on the LoginPage");
	}
	
	@Test(priority=7)
	public void continueGoogleButton()
	{
		log.info("Validating continue google button in the Login Page");
		boolean flag = loginpage.validateGoogleContinueButton();
		Assert.assertTrue(flag, "Google Continue button is not displayed on the LoginPage");
	}
	
	@Test(priority=7)
	public void emailMeLink()
	{
		log.info("Validating email me link on the Login Page");
		boolean flag = loginpage.validateEmailMeLink();
		Assert.assertTrue(flag, "Email me link is not displayed on the LoginPage");
	}
	
	@Test(priority=8)
	public void lostPasswordLink()
	{
		log.info("Validating lost password link on the Login Page");
		boolean flag = loginpage.validateLostYourPassword();
		Assert.assertTrue(flag, "Lost Password link is not displayed on the LoginPage");
	}
	
	@Test(priority=9)
	public void backToHomePage()
	{
		log.info("Validating back to word press homepage on the Login Page");
		boolean flag = loginpage.validateBackToHomePageLink();
		Assert.assertTrue(flag, "Back to word press home page link is not displayed on the LoginPage");
	}
	
	@Test(priority=10)
	public void goBackToHomePage()
	{
		log.info("Navigate back to word press homepage from the Login Page");
		homepage = loginpage.goBackToHomePageLink();
		loginpage = homepage.login();
	}
	
	@Test(priority=11)
	public void enterEmailAdressTest()
	{
		log.info("Entering username in the Login Page");
		loginpage.enterUserName(prop.getProperty("username"));
	}
	
	@Test(priority=12)
	public void clickContineButton()
	{
		log.info("Clicking Continue Button on the Login Page");
		loginpasswordpage = loginpage.clickContinueButton();
	}
	
}
