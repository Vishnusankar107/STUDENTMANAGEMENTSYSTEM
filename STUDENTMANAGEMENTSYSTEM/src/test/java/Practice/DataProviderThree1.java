package Practice;

import org.testng.annotations.Test;

public class DataProviderThree1 {
	@Test(dataProviderClass = DataProviderThree.class,dataProvider = "data")	
	public void getData(String src,String dest,int price) 
	{
	System.out.println(src+"----"+dest+"----"+price);	
	}
}
