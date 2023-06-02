package com.education.Timetable;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateTimetable {

	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {
		Random ran = new Random();
		int rname=ran.nextInt();
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
	    Thread.sleep(5000);
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
	    //click on Grade link
	    driver.findElement(By.xpath("//span[text()='Grade']")).click();
	    String titleg = driver.getCurrentUrl();
	    if(titleg.contains("grade"))
	    {
	    	System.out.println("grade page is displaying");
	    }
	    else
	    {
	    	System.out.println("grade page is  not displaying");
	    }
	    driver.findElement(By.id("name")).sendKeys("Grade vv"+rname);
	    driver.findElement(By.id("admission_fee")).sendKeys("5000");
	    driver.findElement(By.id("hall_charge")).sendKeys("5");
	    driver.findElement(By.id("btnSubmit")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//input[@class='mark-range form-control']")).sendKeys("80");
	    driver.findElement(By.xpath("//input[@class='mark-grade form-control']")).sendKeys("Grade vi");
	    driver.findElement(By.id("btnSubmit1")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//span[text()='Timetable']")).click();
	    WebElement Grade = driver.findElement(By.id("grade"));
	    Select s=new Select(Grade);
	    s.selectByVisibleText("Grade 1");
	    driver.findElement(By.xpath("//button[text()='Submit']")).click();
	    driver.findElement(By.xpath("//a[@class='btn btn-success btn-sm pull-right']")).click();
      WebElement day = driver.findElement(By.id("day"));
        WebElement subject = driver.findElement(By.id("subject"));
        WebElement teacher = driver.findElement(By.id("teacher"));
        WebElement classroom = driver.findElement(By.id("classroom"));
        Select s1=new Select(day);
        Select s2=new Select(subject);
        Select s3=new Select(teacher);
        Select s4=new Select(classroom);
        s1.selectByVisibleText("Monday");
        s2.selectByVisibleText("Subject 1");
        s3.selectByVisibleText("vish55 v");
        s4.selectByVisibleText("Class A");
        driver.findElement(By.id("start_time")).sendKeys("2");
        driver.findElement(By.id("end_time")).sendKeys("1");
        driver.findElement(By.id("btnSubmit")).click();
	    Thread.sleep(5000);

	    //logout as admin
	    driver.findElement(By.xpath("//span[contains(text(),'Ingenious Developer')]")).click();
	    driver.findElement(By.xpath("//a[text()='Sign out']")).click();
	    //login as teacher
        ///enter the email in email textField
	    driver.findElement(By.id("email")).sendKeys("vish55@gmail.com");
	    //enter the password in password textField
	    Thread.sleep(5000);
	    driver.findElement(By.id("password")).sendKeys("12345");
	    //click on submit button
	    driver.findElement(By.xpath("//button[text()='Submit']")).click();
	    Thread.sleep(5000);
	    //click on time table
	    driver.findElement(By.xpath("//span[text()='Timetable']")).click();
	    //click on my timetable
	    driver.findElement(By.xpath("//a[text()=' My Timetable']")).click();
	    //verify that time table is added or not
	    String text = driver.findElement(By.xpath("//tr[@id='2.00_1.00']/td[2]")).getText();
	    if(text.contains("vish55"))
	    {
	    	System.out.println("time table is added");
	    }
	    else
	    {
	    	System.out.println("time table is not added");
	    }
	
	}
}
