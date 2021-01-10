package org.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoBlazeCartPojo {
	WebDriver driver;
	public DemoBlazeCartPojo(WebDriver driver1) {
		this.driver = driver1;
	}
	
	@FindBy(id="cartur")
	private WebElement cart;
	
	@FindBy(id="totalp")
	private WebElement total;
	
	@FindBy(xpath="//button[@class='btn btn-success']")
	private WebElement btnPlaceOrder;
	
	@FindBy(id="name")
	private WebElement txtName;
	
	@FindBy(id="country")
	private WebElement txtCountry;
	
	@FindBy(id="city")
	private WebElement txtCity;
	
	@FindBy(id="card")
	private WebElement txtCard;
	
	@FindBy(id="month")
	private WebElement txtMonth;
	
	@FindBy(id="year")
	private WebElement txtYear;
	
	@FindBy(xpath="//button[@onclick='purchaseOrder()']")
	private WebElement btnPurchase;
	
	@FindBy(xpath="//p[@class='lead text-muted ']")
	private WebElement orderDetail;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCart() {
		return cart;
	}

	public WebElement getTotal() {
		return total;
	}

	public WebElement getBtnPlaceOrder() {
		return btnPlaceOrder;
	}

	public WebElement getTxtName() {
		return txtName;
	}

	public WebElement getTxtCountry() {
		return txtCountry;
	}

	public WebElement getTxtCity() {
		return txtCity;
	}

	public WebElement getTxtCard() {
		return txtCard;
	}

	public WebElement getTxtMonth() {
		return txtMonth;
	}

	public WebElement getTxtYear() {
		return txtYear;
	}

	public WebElement getBtnPurchase() {
		return btnPurchase;
	}

	public WebElement getOrderDetail() {
		return orderDetail;
	}
	
	
	

}
