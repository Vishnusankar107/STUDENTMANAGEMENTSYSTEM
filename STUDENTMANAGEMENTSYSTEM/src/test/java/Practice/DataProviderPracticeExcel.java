package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import smsgenericutilities.ExcelUtility;
import smsgenericutilities.IPathconstants;

public class DataProviderPracticeExcel {
	/*@DataProvider
	public Object[][] getData() throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathconstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("DataProvider");
		int lastRow=sh.getLastRowNum()+1;
		int lastCell=sh.getRow(0).getLastCellNum();
		Object[][] arr = new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				arr[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return arr;
	}*/
	@DataProvider
	public Object[][] getData() throws Throwable 
	{
		ExcelUtility exUtil = new ExcelUtility();
		Object[][] arr = exUtil.dataProviderTest("DataProvider");
		return arr;
	}
}
