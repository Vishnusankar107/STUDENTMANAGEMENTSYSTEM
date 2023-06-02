package com.education.Student;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.edu.ObjectRepository.AddStudentPage;
import com.edu.ObjectRepository.AllStudentPage;
import com.edu.ObjectRepository.HomePage;
import com.edu.ObjectRepository.LoginPage;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import smsgenericutilities.BaseClass;
import smsgenericutilities.ExcelUtility;
import smsgenericutilities.JavaUtility;
import smsgenericutilities.PropertyUtility;
import smsgenericutilities.WebdriverUtility;

public class EditStudentTest extends BaseClass{
	@Test(groups = "regTest")
	public void editStudent() throws Throwable
	{
    int ranno=javaLib.getRandomNumber();
    HomePage h=new HomePage(driver);
  //verify that admin dashboard is displaying or not
    String title = driver.getCurrentUrl();
    /*if(title.contains("dashboard"))
    {
    	System.out.println("admin dashboard page is displaying");
    }
    else
    {
    	System.out.println("admin dashpage page is  not displaying");
    }*/
    Assert.assertEquals(title.contains("dashboard"),true, "admin dashboard");
    Reporter.log("admin dashboard page is displaying",true);
    h.setStudentlink();
    h.setAllstudentlink();
  //verify that addstudent page  is displaying or not
    String title1 = driver.getCurrentUrl();
    /*if(title1.contains("all_student"))
    {
    	System.out.println("all student page is displaying");
    }
    else
    {
    	System.out.println("all student page is  not displaying");
    }*/
    Assert.assertEquals(title1.contains("all_student"), true,"all student");
    Reporter.log("all student page is displayed");
    AllStudentPage allstud=new AllStudentPage(driver);
    String grade=excelLib.fetchDataFromExcel("AddStudent", 1, 12);
    allstud.selectgrade(grade,wLib);
    allstud.setSubmitBtn();
    String sname=excelLib.fetchDataFromExcel("AddStudent", 1, 13); 
    allstud.searchname(sname);
    allstud.setEditBtn();
    String address=excelLib.fetchDataFromExcel("AddStudent", 1, 14);
    AddStudentPage add=new AddStudentPage(driver);
    add.setAddress(address);
    allstud.setUpdateBtn();
    WebElement element = allstud.setUpdateMessage();
    wLib.waitTillElementToBeInVisible(driver, element);
  //  AllStudentPage allstud1=new AllStudentPage(driver);
    allstud.selectgrade(grade,wLib);
    allstud.setSubmitBtn();
    allstud.searchname(sname);
    allstud.setStudent();
    WebElement data = allstud.fetchData();
    String title2=data.getText();
    allstud.setPopupBtn();
  //verify that student information is updated or not
    /*if(title2.contains("updated"))
    {
    	System.out.println("student information is updated");
    }
    else
    {
    	System.out.println("student information is updated");
    }
    */
    Assert.assertTrue(title2.equalsIgnoreCase("bangalore"),"student information");
    Reporter.log("student information is updated",true);
    wLib.waitTillElementToBeInVisible(driver, element);
	}

}
