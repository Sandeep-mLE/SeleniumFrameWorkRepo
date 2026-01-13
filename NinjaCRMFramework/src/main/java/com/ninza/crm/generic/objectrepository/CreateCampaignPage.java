package com.ninza.crm.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	WebDriver driver;

	public CreateCampaignPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "campaignName")
	private WebElement campaignName;

	@FindBy(name = "targetSize")
	private WebElement targetSize;

	@FindBy(name = "campaignStatus")
	private WebElement campaignStatus;

	@FindBy(name = "expectedCloseDate")
	private WebElement expectedCloseDateCalendar;

	@FindBy(xpath = "//button[text()='Create Campaign']")
	private WebElement createCampaignBtn;

	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getTargetSize() {
		return targetSize;
	}

	public WebElement getCampaignStatus() {
		return campaignStatus;
	}

	public WebElement getExpectedCloseDateCalendar() {
		return expectedCloseDateCalendar;
	}

	public WebElement getCreateCampaignBtn() {
		return createCampaignBtn;
	}
}
