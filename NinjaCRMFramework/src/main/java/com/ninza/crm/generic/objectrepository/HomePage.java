package com.ninza.crm.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Campaigns']")
    private WebElement campaigns;

    @FindBy(xpath = "//a[text()='Products']")
    private WebElement products;

    @FindBy(xpath = "//*[@data-icon='user']")
    private WebElement profile;

    @FindBy(xpath = "//button[@aria-label='close']")
    private WebElement toastCross;

    @FindBy(xpath = "//div[contains(@class, 'dropdown-item logout')]")
    private WebElement logout;

    @FindBy(xpath = "//div[contains(text(),'Successfully Added')]")
    private WebElement toastMessage;

    public WebElement getCampaigns() {
        return campaigns;
    }

    public WebElement getProducts() {
        return products;
    }

    public WebElement getProfile() {
        return profile;
    }

    public WebElement getToastCross() {
        return toastCross;
    }

    public WebElement getLogout() {
        return logout;
    }

    public WebElement getToastMessage() {
        return toastMessage;
    }
}
