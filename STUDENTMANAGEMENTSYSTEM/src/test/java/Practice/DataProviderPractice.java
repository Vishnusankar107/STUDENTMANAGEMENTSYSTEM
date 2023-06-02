package Practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.edu.ObjectRepository.AddStudentPage;
import com.edu.ObjectRepository.HomePage;
import com.edu.ObjectRepository.LoginPage;

import smsgenericutilities.ExcelUtility;
import smsgenericutilities.JavaUtility;
import smsgenericutilities.PropertyUtility;
import smsgenericutilities.WebdriverUtility;

public class DataProviderPractice {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	static WebDriver driver ;
	public static void main(String[] args) throws Throwable {
	driver=new ChromeDriver();

    WebdriverUtility wLib=new WebdriverUtility();
    PropertyUtility pLib=new PropertyUtility();
    ExcelUtility excelLib=new ExcelUtility();
    JavaUtility javaLib=new JavaUtility();
    LoginPage l=new LoginPage(driver);
    AddStudentPage addstud=new AddStudentPage(driver);
    int ranno=javaLib.getRandomNumber();
	 wLib.maximizeTheWindow(driver);
	    wLib.waitTillPageGetLoad(driver);
	    String url=pLib.fetchDataFromPropertiesFile("URL");
	    String username=pLib.fetchDataFromPropertiesFile("username");
	    Thread.sleep(8000);
	    String password=pLib.fetchDataFromPropertiesFile("password");
	    driver.get(url);
	    l.loginToApplication(username, password);
	    //verify that admin dashboard is displaying or not
	    String title = driver.getCurrentUrl();
	    if(title.contains("dashboard"))
	    {
	    	System.out.println("dashboard page is displaying");
	    }
	    else
	    {
	    	System.out.println("dashpage page is  not displaying");
	    }
	    HomePage h=new HomePage(driver);
	    h.setStudentlink();
	    h.setAddstudentlink();
	    addstud.addStudentH(excelLib.getMultipleData("DataStudent"), driver, javaLib);
	    addstud.setNextBtn();
	    addstud.setGradelistbox("Grade 1", wLib);
	    String teachername = excelLib.fetchDataFromExcel("Sheet1",1, 8);
	    addstud.setSubmitBtn();
	    addstud.setPopupBtn();
}}
