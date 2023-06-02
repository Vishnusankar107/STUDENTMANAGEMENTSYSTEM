package com.edu.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this is a POM class for home page
 * @author VISHNU
 *
 */
public class HomePage {
	//declaration
	@FindBy(xpath = "//span[text()='My Profile']")
	private WebElement myprofilelink;
	@FindBy(xpath = "//span[text()='Classroom']")
	private WebElement classroomlink;
	@FindBy(xpath = "//span[text()='Grade']")
	private WebElement gradelink;
	@FindBy(xpath = "//span[text()='Subject']")
	private WebElement subjectlink;
	@FindBy(xpath = "//span[text()='Teacher']")
	private WebElement teacherlink;
	@FindBy(xpath = "//a[text()=' Add Teacher']")
	private WebElement addteacherlink;
	@FindBy(xpath = "//a[text()=' All Teacher']")
	private WebElement allteacherlink;
	@FindBy(xpath = "//span[text()='Subject Routing']")
	private WebElement subjectroutinglink;
	@FindBy(xpath = "//span[text()='Timetable']")
	private WebElement timetablelink;
	@FindBy(xpath = "//span[text()='Student']")
	private WebElement studentlink;
	@FindBy(xpath = "//a[text()=' Add Student']")
	private WebElement addstudentlink;
	@FindBy(xpath = "//a[text()=' All Student']")
	private WebElement allstudentlink;
	@FindBy(xpath = "//a[text()=' Leave Student']")
	private WebElement leavestudentlink;
	//span[text()='Student Payment']
	@FindBy(xpath = "//span[text()='Student Payment']")
	private WebElement studentpaymentlink;
	@FindBy(xpath = "//span[text()='Petty Cash']")
	private WebElement pettycashlink;
	@FindBy(xpath = "//span[text()='Attendance']")
	private WebElement attendancelink;
	@FindBy(xpath = "//a[text()=' Add Attendance']")
	private WebElement addattendancelink;
	@FindBy(xpath = "//a[text()='Student Attendance History ']")
	private WebElement studentattendancelink;
	@FindBy(xpath = "//a[text()=' Teacher Attendance History']")
	private WebElement teacherattendancelink;
	//span[text()='Exam']
	@FindBy(xpath = "//span[text()='Exam']")
	private WebElement examlink;
	@FindBy(xpath = "//a[text()='Create Exam']")
	private WebElement createexamlink;
	@FindBy(xpath = "//a[text()=' Exam Timetable']")
	private WebElement examtimetablelink;
	@FindBy(xpath = "//span[text()='Friends']")
	private WebElement friendslink;
	@FindBy(xpath = "//a[text()=' Add Friends']")
	private WebElement addfriendslink;
	@FindBy(xpath = "//a[text()=' My Friends']")
	private WebElement myfriendslink;
	@FindBy(xpath = "//span[text()='Event']")
	private WebElement eventlink;
	@FindBy(xpath = "//span[text()='Ingenious Developer1']")
	private WebElement adminlookupicon;
	@FindBy(xpath = "//a[text()='Sign out']")
	private WebElement signoutbtn;
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	public WebElement getMyprofilelink() {
		return myprofilelink;
	}
	public WebElement getClassroomlink() {
		return classroomlink;
	}
	public WebElement getGradelink() {
		return gradelink;
	}
	public WebElement getSubjectlink() {
		return subjectlink;
	}
	public WebElement getTeacherlink() {
		return teacherlink;
	}
	public WebElement getAddteacherlink() {
		return addteacherlink;
	}
	public WebElement getAllteacherlink() {
		return allteacherlink;
	}
	public WebElement getSubjectroutinglink() {
		return subjectroutinglink;
	}
	public WebElement getTimetablelink() {
		return timetablelink;
	}
	public WebElement getStudentlink() {
		return studentlink;
	}
	public WebElement getAddstudentlink() {
		return addstudentlink;
	}
	public WebElement getAllstudentlink() {
		return allstudentlink;
	}
	public WebElement getLeavestudentlink() {
		return leavestudentlink;
	}
	public WebElement getStudentpaymentlink() {
		return studentpaymentlink;
	}
	public WebElement getPettycashlink() {
		return pettycashlink;
	}
	public WebElement getAttendancelink() {
		return attendancelink;
	}
	public WebElement getAddattendancelink() {
		return addattendancelink;
	}
	public WebElement getStudentattendancelink() {
		return studentattendancelink;
	}
	public WebElement getTeacherattendancelink() {
		return teacherattendancelink;
	}
	public WebElement getExamlink() {
		return examlink;
	}
	public WebElement getCreateexamlink() {
		return createexamlink;
	}
	public WebElement getExamtimetablelink() {
		return examtimetablelink;
	}
	public WebElement getFriendslink() {
		return friendslink;
	}
	public WebElement getAddfriendslink() {
		return addfriendslink;
	}
	public WebElement getMyfriendslink() {
		return myfriendslink;
	}
	public WebElement getEventlink() {
		return eventlink;
	}
	public WebElement getAdminlookupicon() {
		return adminlookupicon;
	}
	public WebElement getSignoutbtn() {
		return signoutbtn;
	}
	public void setGradelink() {
		 gradelink.click();;
	}
	public void setSubjectlink() {
		subjectlink.click();
	}
	public void setSubjectroutinglink()
	{
		subjectroutinglink.click();
	}
	public void setClassroomlink() {
		 classroomlink.click();
	}public void setStudentlink() {
		 studentlink.click();
	}
	public void setAllstudentlink() {
		allstudentlink.click();
	}
	public void setAddstudentlink() {
		addstudentlink.click();
	}
    public void setTimetable()	
    {
    timetablelink.click();	
   }
    public void setLogout()
    {
    	adminlookupicon.click();
    	signoutbtn.click();
    	
    }
}
