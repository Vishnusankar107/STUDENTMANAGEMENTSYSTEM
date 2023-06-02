package Practice;

import org.testng.annotations.Test;

public class DataProvider {
	@Test(dataProviderClass = DataProviderTest.class,dataProvider = "data")	
	public void getData(String src,String dest) 
	{
	System.out.println(src+"----"+dest);	
	}
}
