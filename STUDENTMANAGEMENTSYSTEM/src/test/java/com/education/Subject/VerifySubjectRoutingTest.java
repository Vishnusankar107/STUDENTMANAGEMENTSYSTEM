package com.education.Subject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.edu.ObjectRepository.AllStudentPage;
import com.edu.ObjectRepository.LoginPage;
import com.edu.ObjectRepository.TeacherPage;

import smsgenericutilities.ExcelUtility;
import smsgenericutilities.JavaUtility;
import smsgenericutilities.PropertyUtility;
import smsgenericutilities.WebdriverUtility;

public class VerifySubjectRoutingTest {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	static WebDriver driver;
	public static void main(String[] args) throws Throwable {
    driver=new ChromeDriver();
    WebdriverUtility wLib=new WebdriverUtility();
    PropertyUtility pLib=new PropertyUtility();
    ExcelUtility excelLib=new ExcelUtility();
    JavaUtility javaLib=new JavaUtility();
    LoginPage l=new LoginPage(driver);
    int ranno=javaLib.getRandomNumber();
    wLib.maximizeTheWindow(driver);
    wLib.waitTillPageGetLoad(driver);
    String url=pLib.fetchDataFromPropertiesFile("URL");
    String username=pLib.fetchDataFromPropertiesFile("teacher");
    String password=pLib.fetchDataFromPropertiesFile("password");
    driver.get(url);
    l.loginToApplication(username, password);
    TeacherPage t=new TeacherPage(driver);
    t.setMyStudent();
    AllStudentPage allstud=new AllStudentPage(driver);
    String grade=excelLib.fetchDataFromExcel("AddStudent", 1, 12);
    allstud.selectgrade(grade,wLib);
    allstud.setSubmitBtn();
    t.setSubject();
    t.setMySubject();
    t.setTimetable();
    t.setAllTimeTable();
    String gname=excelLib.fetchDataFromExcel("AddStudent", 1, 12);
    allstud.selectgrade(gname,wLib);
    allstud.setSubmitBtn();
}
}
