package smsgenericutilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v110.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.edu.ObjectRepository.HomePage;
import com.edu.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public static WebDriver sdriver;
public  WebDriver driver=null;
public WebdriverUtility wLib=new WebdriverUtility();
public ExcelUtility excelLib=new ExcelUtility();
public JavaUtility javaLib=new JavaUtility();
PropertyUtility pLib=new PropertyUtility();
@BeforeSuite(groups = {"smokeTest","regTest"})
public void BS()
{
	System.out.println("--------Create a database connection---------");
}
@AfterSuite (groups = {"smokeTest","regTest"})
public void AS()
{
System.out.println("----------close the database------------");	
}



//@Parameters("BROWSER")
@BeforeClass(groups = {"smokeTest","regTest"})
public void BClass()
{
	String BROWSER = "chrome";
	if(BROWSER.contains("chrome"))
	{

	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();	
	}
	else if(BROWSER.contains("edge"))
	{

	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver();	
	}
	else
	{

	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();	
	}
	sdriver=driver;
System.out.println("Launch the browser");
wLib.maximizeTheWindow(driver);
wLib.waitTillPageGetLoad(driver);
}
@AfterClass(groups = {"smokeTest","regTest"})
public void AClass()
{
driver.quit();
System.out.println("close the browser");
}
@BeforeMethod(groups = {"smokeTest","regTest"})
public void BM() throws Throwable
{
	String url=pLib.fetchDataFromPropertiesFile("URL");
    String username=pLib.fetchDataFromPropertiesFile("username");
    String password=pLib.fetchDataFromPropertiesFile("password");
    driver.get(url);
    LoginPage l=new LoginPage(driver);
    l.loginToApplication(username, password);
    System.out.println("login into the application");
}

@AfterMethod(groups = {"smokeTest","regTest"})
public void AM()
{
HomePage h=new HomePage(driver);
 h.setLogout();
 System.out.println("logout from the application");
}
}
