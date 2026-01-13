package com.ninza.crm.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ninza.crm.generic.webdriverutility.WebdriverUtility;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement usernameTextField;
	
	@FindBy(id = "inputPassword")
	private WebElement passwordTextField;
	
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signinBtn;

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getSigninBtn() {
		return signinBtn;
	}
    public void loginToCRM(String url,String username,String password) {
    	driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	WebdriverUtility wUtil = new WebdriverUtility();
    	wUtil.setImplicitlyWait(driver);
    	driver.get(url);
    	getUsernameTextField().sendKeys(username);
    	getPasswordTextField().sendKeys(password);
    	getSigninBtn().click();
    	
    }

}
