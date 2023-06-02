package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderThree {
	/*@Test(dataProvider = "data")	
	public void getData(String src,String dest,int price) 
	{
	System.out.println(src+"----"+dest+"----"+price);	
	}*/
		
	@DataProvider
	public Object[][] data()
	{	
	Object arr[][]=new Object[3][3];
	arr[0][0]="chennai";
	arr[0][1]="madurai";
	arr[0][2]=1000;
	
	arr[1][0]="sivakasi";
	arr[1][1]="bangalore";
	arr[1][2]=800;
	
	arr[2][0]="sivakasi";
	arr[2][1]="coimbatore";
	arr[2][2]=600;
	
	return arr;
	}
}
