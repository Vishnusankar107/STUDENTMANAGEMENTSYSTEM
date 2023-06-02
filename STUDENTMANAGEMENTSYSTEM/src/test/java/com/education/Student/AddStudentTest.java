package com.education.Student;
    import org.openqa.selenium.WebElement;
	import org.testng.Assert;
	import org.testng.Reporter;
	import org.testng.annotations.Listeners;
	import org.testng.annotations.Test;
	import com.edu.ObjectRepository.AddStudentPage;
	import com.edu.ObjectRepository.AllStudentPage;
	import com.edu.ObjectRepository.HomePage;
	import smsgenericutilities.BaseClass;
	import smsgenericutilities.IPathconstants;
	@Listeners(smsgenericutilities.ListenerImplementation.class)
	public class AddStudentTest extends BaseClass{

		@Test(groups = "smokeTest",retryAnalyzer = smsgenericutilities.RetryAnalyser.class)
		public void addStudent() throws Throwable
		{
		
	    AddStudentPage addstud=new AddStudentPage(driver);
	    int ranno=javaLib.getRandomNumber();
	    
	    String stuname=excelLib.fetchDataFromExcel("AddStudent", 1, 0)+ranno;
	    String nameInitial=stuname+" "+"V";
	    String indexno=""+ranno;
	    String address=excelLib.fetchDataFromExcel("AddStudent", 1, 1);
	    String email=ranno+excelLib.fetchDataFromExcel("AddStudent", 1, 2);
	    String phoneno=excelLib.fetchDataFromExcel("AddStudent", 1, 3);
	    String DOB=excelLib.fetchDataFromExcel("AddStudent", 1, 4);
	    String gender=excelLib.fetchDataFromExcel("AddStudent", 1, 5);
	    String guadname=excelLib.fetchDataFromExcel("AddStudent", 1, 6);
	    String guadnameInitial=guadname+" "+"v";
	    String guadAddress=excelLib.fetchDataFromExcel("AddStudent", 1,8 );
	    //String stuname=excelLib.fetchDataFromExcel("AddStudent", 1, 0);
	    String guadEmail=ranno+excelLib.fetchDataFromExcel("AddStudent", 1, 9);
	    String guadGender=excelLib.fetchDataFromExcel("AddStudent", 1, 5);
	    String guadPhoneno=excelLib.fetchDataFromExcel("AddStudent", 1, 10);
	    String guadDOB=excelLib.fetchDataFromExcel("AddStudent", 1, 11);
	    String grade=excelLib.fetchDataFromExcel("AddStudent", 1, 12);
	    
	    //verify that admin dashboard is displaying or not
	    String title = driver.getCurrentUrl();
	   /* if(title.contains("dashboard"))
	    {
	    	System.out.println("admin dashboard page is displaying");
	    }
	    else
	    {
	    	System.out.println("admin dashpage page is  not displaying");
	    }*/
	   // SoftAssert soft = new SoftAssert();
	    Assert.assertTrue(title.contains("dashboard"), "admin dashboard is not displaying");
	    Reporter.log("admin dashboard is displaying",true);
	    HomePage h=new HomePage(driver);
	    h.setStudentlink();
	    h.setAddstudentlink();
	    //verify that addstudent page  is displaying or not
	    String title1 = driver.getCurrentUrl();
	   /* if(title1.contains("student"))
	    {
	    	System.out.println("add student page is displaying");
	    }
	    else
	    {
	    	System.out.println("add student page is  not displaying");
	    }*/
	    Assert.assertTrue(title1.contains("student"), "add student page is displaying");
	    Reporter.log("add student page is displaying",true);
	    String files = IPathconstants.filepath;
	    addstud.setAddStudent(stuname,nameInitial,indexno,address,email,gender,phoneno,DOB,wLib);
	    addstud.setAddGuardian(guadname, guadnameInitial, guadAddress, guadEmail, guadGender, guadPhoneno, guadDOB, wLib);
	    addstud.fileupload(files);
	    //Assert.fail();
	    addstud.setNextBtn();
	    addstud.setGradelistbox(grade, wLib);
	    String teachername = excelLib.fetchDataFromExcel("Sheet1",1, 8);
	    addstud.setSubmitBtn();
	    addstud.setPopupBtn();
	    h.setStudentlink();
	    h.setAllstudentlink();
	    addstud.setGradelistbox(grade, wLib);
	    AllStudentPage allstud=new AllStudentPage(driver);
	    allstud.setSubmitBtn();
	    allstud.setSearch(stuname);
	    WebElement name=allstud.getVerifyELement();
	   String name1 =name.getText();
	   
	    /*if(name1.contains(stuname))
	    {
	    	System.out.println("student is created successfully");
	    }
	    else
	    {
	    	System.out.println("student is created successfully");
	    }*/
	   Assert.assertEquals(name1.contains(stuname),true,"sudent is created");
	   Reporter.log("student is created",true);
		}
	}


