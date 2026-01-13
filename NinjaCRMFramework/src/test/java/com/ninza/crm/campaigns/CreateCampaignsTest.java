package com.ninza.crm.campaigns;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ninza.crm.BaseclassUtility.BaseClass;
import com.ninza.crm.generic.fileutility.ExcelUtility;
import com.ninza.crm.generic.javautility.JavaUtility;
import com.ninza.crm.generic.objectrepository.CampaignsPage;
import com.ninza.crm.generic.objectrepository.CreateCampaignPage;
import com.ninza.crm.generic.objectrepository.HomePage;
import com.ninza.crm.generic.webdriverutility.WebdriverUtility;
@Listeners(com.ninza.crm.listener.ListenersImplementation.class)
public class CreateCampaignsTest extends BaseClass {
	JavaUtility jUtil = new JavaUtility();
	ExcelUtility eUtil = new ExcelUtility();
	WebdriverUtility wUtil = new WebdriverUtility();

	@Test(groups = "smokeTest")
	public void createCampaignsWithMandatoryFieldsTest() throws Throwable {

		HomePage hp = new HomePage(driver);
		hp.getCampaigns().click();

		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaign().click();

		String campaignName = eUtil.getDataFromExcel("campaigns", 1, 0) + "_" + jUtil.randomNumber(2000);
		String targetSize = eUtil.getDataFromExcel("campaigns", 1, 1);

		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.getCampaignName().sendKeys(campaignName);
		ccp.getTargetSize().sendKeys(targetSize);
		ccp.getCreateCampaignBtn().click();

		wUtil.waitForElementToBeVisible(driver, hp.getToastMessage());
		String notif = hp.getToastMessage().getText();
		Assert.assertTrue(notif.contains("Successfully"), "Campaign creation failed. Toast message: " + notif);
		Reporter.log("campaigns created successfully" + campaignName, true);

		/*
		 * in real time we use assertion if (notif.contains("Successfully")) {
		 * System.out.println("Campaign created successfully: " + campaignName); } else
		 * { System.out.println("Campaign creation failed " + notif); }
		 */

		hp.getToastCross().click();

	}

	@Test(groups = "regressionTest")
	public void createCampaignsWithStatusTest() throws Throwable {

		HomePage hp = new HomePage(driver);
		hp.getCampaigns().click();

		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaign().click();

		String campaignName = eUtil.getDataFromExcel("campaigns", 1, 0) + "_" + jUtil.randomNumber(2000);
		String targetSize = eUtil.getDataFromExcel("campaigns", 1, 1);
		String status = eUtil.getDataFromExcel("campaigns", 1, 2);

		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.getCampaignName().sendKeys(campaignName);
		ccp.getTargetSize().sendKeys(targetSize);
		ccp.getCampaignStatus().sendKeys(status);

		ccp.getCreateCampaignBtn().click();

		wUtil.waitForElementToBeVisible(driver, hp.getToastMessage());
		String notif = hp.getToastMessage().getText();
		Assert.assertTrue(notif.contains("Successfully"), "Campaign creation failed. Toast message: " + notif);
		Reporter.log("campaigns created successfully" + campaignName, true);

//		if (notif.contains("Successfully")) {
//			System.out.println("Campaign created successfully: " + campaignName);
//		} else {
//			System.out.println("Campaign creation failed " + notif);
//		}

		hp.getToastCross().click();

	}

	@Test(groups = "smokeTest")
	public void createCampaignsWithExpectedDateTest() throws Throwable {

		HomePage hp = new HomePage(driver);
		hp.getCampaigns().click();

		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaign().click();

		String campaignName = eUtil.getDataFromExcel("campaigns", 1, 0) + "_" + jUtil.randomNumber(2000);
		String targetSize = eUtil.getDataFromExcel("campaigns", 1, 1);
		String status = eUtil.getDataFromExcel("campaigns", 1, 2);

		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.getCampaignName().sendKeys(campaignName);
		ccp.getTargetSize().sendKeys(targetSize);
		ccp.getCampaignStatus().sendKeys(status);

		String expectedDate = jUtil.getFutureDate(10);
		ccp.getExpectedCloseDateCalendar().sendKeys(expectedDate);

		ccp.getCreateCampaignBtn().click();
		wUtil.waitForElementToBeVisible(driver, hp.getToastMessage());
		String notif = hp.getToastMessage().getText();
		Assert.assertTrue(notif.contains("Successfully"), "Campaign creation failed. Toast message: " + notif);
		Reporter.log("campaigns created successfully" + campaignName, true);
		Assert.assertTrue(notif.contains("Successfully"), "Campaign creation failed. Toast message: " + notif);
		Reporter.log("campaigns created successfully" + campaignName, true);
		Assert.assertTrue(notif.contains("Successfully"), "Campaign creation failed. Toast message: " + notif);
		Reporter.log("campaigns created successfully" + campaignName, true);

//
//		if (notif.contains("Successfully")) {
//			System.out.println("Campaign created successfully: " + campaignName);
//		} else {
//			System.out.println("Campaign creation failed: " + notif);
//		}

		hp.getToastCross().click();
	}

}
