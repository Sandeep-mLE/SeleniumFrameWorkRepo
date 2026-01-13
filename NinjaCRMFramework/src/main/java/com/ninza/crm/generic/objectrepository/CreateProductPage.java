package com.ninza.crm.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	WebDriver driver;

	public CreateProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "productName")
	private WebElement productName;

	@FindBy(name = "quantity")
	private WebElement quantity;

	@FindBy(name = "price")
	private WebElement price;

	@FindBy(name = "productCategory")
	private WebElement productCategoryDropdown;

	@FindBy(name = "vendorId")
	private WebElement vendorDropdown;

	@FindBy(xpath = "//button[text()='Add']")
	private WebElement addProductBtn;

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getProductCategoryDropdown() {
		return productCategoryDropdown;
	}

	public WebElement getVendorDropdown() {
		return vendorDropdown;
	}

	public WebElement getAddProductBtn() {
		return addProductBtn;
	}

}
