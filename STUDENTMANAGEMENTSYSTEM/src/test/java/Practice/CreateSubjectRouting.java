package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateSubjectRouting {

	/*static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}*/

	public static void main(String[] args) throws InterruptedException {
		//open the chrome browser
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--allow-remote-Origins=*");
	//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(option);
		//WebDriver driver=new ChromeDriver();
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
	    //click on subject link
	    driver.findElement(By.xpath("//span[text()='Subject']")).click();
	    //verify that subject page is displayed or not
	    String suburl = driver.getCurrentUrl();
	    if(suburl.contains("subject"))
	    {
	    	System.out.println("add subject page is displayed");
	    }
	    else
	    {
	    	System.out.println("add subject page is not displayed");
	    }
	    //enter the subject name 
	    driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Grade1");
	    //click on submit button
	    driver.findElement(By.xpath("//button[text()='Submit']")).click();
	    Thread.sleep(5000);
	    //click on classroom link
	    driver.findElement(By.xpath("//span[text()='Classroom']")).click();
	    //verify that classroom page is displayed or not
	    String classurl = driver.getCurrentUrl();
	    if(classurl.contains("class_room"))
	    {
	    	System.out.println("add classroom page is displayed");
	    }
	    else
	    {
	    	System.out.println("add classroom page is not displayed");
	    }
	    //enter the classroom into the name text field
	    driver.findElement(By.id("name")).sendKeys("A");
	    //enter the student count into  the student count text field
	    driver.findElement(By.id("student_count")).sendKeys("50");
	    //click on submit button
	    driver.findElement(By.id("btnSubmit")).click();
	    Thread.sleep(5000);
	    //click on subject routing link
	    driver.findElement(By.xpath("//span[text()='Subject Routing']")).click();
	   //verify that subject routing page is displayed or not 
	    String subrouteurl = driver.getCurrentUrl();
	    if(subrouteurl.contains("subject_routing"))
	    {
	    	System.out.println("subject routing page is displayed");
	    }
	    else
	    {
	    	System.out.println("subject routing page is not displayed");
	    }
	    //click the add link
	    driver.findElement(By.xpath("//a[text()='Add ']")).click();
	    WebElement Grade = driver.findElement(By.id("grade"));  
	    WebElement subject = driver.findElement(By.id("subject"));
	    WebElement teacher = driver.findElement(By.id("teacher"));
	    //using the select class selecting the list box of grade,subject and teacher name
	    Select s1 = new Select(Grade);
	    s1.selectByVisibleText("Grade A");
	    Select s2=new Select(subject);
	    s2.selectByVisibleText("Subject 1");
	    Select s3=new Select(teacher);
	    s3.selectByVisibleText("vish v");
	    //enter the fees into the fees textField
	    driver.findElement(By.id("fee")).sendKeys("5000");
	    //click on submit button
	    driver.findElement(By.id("btnSubmit")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//input[@class='form-control input-sm']")).sendKeys("vish55 ");
	    String g = driver.findElement(By.xpath("//tbody/tr/td[2]")).getText();
	    String s = driver.findElement(By.xpath("//tbody/tr/td[3]")).getText();
	    String t = driver.findElement(By.xpath("//tbody/tr/td[4]")).getText();
	    //verify that subject routing is added or not
	    System.out.println(g+" "+s+" "+t);
	    if(g.contains("Grade 1")&&s.contains("Subject 1")&&t.contains("vish55"))
	    {
	    	System.out.println("subject routing is added");
	    }
	    else
	    {
	    	System.out.println("subject routing is not added");
	    }
	    }

}
