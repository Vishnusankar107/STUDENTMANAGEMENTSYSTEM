package com.edu.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import smsgenericutilities.WebdriverUtility;

public class TimeTablePage {
@FindBy(xpath = "//a[@class='btn btn-success btn-sm pull-right']")
private WebElement addBtn;
@FindBy(id="day")
private WebElement dayLink;
@FindBy(id="subject")
private WebElement subjectLink;
@FindBy(id="teacher")
private WebElement teacherLink;
@FindBy(id="classroom")
private WebElement classroomLink;
@FindBy(id="start_time")
private WebElement starttimeLink;
@FindBy(id="end_time")
private WebElement endtimeLink;
@FindBy(id="btnSubmit")
private WebElement submitBtn;
public TimeTablePage(WebDriver driver)
{
PageFactory.initElements(driver,this);	
}


public void setAddBtn()
{
addBtn.click();	
}
public void setTime(String day,String subject,String teacher,String classroom,String starttime,String endtime,WebdriverUtility wutil)
{
wutil.selectElementInDropDown(day,dayLink);
wutil.selectElementInDropDown(subject,subjectLink);
wutil.selectElementInDropDown(teacher,teacherLink);
wutil.selectElementInDropDown(classroom,classroomLink);
starttimeLink.sendKeys(starttime);
endtimeLink.sendKeys(endtime);
}
public void setSubmitBtn()
{
	submitBtn.click();
	}

}
