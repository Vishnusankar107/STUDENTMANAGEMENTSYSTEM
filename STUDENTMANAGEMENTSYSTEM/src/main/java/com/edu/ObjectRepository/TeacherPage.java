package com.edu.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeacherPage {
@FindBy(xpath = "//span[text()='My Student']")
private WebElement mystudentlink;
@FindBy(xpath = "//span[text()='Subject']")
private WebElement subjectlink;
@FindBy(xpath = " //a[text()=' My Subject']")
private WebElement mysubjectlink;
@FindBy(xpath = " //span[text()='Timetable']")
private WebElement timetableLink;
@FindBy(xpath = " //a[text()='All Timetable']")
private WebElement allTimetableLink;
public TeacherPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	
}

public void setMyStudent() throws Throwable
{
Thread.sleep(5000);
mystudentlink.click();	
}
public void setSubject()
{
subjectlink.click();
}
public void setMySubject()
{
mysubjectlink.click();	
}
public void setTimetable()
{
timetableLink.click();	
}
public void setAllTimeTable()
{
allTimetableLink.click();	
}
}
