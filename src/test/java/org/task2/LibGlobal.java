package org.task2;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LibGlobal {
	
	public WebDriver browserLaunch() {
		System.setProperty("webdriver.chrome.driver", "E:\\Poo_Workspace\\TestngSample\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	public void getURL(WebDriver driver, String url) {
		driver.get(url);
	}
	
	public String getText(WebElement e) {
		String s = e.getText();
		return s;
	}
	
	public void winMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void click(WebElement e) {
		e.click();
	}
	
	public String getAttr(WebElement e) {
		String s = e.getAttribute("value");
		return s;
		
	}
	
	public void enterVal(WebElement e, String value) {
		e.sendKeys(value);
	}
	
	public void close(WebDriver driver) {
		driver.close();
	}
	
	public void scrollDown(WebDriver driver, WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
		
		}
	
	public void simpleAlert(WebDriver driver) {
		Alert a = driver.switchTo().alert();
		a.accept();
	}
	
	public void implicitWaitSec(WebDriver driver, int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public void explicitWait(WebDriver driver, WebElement e) {
		WebDriverWait w = new WebDriverWait(driver,50);
		WebElement first = w.until(ExpectedConditions.visibilityOf(e));
	}
	
	public String excelRead(String sheetName,int row,int cell) throws InvalidFormatException, IOException {
		File loc = new File("E:\\Poo_Workspace\\ProjectClsTask\\TestData\\DemoBlaze.xlsx");
		Workbook w = new XSSFWorkbook(loc);
		Sheet s = w.getSheet(sheetName);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		int cellType = c.getCellType();
		String input = null;
		if(cellType ==1) {
			 input = c.getStringCellValue();
		}else if(DateUtil.isCellDateFormatted(c)) {
			Date d = c.getDateCellValue();
			SimpleDateFormat sim = new SimpleDateFormat("dd/MM/yyy");
			input = sim.format(d);
		}else {
			double d = c.getNumericCellValue();
			long l = (long)d;
			input = String.valueOf(l);
		}
		
		return input;
	}
}
