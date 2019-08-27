package com.amazonpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	@FindBy(id="ap_email")
	private WebElement loginEmail;
	
	@FindBy(id="ap_password")
	private WebElement loginPassword;
	
	@FindBy(xpath="//span[contains(text(),'Hello')]")
	private WebElement mouseover;
	
	@FindBy(xpath="//h1[contains(text(),'Login')]")
	private WebElement loginLabel;
	
	@FindBy(id="continue")
	private WebElement continueBtn;
	
	@FindBy(css = "span.nav-action-inner")
	WebElement SignInButton;
	
	@FindBy(id="signInSubmit")
	WebElement LoginBtn;
	
	@FindBy(xpath="//span[contains(text(),'Sign Out')]")
	WebElement signOutLnk;

	public WebElement getLoginEmail() {
		return loginEmail;
	}

	public WebElement getLoginPassword() {
		return loginPassword;
	}

	public WebElement getMouseover() {
		return mouseover;
	}

	public WebElement getLoginLabel() {
		return loginLabel;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}
	
	public void clickOnSignButton(){
		WebDriverCommomLib web= new WebDriverCommomLib();
		web.mouseMouse(mouseover);
		SignInButton.click();		
	}
	
	public void login(String userNAme , String password){
		WebDriverCommomLib web= new WebDriverCommomLib();
		web.waitForElemnet(loginLabel);
		getLoginEmail().sendKeys(userNAme);
		getContinueBtn().click();
		getLoginPassword().sendKeys(password);
		LoginBtn.click();
	}
	
	public void clickOnSignOutButton(){
		WebDriverCommomLib web= new WebDriverCommomLib();
		web.mouseMouse(mouseover);
		signOutLnk.click();		
	}
	
}
