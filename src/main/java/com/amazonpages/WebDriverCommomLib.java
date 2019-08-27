package com.amazonpages;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommomLib {

	public void mouseMouse(WebElement elemnet) {
		Actions act = new Actions(BaseClass.driver);
		act.moveToElement(elemnet).build().perform();
	}

	public void waitForElemnet(WebElement element) {
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
