package Practice;

import org.testng.annotations.Test;

public class DataProviderPracticeExcelTest {
@Test(dataProviderClass = DataProviderPracticeExcel.class,dataProvider = "getData")
public void test(String src,String dest,String price)
{
	System.out.println(src+" "+dest+" "+price);
}
}
