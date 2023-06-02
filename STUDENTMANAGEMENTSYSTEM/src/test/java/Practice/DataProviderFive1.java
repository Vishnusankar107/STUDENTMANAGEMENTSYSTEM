package Practice;

import org.testng.annotations.Test;

public class DataProviderFive1 {
	@Test(dataProviderClass = DataProviderFive.class,dataProvider = "data")
	public void getData(String name,String hometown,int age,String degree,int per) 
	{
	System.out.println(name+"----"+hometown+"--"+age+" "+degree+" --"+per);	
	}
}
