package com.education.Student;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.edu.ObjectRepository.ClassroomPage;
import com.edu.ObjectRepository.GradePage;
import com.edu.ObjectRepository.HomePage;
import com.edu.ObjectRepository.LoginPage;
import com.edu.ObjectRepository.SubjectPage;
import com.edu.ObjectRepository.SubjectRoutingPage;

import smsgenericutilities.BaseClass;
import smsgenericutilities.ExcelUtility;
import smsgenericutilities.JavaUtility;
import smsgenericutilities.PropertyUtility;
import smsgenericutilities.WebdriverUtility;

public class CreateSubjectRoutingTest extends BaseClass
{
	@Test(groups = "smokeTest")
	public void createSubjectRouting() throws Throwable 
	{
    int ranno=javaLib.getRandomNumber();
    String gradename=excelLib.fetchDataFromExcel("Sheet1", 1, 1)+ranno;
    String fee=excelLib.fetchDataFromExcel("Sheet1", 1, 2);
    String hallcharge=excelLib.fetchDataFromExcel("Sheet1", 1, 3);;
    String range=excelLib.fetchDataFromExcel("Sheet1", 1, 4);
    String grade=excelLib.fetchDataFromExcel("Sheet1", 1, 5);
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
    Assert.assertEquals(title.contains("dashboard"),true,"admin dashboard");
    Reporter.log("admin dashboard is displaying",true);
    HomePage h=new HomePage(driver);
    h.setGradelink();
    GradePage g=new GradePage(driver);
    SubjectRoutingPage sub=new SubjectRoutingPage(driver);
    g.addGrade(gradename, fee, hallcharge, range, grade);
    WebElement element = sub.getMessage();
    wLib.waitTillElementToBeInVisible(driver, element);
    h.setSubjectlink();
  //verify that subject page is displayed or not
    String suburl = driver.getCurrentUrl();
   /* if(suburl.contains("subject"))
    {
    	System.out.println("add subject page is displayed");
    }
    else
    {
    	System.out.println("add subject page is not displayed");
    }*/
    Assert.assertEquals(suburl.contains("subject"),true,"add student page");
    Reporter.log("add subject page is displayed",true);
    SubjectPage s=new SubjectPage(driver);
    String subname="Maths"+" "+ranno;
    s.addSubject(subname);
    wLib.waitTillElementToBeInVisible(driver, element);
    h.setClassroomlink();
  //verify that classroom page is displayed or not
    String classurl = driver.getCurrentUrl();
   /* if(classurl.contains("class_room"))
    {
    	System.out.println("add classroom page is displayed");
    }
    else
    {
    	System.out.println("add classroom page is not displayed");
    }*/
    Assert.assertEquals(classurl.contains("class_room"),true, "classroom");
    Reporter.log("add clssroom page is displayed",true);
    SubjectPage S=new SubjectPage(driver);
    ClassroomPage c=new ClassroomPage(driver);
    String roomname = excelLib.fetchDataFromExcel("Sheet1",1, 6)+" "+ranno;
    String count = excelLib.fetchDataFromExcel("Sheet1",1, 7);
    c.addClassroom(roomname, count);
    wLib.waitTillElementToBeInVisible(driver, element);
    h.setSubjectroutinglink();
  //verify that subject routing page is displayed or not 
    String subrouteurl = driver.getCurrentUrl();
   /* if(subrouteurl.contains("subject_routing"))
    {
    	System.out.println("subject routing page is displayed");
    }
    else
    {
    	System.out.println("subject routing page is not displayed");
    }*/
    Assert.assertEquals(subrouteurl.contains("subject_routing"),true, "subject routing page");
    Reporter.log("subject routing page is displaying",true);
    sub.setAddBtn();
    String teachername= excelLib.fetchDataFromExcel("Sheet1",1, 8);
    sub.addSubjectRouting(gradename,subname,teachername,fee,wLib);
    //verify that subject routing is added or not
    wLib.waitTillElementToBeInVisible(driver, element);
    sub.setSearchBar(subname);
    String Gname=sub.gradeName();
    String Sname=sub.subNmae();
    /*if(Gname.contains(gradename)&&(Sname.contains(subname)))
    {
    	System.out.println("subject routing is added");
    }
    else
    {
    	System.out.println("subject routing is not added");
    }*/
    Assert.assertEquals(Gname.contains(gradename)&&(Sname.contains(subname)),true,"subject routing add");
    Reporter.log("subject routing is added",true);
    }
	}
