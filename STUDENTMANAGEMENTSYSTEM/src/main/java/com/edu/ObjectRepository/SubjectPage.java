package com.edu.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubjectPage {
@FindBy(id="name")
private WebElement subTxtBox;
@FindBy(xpath = "//button[text()='Submit']")
private WebElement submitBtn;
public SubjectPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	
}
public WebElement getSubTxtBox() {
	return subTxtBox;
}
public WebElement getSubmitBtn() {
	return submitBtn;
}
public void addSubject(String name)
{
subTxtBox.sendKeys(name);
submitBtn.click();
}

}
