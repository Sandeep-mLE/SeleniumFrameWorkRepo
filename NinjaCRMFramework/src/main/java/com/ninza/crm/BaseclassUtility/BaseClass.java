package com.ninza.crm.BaseclassUtility;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.ninza.crm.generic.fileutility.PropertiesUtility;
import com.ninza.crm.generic.objectrepository.HomePage;
import com.ninza.crm.generic.objectrepository.LoginPage;
import com.ninza.crm.generic.webdriverutility.WebdriverUtility;
/**
 * BaseClass provides common setup and teardown methods for all TestNG test scripts.
 * It handles browser launch, login, and logout operations before and after tests.
 * Test classes should extend this class to reuse configuration methods.
 * Browser type, URL, and credentials are read from the properties file.
 * 
 * @author Mousumi
 */

public class BaseClass {
	public WebDriver driver = null;
	public static WebDriver sdriver;
	PropertiesUtility pUtil = new PropertiesUtility();
	WebdriverUtility wUtil = new WebdriverUtility();

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void configBS() {
		Reporter.log("Established the DB connectivity", true);
	}

	@BeforeTest(groups = { "smokeTest", "regressionTest" })
	public void configBT() {
		Reporter.log("Pre-Condition", true);
	}

	//@Parameters("browser")
	
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	
	//public void configBC(String browser ) throws Throwable {// for parallal cross browser execution
	
	public void configBC() throws Throwable {
		
		 String BROWSER = pUtil.getDataFromPropertiesFile("browser");
		 //String BROWSER=browser; // in case of parallal
		//String BROWSER = System.getProperty("browser");//in case of maven cmd i want to run i will pwerform this
		 
		if (BROWSER.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
		}

		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			new ChromeDriver();
		}
		sdriver= driver;
		Reporter.log("Successfully launched browser", true);
		
	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void configBM() throws Throwable {
		
		driver.manage().window().maximize();
		wUtil.setImplicitlyWait(driver);
		String URL = pUtil.getDataFromPropertiesFile("url");
		driver.get(URL);
		Reporter.log("Navigate to NijaCRM", true);
		String UN = pUtil.getDataFromPropertiesFile("username");
		String PWD = pUtil.getDataFromPropertiesFile("password");

		LoginPage lp = new LoginPage(driver);
		lp.getUsernameTextField().sendKeys(UN);
		lp.getPasswordTextField().sendKeys(PWD);
		lp.getSigninBtn().click();
		Reporter.log("Successfully log in", true);

	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void configAM() {
		HomePage hp = new HomePage(driver);
		wUtil.moveToElement(driver, hp.getProfile());
		hp.getProfile().click();
		hp.getLogout().click();
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void configAC() {
		driver.quit();
	}

	@AfterTest(groups = { "smokeTest", "regressionTest" })
	public void configAT() {
		Reporter.log("Post Condition", true);
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void configAS() {
		Reporter.log("Closed the DB connectivity", true);
	}

}
