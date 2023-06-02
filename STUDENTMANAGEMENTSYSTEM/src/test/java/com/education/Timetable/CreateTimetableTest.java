package com.education.Timetable;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.edu.ObjectRepository.AllStudentPage;
import com.edu.ObjectRepository.GradePage;
import com.edu.ObjectRepository.HomePage;
import com.edu.ObjectRepository.LoginPage;
import com.edu.ObjectRepository.SubjectRoutingPage;
import com.edu.ObjectRepository.TimeTablePage;

import smsgenericutilities.BaseClass;
import smsgenericutilities.ExcelUtility;
import smsgenericutilities.JavaUtility;
import smsgenericutilities.PropertyUtility;
import smsgenericutilities.WebdriverUtility;

public class CreateTimetableTest extends BaseClass{

	@Test(groups = "regTest")
	public void createTimetable() throws Throwable
	{
	
    int ranno=javaLib.getRandomNumber();
    
    HomePage h=new HomePage(driver);
  //verify that admin dashboard is displaying or not
    String title = driver.getCurrentUrl();
   /* if(title.contains("dashboard"))
    {
    	System.out.println("admin dashboard page is displaying");
    }
    else
    {
    	System.out.println("admin dashpage page is  not displaying");
    }*/
    Assert.assertTrue(title.contains("dashboard"), "admin dashboard");
    Reporter.log("admin dashboard is displaying",true);
    h.setGradelink();
    String gradename=excelLib.fetchDataFromExcel("Sheet1", 1, 1)+ranno;
    String grade1="Grade 1";
    String fee=excelLib.fetchDataFromExcel("Sheet1", 1, 2);
    String hallcharge=excelLib.fetchDataFromExcel("Sheet1", 1, 3);;
    String range=excelLib.fetchDataFromExcel("Sheet1", 1, 4);
    String grade=excelLib.fetchDataFromExcel("Sheet1", 1, 5);
    GradePage g=new GradePage(driver);
    SubjectRoutingPage sub=new SubjectRoutingPage(driver);
    String title1 = driver.getCurrentUrl();
    Assert.assertTrue(title1.contains("grade"), "grade page");
    Reporter.log("grade page is displaying",true);
    g.addGrade(gradename, fee, hallcharge, range, grade);
    WebElement element = sub.getMessage();
    wLib.waitTillElementToBeInVisible(driver, element);
    h.setTimetable();
    String title2 = driver.getCurrentUrl();
    Assert.assertTrue(title2.contains("timetable"), "timetable page");
    Reporter.log("timetable page is displaying",true);
    AllStudentPage allstud=new AllStudentPage(driver);
    allstud.selectgrade(grade1,wLib);
    allstud.setSubmitBtn();
    TimeTablePage time=new TimeTablePage(driver);
    time.setAddBtn();
    String day=excelLib.fetchDataFromExcel("CreateTimetable", 1, 3);
    String subject=excelLib.fetchDataFromExcel("CreateTimetable", 1, 4);
    String classroom=excelLib.fetchDataFromExcel("CreateTimetable", 1, 5);
    String teacher=excelLib.fetchDataFromExcel("CreateTimetable", 1, 6);
    String stime=excelLib.fetchDataFromExcel("CreateTimetable", 1, 7);
    String etime=excelLib.fetchDataFromExcel("CreateTimetable", 1, 8);
    time.setTime(day, subject, teacher, classroom, stime, etime,wLib);
    time.setSubmitBtn();
	}
}
