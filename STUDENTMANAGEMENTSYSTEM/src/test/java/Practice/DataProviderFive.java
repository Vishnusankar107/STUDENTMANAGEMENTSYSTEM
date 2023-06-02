package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderFive {
	/*@Test(dataProvider = "data")	
	public void getData(String name,String hometown,int age,String degree,int per) 
	{
	System.out.println(name+"----"+hometown+"--"+age+" "+degree+" --"+per);	
	}*/
		
	@DataProvider
	public Object[][] data()
	{	
	Object arr[][]=new Object[4][5];
	arr[0][0]="vishnu";
	arr[0][1]="madurai";
	arr[0][2]=25;
	arr[0][3]="BE";
	arr[0][4]=75;
	
	arr[1][0]="krish";
	arr[1][1]="bangalore";
	arr[1][2]=30;
	arr[1][3]="BTECH";
	arr[1][4]=80;
	
	arr[2][0]="moni";
	arr[2][1]="salem";
	arr[2][2]=35;
	arr[2][3]="BSC";
	arr[2][4]=85;
	
	arr[3][0]="sai";
	arr[3][1]="sattur";
	arr[3][2]=20;
	arr[3][3]="BCOM";
	arr[3][4]=90;
	return arr;
	}
}
