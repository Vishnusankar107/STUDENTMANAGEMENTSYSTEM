package com.edu.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GradePage {
@FindBy(id="name")
private WebElement gradenameTxtBox;
@FindBy(id="admission_fee")
private WebElement admissionfeeTxtBox;
@FindBy(id="hall_charge")
private WebElement hallchargeTxtBox;

@FindBy(id="btnSubmit")
private WebElement nextBtn;
@FindBy(xpath = "//input[@class='mark-range form-control']")
private WebElement markranges;
@FindBy(xpath = "//input[@class='mark-grade form-control']")
private WebElement grades;
@FindBy(id="btnSubmit1")
private WebElement submitBtn;
public GradePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	
}
public WebElement getGradenameTxtBox() {
	return gradenameTxtBox;
}
public WebElement getAdmissionfeeTxtBox() {
	return admissionfeeTxtBox;
}
public WebElement getHallchargeTxtBox() {
	return hallchargeTxtBox;
}
public WebElement getNextBtn() {
	return nextBtn;
}
public WebElement getMarkRanges() {
	return markranges;
}
public WebElement getGrades() {
	return grades;
}
public WebElement getSubmitBtn() {
	return submitBtn;
}
public void addGrade(String gradename,String fee,String hallcharge,String markrange,String grade)
{
	gradenameTxtBox.sendKeys(gradename);
	admissionfeeTxtBox.sendKeys(fee);
	hallchargeTxtBox.sendKeys(hallcharge);
	nextBtn.click();
    markranges.sendKeys(markrange);
    grades.sendKeys(grade);
	submitBtn.click();
}
}