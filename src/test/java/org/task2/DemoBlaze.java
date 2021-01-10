package org.task2;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoBlaze {
	@Test
	public void tc1() throws InvalidFormatException, IOException, InterruptedException {
		
		LibGlobal l = new LibGlobal();
		WebDriver driver = l.browserLaunch();
		l.getURL(driver, "https://www.demoblaze.com/");
		l.winMaximize(driver);
		
		DemoBlazePojo d = new DemoBlazePojo(driver);
		PageFactory.initElements(driver, d);
		l.click(d.getBtnLogInPage());
		l.implicitWaitSec(driver,5);
		l.enterVal(d.getTxtuserName(), l.excelRead("Login", 1, 0));
		l.enterVal(d.getTxtPassword(), l.excelRead("Login", 1, 1));
		l.click(d.getBtnLogin());
		Thread.sleep(1000);
		l.scrollDown(driver, d.getOrdProduct());
		l.click(d.getOrdProduct());
		l.implicitWaitSec(driver,5);
		String price = l.getText(d.getProductPrice());
		System.out.println("Product Price: "+price);
		l.click(d.getBtnAddToCart());
		Thread.sleep(1000);
		l.simpleAlert(driver);
		
		DemoBlazeCartPojo b = new DemoBlazeCartPojo(driver);
		PageFactory.initElements(driver, b);
		l.click(b.getCart());
		Thread.sleep(1000);
		l.click(b.getBtnPlaceOrder());
		l.implicitWaitSec(driver,5);
		l.enterVal(b.getTxtName(), l.excelRead("CardDetail", 1, 0));
		l.enterVal(b.getTxtCountry(), l.excelRead("CardDetail", 1, 1));
		l.enterVal(b.getTxtCity(), l.excelRead("CardDetail", 1, 2));
		l.enterVal(b.getTxtCard(), l.excelRead("CardDetail", 1, 3));
		l.enterVal(b.getTxtMonth(), l.excelRead("CardDetail", 1, 4));
		l.enterVal(b.getTxtYear(), l.excelRead("CardDetail", 1, 5));
		l.scrollDown(driver, b.getBtnPurchase());
		l.click(b.getBtnPurchase());
		l.implicitWaitSec(driver,5);
		String OrderDetail = l.getText(b.getOrderDetail());
		System.out.println("***Product Details***");
		System.out.println(OrderDetail);
		l.close(driver);





		
		
		
		
		
		
	}

}
