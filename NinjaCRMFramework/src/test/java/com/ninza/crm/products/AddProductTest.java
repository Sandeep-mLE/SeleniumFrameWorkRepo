package com.ninza.crm.products;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
import com.ninza.crm.BaseclassUtility.BaseClass;
import com.ninza.crm.generic.fileutility.ExcelUtility;
import com.ninza.crm.generic.javautility.JavaUtility;
import com.ninza.crm.generic.objectrepository.CreateProductPage;
import com.ninza.crm.generic.objectrepository.HomePage;
import com.ninza.crm.generic.objectrepository.ProductsPage;
import com.ninza.crm.generic.webdriverutility.WebdriverUtility;
@Listeners(com.ninza.crm.listener.ListenersImplementation.class)
public class AddProductTest extends BaseClass {
	ExcelUtility eUtil = new ExcelUtility();
	JavaUtility jUtil = new JavaUtility();
	WebdriverUtility wUtil = new WebdriverUtility();

	@Test(groups = "smokeTest")
	public void addProductWithMandatoryFieldsTest() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.getProducts().click();

		ProductsPage pp = new ProductsPage(driver);
		pp.getCreateProduct().click();

		String prodName = eUtil.getDataFromExcel("product", 1, 0) + "_" + jUtil.randomNumber(2000);
		String Qty = eUtil.getDataFromExcel("product", 1, 1);
		String price = eUtil.getDataFromExcel("product", 1, 2);

		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.getProductName().sendKeys(prodName);
		cpp.getQuantity().clear();
		cpp.getQuantity().sendKeys(Qty);

		cpp.getPrice().clear();
		cpp.getPrice().sendKeys(price);

		wUtil.selectOptionByVisibleText(cpp.getProductCategoryDropdown(), "Electricals");
		wUtil.selectOptionByVisibleText(cpp.getVendorDropdown(), "Vendor_54513 - (Electronics)");
		cpp.getAddProductBtn().click();
		wUtil.waitForElementToBeVisible(driver, hp.getToastMessage());
		String notif = hp.getToastMessage().getText();
		/*
		// Using Soft Assert
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(notif.contains("Successfully"), "Product creation failed. Toast message: " + notif);

		Reporter.log("Product created successfully: " + prodName, true);

		hp.getToastCross().click();

		// Important: validate all soft assertions
		sa.assertAll();*/
	/*
		Assert.assertFalse(notif.contains("Successfully"), "Forcing a failure when success message appears");
		Reporter.log("product created successfully" + prodName, true);
		*/
		// hard assert 
		Assert.assertTrue(notif.contains("Successfully"), "product creation failed. Toast message: " + notif);
		Reporter.log("product created successfully" + prodName, true);
	
		
		
//		String notif = hp.getToastMessage().getText();
//		if (notif.contains("Successfully")) {
//		    Reporter.log("Product created successfully: " + prodName, true);
//		} else {
//		    Reporter.log("Product creation failed. Toast message: " + notif, true);
//		}

		hp.getToastCross().click();

	}

}
