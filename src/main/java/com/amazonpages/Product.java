package com.amazonpages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.javascript.host.Window;
import com.thoughtworks.selenium.webdriven.Windows;

public class Product extends BaseClass {

	@FindBy(xpath = "//label[contains(text(),'Search')]/following-sibling::input")
	WebElement searchInputBox;

	@FindBy(xpath = "//input[contains(@type,'submit')]")
	WebElement searchBtn;

	@FindBy(xpath = "//span[contains(@class,'a-size-base-plus a-color-base')]")
	WebElement productList;

	@FindBy(id = "add-to-cart-button")
	WebElement addToCartBtn;

	@FindBy(xpath = "(//a[contains(text(),'Cart')])[1]")
	WebElement cartBtn;
	
	@FindBy(xpath = "(//div[contains(@class,'a-section aok-relative s-image-tall-aspect')])[1]")
	WebElement singleProd;
	
//	(//span[contains(@class,'a-size-base-plus a-color-base')])[1]		

	public void searchProduct() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./PropertyFile/userData.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Properties pObj = new Properties();
		try {
			pObj.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		searchInputBox.sendKeys(pObj.getProperty("product"));
		searchBtn.click();
	}

	public void sortAllProduct() {
		java.util.List<WebElement> prodLst = driver
				.findElements(By.xpath("//span[contains(@class,'a-size-base-plus a-color-base')]"));
		java.util.List<String> elementsTextList = new ArrayList<String>();
		java.util.List<String> sortedElemetList = new ArrayList<String>();
		System.out.println(prodLst.size());
		for (WebElement e : prodLst) {
			elementsTextList.add(e.getText());
			sortedElemetList.add(e.getText());
		}
		Collections.sort(sortedElemetList);
		System.out.println("Actual List: " + elementsTextList);
		System.out.println("------------------------------");
		System.out.println("Expected List: " + sortedElemetList);
		Assert.assertNotEquals(elementsTextList, sortedElemetList);
	}

	public void selectOneProduct() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		singleProd.click();
	}

	public void clickOnAddToCartButton() {
		Set<String> windowsId = driver.getWindowHandles();
		Iterator<String> it = windowsId.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		addToCartBtn.click();
		cartBtn.click();
		driver.close();
		driver.switchTo().window(parentId);
	}
}
