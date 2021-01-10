package org.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class DemoBlazePojo {
	
	WebDriver driver;
	public DemoBlazePojo(WebDriver driver1) {
		this.driver = driver1;
	}
	
	@FindBy(id="login2")
	private WebElement btnLogInPage;
	
	@FindBy(id= "loginusername")
	private WebElement txtuserName;
	
	@FindBy(id="loginpassword")
	private WebElement txtPassword;
	
	@FindBy(xpath="//button[@onclick='logIn()']")
	private WebElement btnLogin;
	
	@FindBy(xpath="(//img[@class='card-img-top img-fluid'])[5]")
	private WebElement ordProduct;
	
	@FindBy(xpath="((//img[@class='card-img-top img-fluid'])[2]")
	private WebElement scrlProduct;
	
	@FindBy(className = "price-container")
	private WebElement productPrice;
	
	@FindBy(xpath="//a[@onclick='addToCart(5)']")
	private WebElement btnAddToCart;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getBtnLogInPage() {
		return btnLogInPage;
	}

	public WebElement getTxtuserName() {
		return txtuserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getOrdProduct() {
		return ordProduct;
	}

	public WebElement getScrlProduct() {
		return scrlProduct;
	}

	public WebElement getProductPrice() {
		return productPrice;
	}

	public WebElement getBtnAddToCart() {
		return btnAddToCart;
	}
	
	
	
	
	
	
	

}
