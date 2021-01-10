package org.task;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FlipkartTask1 {

	WebDriver driver;

	@Test
	public void tc1() {
		System.setProperty("webdriver.chrome.driver", "E:\\Poo_Workspace\\TestngSample\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Parameters({ "url", "product" })
	@Test
	public void tc2(String url, String product) {
		driver.get(url);
		WebElement btnClose = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		btnClose.click();
		WebElement txtSearch = driver.findElement(By.xpath("//input[@class='_3704LK']"));
		txtSearch.sendKeys(product);
		WebElement btnSearch = driver.findElement(By.className("L0Z3Pu"));
		btnSearch.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> products = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));

		// Print All the search product

		System.out.println("***Print All the search product***");
		for (int i = 0; i < products.size(); i++) {
			WebElement e = products.get(i);
			String text = e.getText();
			System.out.println(text);

		}
		System.out.println();


		// To Remove Duplicate value and Print it
		System.out.println("***After Removing Duplicate value product Name***");
		for (int i = 0; i < products.size(); i++) {
			WebElement e = products.get(i);
			String text = e.getText();
			Set<String> s = new LinkedHashSet<String>();
			s.add(text);
			System.out.println(s);

		}
		System.out.println();


		// To print Product greater than price Rs.10000
		System.out.println("***Product greater than price Rs.10000***");
		for (int i = 0; i < products.size(); i++) {
			WebElement e = products.get(i);
			String productName = e.getText();
			WebElement e2 = price.get(i);
			String productPrice = e2.getText();
			productPrice = productPrice.replaceAll("[^0-9]", "");
			int priceInt = Integer.parseInt(productPrice);
			if (priceInt > 10000) {
				System.out.println(productName);
			}

		}

	}

	@Test
	public void tc3() {
		driver.quit();
	}

	
		// To Remove Duplicate value and Print it
		// Set <WebElement> s = new LinkedHashSet<WebElement>();
		// s.addAll(products);
		// for (WebElement e : s) {
		// System.out.println(e); //Values are Printed as WebElement
		//
		// }

	

}
