package com.edu.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClassroomPage {
	@FindBy(id="name")
	private WebElement nameTxtBox;
	@FindBy(id = "student_count")
	private WebElement countTxtBox;
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitBtn;
	public WebElement getNameTxtBox() {
		return nameTxtBox;
	}
	public WebElement getCountTxtBox() {
		return countTxtBox;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public ClassroomPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	public void addClassroom(String name,String count)
	{
		
	nameTxtBox.sendKeys(name);
	countTxtBox.sendKeys(count);
	submitBtn.click();
	}
}
