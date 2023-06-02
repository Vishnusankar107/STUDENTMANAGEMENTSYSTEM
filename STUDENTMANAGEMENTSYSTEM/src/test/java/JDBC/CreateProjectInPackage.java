package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

public class CreateProjectInPackage {

	public static void main(String[] args) throws SQLException, InterruptedException {
		Driver driver1=new Driver();
	     DriverManager.registerDriver(driver1);
	     Connection connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
	     Statement statement = connection.createStatement();
	     //adding the data into a database
	     String Query="insert into project values('TY_PROJ_29','vishnu','12-05-2023','SMS','On Going',5)";
	     int result=statement.executeUpdate(Query);
	     if(result==1)
	     {
	     System.out.println("data is added");
		}
	     else
	     {
	    	 System.out.println("data is not added");
	    	 }
	     connection.close();
	     System.setProperty("webdriver.chrome.driver", "./driver1/chromedriver.exe");
	     WebDriver driver=new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
         driver.get("http://rmgtestingserver:8084/");
         Thread.sleep(4000);
         driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
         Thread.sleep(4000);
         driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
         driver.findElement(By.xpath("//button[text()='Sign in']")).click();
         driver.findElement(By.xpath("//a[text()='Projects']")).click();
         WebElement p = driver.findElement(By.xpath("//div[@class='container']/descendant::td[text()='SMS']"));
	     String pname = "SMS";
	     String name = p.getText();
	     if(pname.equals(name))
	     {System.out.println("data is inserted");
	}
	     else
	     {
	    	 System.out.println("data is not inserted");}
	     }

}
