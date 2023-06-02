package com.edu.ObjectRepository;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.Multiset.Entry;

import smsgenericutilities.JavaUtility;
import smsgenericutilities.WebdriverUtility;

public class AddStudentPage {
@FindBy(id="index_number")
private WebElement stuIndex;
@FindBy(id="full_name")
private WebElement stuName;
@FindBy(id="i_name")
private WebElement stuNameInitial;
@FindBy(id="address")
private WebElement stuAddress;
@FindBy(id="email")
private WebElement stuEmail;
@FindBy(id="phone")
private WebElement stuPhone ;
@FindBy(id="b_date")
private WebElement stuDOB;
@FindBy(id="gender")
private WebElement stuGender;
@FindBy(id="g_full_name")
private WebElement guadName;
@FindBy(id="g_i_name")
private WebElement guadNameInit;
@FindBy(id="g_address")
private WebElement guadAddress;
@FindBy(id="g_email")
private WebElement guadEmail;
@FindBy(id="g_phone")
private WebElement guadPhone;
@FindBy(id="g_b_date")
private WebElement guadDOB;
@FindBy(id="g_gender")
private WebElement guadGender;
@FindBy(id="fileToUpload")
private WebElement stuUpload;
@FindBy(id="g_fileToUpload")
private WebElement guadUpload;
@FindBy(xpath = "//button[text()='Next']")
private WebElement nextBtn;
@FindBy(xpath = "//select[@name='grade']")
private WebElement gradelistbox;
@FindBy(xpath ="//button[@class='btn btn-info ']")
private WebElement submitBtn;
@FindBy(xpath ="//div[@class='panel panel-info']/div[1]/button")
private WebElement popupBtn;
public AddStudentPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	
}
public WebElement getStuIndex() {
	return stuIndex;
}
public WebElement getStuName() {
	return stuName;
}
public WebElement getStuNameInitial() {
	return stuNameInitial;
}
public WebElement getStuAddress() {
	return stuAddress;
}
public WebElement getStuPhone() {
	return stuPhone;
}
public WebElement getStuDOB() {
	return stuDOB;
}
public WebElement getStuGender() {
	return stuGender;
}
public WebElement getGuadName() {
	return guadName;
}
public WebElement getGuadNameInit() {
	return guadNameInit;
}
public WebElement getGuadAddress() {
	return guadAddress;
}
public WebElement getGuadEmail() {
	return guadEmail;
}
public WebElement getGuadPhone() {
	return guadPhone;
}
public WebElement getGuadDOB() {
	return guadDOB;
}
public WebElement getGuadGender() {
	return guadGender;
}
public WebElement getStuUpload() {
	return stuUpload;
}
public WebElement getGuadUpload() {
	return guadUpload;
}
	public void setAddStudent(String name,String nameInitial,String indexno,String address,String stuemail,String gender,String phoneno,String DOB,WebdriverUtility wutil) 
	{
		stuName.sendKeys(name);
		stuNameInitial.sendKeys(nameInitial);
		stuIndex.sendKeys(indexno);
		stuAddress.sendKeys(address);
		stuEmail.sendKeys(stuemail);
		stuPhone.sendKeys(phoneno);
		stuDOB.sendKeys(DOB);
		wutil.selectElementInDropDown("Male",stuGender);
		}
	public void setAddGuardian(String name,String nameInitial,String address,String email,String gender,String phoneno,String DOB,WebdriverUtility wutil) 
	{
		guadName.sendKeys(name);
		guadNameInit.sendKeys(nameInitial);
		guadAddress.sendKeys(address);
		guadEmail.sendKeys(email);
		guadPhone.sendKeys(phoneno);
		guadDOB.sendKeys(DOB);
		wutil.selectElementInDropDown("Male",guadGender);
		}
	public void fileupload(String files)
	{
		stuUpload.sendKeys(files);
		guadUpload.sendKeys(files);
	}
	public void setNextBtn()
	{
		nextBtn.click();
	}
	public void setGradelistbox(String name,WebdriverUtility wutil) {
	wutil.selectElementInDropDown(name, gradelistbox);	
	}
	public void setSubmitBtn() {
		submitBtn.click();
	}
	public void setPopupBtn() {
		popupBtn.click();
	}
	public void setAddress(String name)
	{
		stuAddress.clear();
		stuAddress.sendKeys(name);
	}
	public void addStudentH(HashMap<String, String> fields,WebDriver driver,JavaUtility JLib)
	{
		for(java.util.Map.Entry<String, String>set:fields.entrySet())
		{
			driver.findElement(By.id(set.getKey())).sendKeys((set.getValue()));
		}
		
	}
}
