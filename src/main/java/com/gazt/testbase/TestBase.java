package com.gazt.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.gazt.utilities.TimeOutSettings;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	public FileInputStream fis;
	
	String browsername;
	String url;
	
	Logger log = Logger.getLogger(TestBase.class);
	
	public TestBase()
	{
		try 
		{
			log.info("loading config.properties file");
			prop = new Properties();
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\gazt\\configuration\\config.properties");
			prop.load(fis);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void initialize()
	{
		log.info("Initializing browser and accessing application");
		browsername = prop.getProperty("browser");
		if((browsername != null) && (browsername.equalsIgnoreCase("ie"))||(browsername.equalsIgnoreCase("Internet Explorer")))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if((browsername!=null)&& (browsername.equalsIgnoreCase("Chrome"))||(browsername.equalsIgnoreCase("google chrome"))||(browsername.equalsIgnoreCase("Chrome browser")))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if((browsername!=null)&& (browsername.equalsIgnoreCase("firefox"))||(browsername.equalsIgnoreCase("mozilla firefox"))|| (browsername.equalsIgnoreCase("ff")))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TimeOutSettings.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TimeOutSettings.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.navigate().to(prop.getProperty("url"));
	}
	
	public void captureScreenShot(String methodName)
	{
		File sshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try 
		{
			FileUtils.copyFile(sshot, new File(System.getProperty("user.dir")+"\\Screenshots\\"+methodName+".jpg"));
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
}
