package Practice;

import org.testng.annotations.Test;

public class TestngPractice {
@Test(priority = 2)
public void deleteStudent()
{
    System.out.println("delete student");
		
}
@Test(dependsOnMethods  = "editStudent",priority = 5)
public void createStudent() 
{
	System.out.println("create student");
}
@Test(priority = 6)
public void editStudent() 
{
System.out.println("edit student");
}


}
