package com.edu.ObjectRepository;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import smsgenericutilities.WebdriverUtility;

public class SubjectRoutingPage {
@FindBy(xpath = "//a[text()='Add ']")
private WebElement addBtn;
@FindBy(id="grade")
private WebElement gradeDropDown;
@FindBy(id = "subject")
private WebElement subjectDropDown;
@FindBy(id = "teacher")
private WebElement teacherDropDown;
@FindBy(id = "fee")
private WebElement feeTxtBox;
@FindBy(id = "btnSubmit")
private WebElement submitBtn1;
@FindBy(id = "btnSubmit")
private XPath addcon;
@FindBy(id = "btnSubmit")
private WebElement submitBtn;
@FindBy(xpath = "//tbody/tr/td[2]")
private WebElement gradelist;
@FindBy(xpath = "//tbody/tr/td[3]")
private WebElement subjectlist;
@FindBy(xpath = "//input[@class='form-control input-sm']")
private WebElement searchBar;
@FindBy (xpath="//div[@id='insert_Success']")
private WebElement message;
public WebElement getGradelist() {
	return gradelist;
}
public WebElement getSubjectlist() {
	return subjectlist;
}
public WebElement getMessage()
{
return message;	
}
public SubjectRoutingPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	
}
public WebElement getAddBtn() {
	return addBtn;
}
public WebElement getGradeDropDown() {
	return gradeDropDown;
}
public WebElement getSubjectDropDown() {
	return subjectDropDown;
}
public WebElement getTeacherDropDown() {
	return teacherDropDown;
}
public WebElement getFeeTxtBox() {
	return feeTxtBox;
}
public WebElement getSubmitBtn1() {
	return submitBtn1;
}
public XPath getAddcon() {
	return addcon;
}
public WebElement getSubmitBtn() {
	return submitBtn;
}
public void setAddBtn() {
	addBtn.click();
}
public void addSubjectRouting(String Grade,String subject,String teacher,String fee,WebdriverUtility wutil)
{
	wutil.selectElementInDropDown(Grade, gradeDropDown);
	wutil.selectElementInDropDown(subject, subjectDropDown);
	wutil.selectElementInDropDown(teacher, teacherDropDown);
	feeTxtBox.sendKeys(fee);
	submitBtn.click();
}
public void setSearchBar(String name) {
	searchBar.sendKeys(name);
}
public String gradeName()
{
return gradelist.getText();	
}
public String subNmae()
{
return subjectlist.getText();
}}
