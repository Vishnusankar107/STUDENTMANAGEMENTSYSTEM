package com.edu.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this is a POM class for Login page
 * @author VISHNU
 *
 */
public class LoginPage {
	//declaration
	@FindBy(id = "email")
	private WebElement usernameEdt;
	@FindBy(id = "password")
	private WebElement passwordEdt;
	@FindBy(id = "btnSubmit")
	private WebElement submitBtn;
	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	//utilization
	/**
	 * Business library generi methods- project specified
	 * this method is used to login to the application
	 * @param USERNAME
	 * @param PASSWORD
	 * @throws InterruptedException 
	 */
	public void loginToApplication(String USERNAME,String PASSWORD) throws InterruptedException
	
	{
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		submitBtn.click();
	}

}
