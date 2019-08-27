package com.amazonpages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	public static WebDriver driver;
	
	@BeforeClass
	public void configBc() throws IOException{
		FileInputStream fis = new FileInputStream("./PropertyFile/urlAndBrowser.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String bNAme = pObj.getProperty("browser");
		if(bNAme.equals("firefox")){
		 driver = new FirefoxDriver();
		}else if(bNAme.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", 
					"./PropertyFile/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		
	}
	
	@BeforeMethod
	public void configBeforeMtd() throws Throwable{
		FileInputStream fis = new FileInputStream("./PropertyFile/userData.properties");
		
		Properties pObj = new Properties();
		pObj.load(fis);

		String url = pObj.getProperty("url");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(url);                                     
		//login to APP
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.clickOnSignButton();
		lp.login(pObj.getProperty("username"), pObj.getProperty("password"));
	}
	
	@AfterMethod
	public void configAM(){
		LoginPage lpage=PageFactory.initElements(driver, LoginPage.class);
		lpage.clickOnSignOutButton();
	}
	
	@AfterClass
	public void configAC(){
		driver.close();
	}
}
