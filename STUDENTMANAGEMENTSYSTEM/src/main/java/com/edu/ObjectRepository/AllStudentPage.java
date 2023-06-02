package com.edu.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;
import smsgenericutilities.WebdriverUtility;

public class AllStudentPage {
@FindBy(id="grade")
private WebElement gradeDropDown; 
@FindBy(xpath = "//button[text()='Submit']")
private WebElement submitBtn;
@FindBy(xpath = "//input[@class='form-control input-sm']")
private WebElement searchField;
@FindBy(xpath = "//a[text()='Edit']")
private WebElement editBtn;
@FindBy(xpath = "//a[text()='Leave']")
private WebElement leaveBtn;
@FindBy(xpath = "//a[text()='Edit Subject']")
private WebElement editSubjectBtn;
@FindBy(xpath = "//a[text()='Upgrade Grade']")
private WebElement upgradeGradeBtn;
@FindBy(xpath = "//a[text()='Add Payment']")
private WebElement addPaymentBtn;
@FindBy(id="btnSubmit")
private WebElement updateBtn;
@FindBy(xpath = "//table/tbody/tr[1]/td[2]/a[1]")
private WebElement verifyName;
@FindBy(id ="update_Success")
private WebElement updateMessage;
@FindBy(xpath  ="//tr/td[2]/a")
private WebElement studentclick;
@FindBy(id ="address2")
private WebElement fetchdata;
@FindBy(xpath  ="//div[@class='panel-heading']/button/span")
private WebElement popupBtn;
public AllStudentPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	
}
public WebElement getGradeDropDown() {
	return gradeDropDown;
}
public WebElement fetchData() {
	return fetchdata;
}
public WebElement getUpdateMessgae() {
	return updateMessage;
}
public WebElement getSubmitBtn() {
	return submitBtn;
}
public WebElement getSearchField() {
	return searchField;
}
public WebElement getEditBtn() {
	return editBtn;
}
public WebElement getLeaveBtn() {
	return leaveBtn;
}
public WebElement getEditSubjectBtn() {
	return editSubjectBtn;
}
public WebElement getUpgradeGradeBtn() {
	return upgradeGradeBtn;
}
public WebElement getAddPaymentBtn() {
	return addPaymentBtn;
}
public WebElement getVerifyELement()
{
	return verifyName;
	
}
public void selectgrade(String name,WebdriverUtility wutil) throws Throwable
{
	wutil.selectElementInDropDown(name, gradeDropDown);
}
public void searchname(String name)
{
	searchField.sendKeys(name);
	}
public void setEditBtn()
{
	editBtn.click();
}
public void setSubmitBtn()
{
submitBtn.click();	
}
public void setUpdateBtn()
{
updateBtn.click();	
}
public void setSearch(String name)
{
searchField.sendKeys(name);	
}
public WebElement setUpdateMessage()
{
return updateMessage;	
}
public void setStudent()
{
studentclick.click();	
}
public void setPopupBtn()
{
popupBtn.click();	
}}
