package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

public class CreateProject {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver1/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException, SQLException {
          WebDriver driver=new ChromeDriver();
          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
          driver.get("http://rmgtestingserver:8084/");
          Thread.sleep(4000);
          driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
          Thread.sleep(4000);
          driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
          driver.findElement(By.xpath("//button[text()='Sign in']")).click();
          driver.findElement(By.xpath("//a[text()='Projects']")).click();
          driver.findElement(By.xpath("//span[text()='Create Project']")).click();
          driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("TYSS-sms");
          driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("vishnu");
          driver.findElement(By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open']/form/div[2]/div[4]/select/option[3]")).click();
          driver.findElement(By.xpath("//input[@value='Add Project']")).click();
          String name="TYSS-sms";
          Driver driver1=new Driver();
          DriverManager.registerDriver(driver1);
          Connection connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
          Statement statement = connection.createStatement();
          ResultSet result = statement.executeQuery("select * from project");
          boolean flag=false;
          while(result.next())
          {
         	 String pname=result.getString(4);
         	 if(name.contains(pname))
         	 {
         		 System.out.println("data is present");
         		 flag=true;
         		 break;
         		 
         	 }
          }
          if(!flag)
        	  System.out.println("not");
          connection.close();
          
	}

}
