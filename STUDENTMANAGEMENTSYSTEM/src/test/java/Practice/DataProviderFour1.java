package Practice;

import org.testng.annotations.Test;

public class DataProviderFour1 {
	@Test(dataProviderClass = DataProviderFour.class,dataProvider = "data")
	public void getData(String name,String hometown,int age,String degree) 
	{
	System.out.println(name+"----"+hometown+"--"+age+" "+degree);	
	}
}
