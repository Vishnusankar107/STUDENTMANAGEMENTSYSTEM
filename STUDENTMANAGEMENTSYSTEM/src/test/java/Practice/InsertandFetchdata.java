package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertandFetchdata {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver1/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException{
          WebDriver driver=new ChromeDriver();
          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
          driver.get("https://www.amazon.in");
          List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
          FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
          Workbook workbook = WorkbookFactory.create(fis);
          Sheet sheet = workbook.getSheet("Sheet1");
          for(int i=0;i<allLinks.size();i++)
          {
        	  Row row = sheet.createRow(i);
        	  Cell cell = row.createCell(0);
        	  cell.setCellValue(allLinks.get(i).getAttribute("href"));
          }
          FileOutputStream fos=new FileOutputStream("./src/test/resources/TestData.xlsx");
          workbook.write(fos);
          workbook.close();
          
          
}
}