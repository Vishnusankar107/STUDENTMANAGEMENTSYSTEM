package com.education.Teacher;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AddPettycash {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {
		//open the chrome browser
		WebDriver driver=new ChromeDriver();
		//maximize the screen
		driver.manage().window().maximize();
		//implicit wait
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        //enter the url
        driver.get("http://rmgtestingserver/domain/Student_Management_System/view/student.php");
        //login as admin
        ///enter the email in email textField
	    driver.findElement(By.id("email")).sendKeys("admin@gmail.com");
	    //enter the password in password textField
	    driver.findElement(By.id("password")).sendKeys("12345");
	    //click on submit button
	    driver.findElement(By.xpath("//button[text()='Submit']")).click();
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
	  //click on teacher link
	    driver.findElement(By.xpath("//span[text()='Teacher']")).click();
	    //click on add teacher link
	    driver.findElement(By.xpath("//a[text()=' Add Teacher']")).click();
	    //verify that addTeacher page is displaying or not
	    String title2 = driver.getCurrentUrl();
	    if(title2.contains("teacher"))
	    {
	    	System.out.println("add teacher page is displaying");
	    }
	    else
	    {
	    	System.out.println("add teacher page is  not displaying");
	    }
	    //enter all the necessary details in add teacher page
	    driver.findElement(By.id("index_number")).sendKeys("123456");
	    driver.findElement(By.id("full_name")).sendKeys("vish61");
	    driver.findElement(By.id("i_name")).sendKeys("vish61 v");
	    driver.findElement(By.id("address")).sendKeys("TN");
	    WebElement gender = driver.findElement(By.id("gender"));
	    Select s=new Select(gender);
	    s.selectByVisibleText("Male");
	    driver.findElement(By.id("phone")).sendKeys("987-654-3210");
	    driver.findElement(By.id("email")).sendKeys("vish61@gmail.com");
	    driver.findElement(By.id("fileToUpload")).sendKeys("C:\\Users\\Liyana\\Desktop\\Capture.JPG");
	    driver.findElement(By.id("btnSubmit")).click();
	    Thread.sleep(5000);
	    //click on teacher link
	    driver.findElement(By.xpath("//span[text()='Teacher']")).click();
	    //click on all teacher link
	    driver.findElement(By.xpath("//a[text()=' All Teacher']")).click();
	    //search the teacher name in search text field
	    driver.findElement(By.xpath("//input[@type='search']")).sendKeys("vish");
	    //verify that teacher is added or not
	    String teacher = driver.findElement(By.xpath("//a[@onclick='showModal1(this)']")).getText();
	    if(teacher.contains("vish"))
	    {
	    	System.out.println("teacher is added");
	    }
	    else
	    {
	    	System.out.println("teacher is not added");
	    }
	    //logout as admin
	    driver.findElement(By.xpath("//span[contains(text(),'Ingenious Developer')]")).click();
	    driver.findElement(By.xpath("//a[text()='Sign out']")).click();
	    //login as teacher
        ///enter the email in email textField
	    driver.findElement(By.id("email")).sendKeys("vish60@gmail.com");
	    //enter the password in password textField
	    driver.findElement(By.id("password")).sendKeys("12345");
	    //click on submit button
	    driver.findElement(By.xpath("//button[text()='Submit']")).click();
	    //verify that teacher dashboard is displaying or not
	    String title1 = driver.getCurrentUrl();
	    if(title.contains("dashboard"))
	    {
	    	System.out.println("teacher dashboard page is displaying");
	    }
	    else
	    {
	    	System.out.println("teacher dashpage page is  not displaying");
	    }
	    //click on mypettycash
	    driver.findElement(By.xpath("//span[text()='My Petty Cash']")).click();
	    //click on add button
	    driver.findElement(By.xpath("//a[text()='Add ']")).click();
	    ///enter the description of the petty cash and expense
	    driver.findElement(By.xpath("//input[@class='_desc form-control']")).sendKeys("daily expense");
	    driver.findElement(By.xpath("//input[@class='amount form-control']")).sendKeys("50");
	    //click on submit button
	    driver.findElement(By.id("btnSubmit")).click();
	    Thread.sleep(5000);
	    //verify that petty cash is added or not
	    String date = driver.findElement(By.xpath("(//tr/td[4])[position()<2]")).getText();
	    if(date.contains("2023-05-15"))
	    {
	    	System.out.println("petty cash is added by teacher");
	    }
	    else
	    {
	    	System.out.println("petty cash is not added by the teacher");
	    }
	    //logout as teacher
	    driver.findElement(By.xpath("//span[@class='hidden-xs']")).click();
	    driver.findElement(By.xpath("//a[text()='Sign out']")).click();
	    //login as admin
        ///enter the email in email textField
	    driver.findElement(By.id("email")).sendKeys("admin@gmail.com");
	    //enter the password in password textField
	    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("12345");
	    //click on submit button
	    driver.findElement(By.xpath("//button[text()='Submit']")).click();
	    //verify that admin dashboard is displaying or not
	    String title3 = driver.getCurrentUrl();
	    if(title3.contains("dashboard"))
	    {
	    	System.out.println("dashboard page is displaying");
	    }
	    else
	    {
	    	System.out.println("dashpage page is  not displaying");
	    }
	    //click on petty cash link
	    driver.findElement(By.xpath("//span[text()='Petty Cash']")).click();
	    //click on search link
	    driver.findElement(By.xpath("//input[@type='search']")).sendKeys("vish60 v");
	    //verify that pettycash details is displayed or not
	    String detail = driver.findElement(By.xpath("//td[text()='vish60 v']")).getText();	
	    if(detail.contains("vish60 v"))
	    {
	    	System.out.println("petty cash is added");
	    }
	    else
	    {
	    	System.out.println("petty cash is not added");
	    }
	    //logout as admin
	    driver.findElement(By.xpath("//span[contains(text(),'Ingenious Developer')]")).click();
	    driver.findElement(By.xpath("//a[text()='Sign out']")).click();
	}

}
