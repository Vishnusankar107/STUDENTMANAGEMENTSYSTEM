package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
/*@Test(dataProvider = "data")	
public void getData(String src,String dest) 
{
System.out.println(src+"----"+dest);	
}*/
	
@DataProvider
public Object[][] data()
{	
Object arr[][]=new Object[2][2];
arr[0][0]="chennai";
arr[0][1]="madurai";

arr[1][0]="sivakasi";
arr[1][1]="bangalore";
return arr;
}
}
