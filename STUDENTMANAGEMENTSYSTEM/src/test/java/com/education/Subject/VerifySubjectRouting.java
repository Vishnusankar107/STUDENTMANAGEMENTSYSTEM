package com.education.Subject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class VerifySubjectRouting {
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
        //login as teacher
        ///enter the email in email textField
	    driver.findElement(By.id("email")).sendKeys("t2@gmail.com");
	    //enter the password in password textField
	    driver.findElement(By.id("password")).sendKeys("12345");
	    //click on submit button
	    driver.findElement(By.xpath("//button[text()='Submit']")).click();
	    //verify that teacher dashboard is displaying or not
	    
	    driver.findElement(By.xpath("//span[text()='My Student']")).click();
	    String title = driver.getCurrentUrl();
	    if(title.contains("dashboard"))
	    {
	    	System.out.println("dashboard page is displaying");
	    }
	    else
	    {
	    	System.out.println("dashpage page is  not displaying");
	    }
	    //verify that student page is displaying or not
	    String studentpagetitle = driver.getCurrentUrl();
	    if(studentpagetitle.contains("my_student"))
	    {
	    	System.out.println("student page is displaying");
	    }
	    else
	    {
	    	System.out.println("student page is  not displaying");
	    }
	    WebElement Grade = driver.findElement(By.id("grade"));
	    Select s=new Select(Grade);
	    s.selectByVisibleText("Grade 1");
	    driver.findElement(By.xpath("//button[text()='Submit']")).click();
	    //click on subject link
	    driver.findElement(By.xpath("//span[text()='Subject']")).click();
	    //click on my subject link
	    driver.findElement(By.xpath("//a[text()=' My Subject']")).click();
	    //verify that my subject page is displayed or not
	    String subpage= driver.getCurrentUrl();
	    if(subpage.contains("my_subject2"))
	    {
	    	System.out.println("my subject page is displaying");
	    }
	    else
	    {
	    	System.out.println("my subject page is  not displaying");
	    }
	    //click on timetable link
	    driver.findElement(By.xpath("//span[text()='Timetable']")).click();
	    //click on all time table link
	    driver.findElement(By.xpath("//a[text()='All Timetable']")).click();
	  //verify that timetable page is displayed or not
	    String timetablepage= driver.getCurrentUrl();
	    if(timetablepage.contains("all_timetable"))
	    {
	    	System.out.println("timetable page is displaying");
	    }
	    else
	    {
	    	System.out.println("timtable page is  not displaying");
	    } 
	    WebElement grade = driver.findElement(By.id("grade"));
	    Select s1=new Select(grade);
	    s1.selectByVisibleText("Grade 1");
	    driver.findElement(By.xpath("//button[text()='Submit']")).click();
	    
	    String timetable = driver.findElement(By.xpath("//div[@class='box']/div/h3")).getText();
	    if(timetable.contains("Grade 1"))
	    {
	    	System.out.println("timetable list for grade is displaying");
	    }
	    else
	    {
	    	System.out.println("timtable list for grade is  not displaying");
	    } 
	    }

}
