package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class MySqlDemo {

	public static void main(String[] args) throws SQLException {
    
    	Driver driver=new Driver();
     DriverManager.registerDriver(driver);
     Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vishnu","root","root");
     Statement statement = connection.createStatement();
     //adding the data into a database
     /*String Query="insert into employee values(104,'vvv',35000)";
     int result=statement.executeUpdate(Query);
     if(result==1)
     {
     System.out.println("data is added");
	}
     else
     {
    	 System.out.println("data is not added");
    	 }*/
     //fetch the data
     ResultSet result = statement.executeQuery("select * from employee");
     while(result.next())
     {
    	 String empid=result.getString(1);
    	 String ename=result.getString(2);
    	 String empsal=result.getString(3);
    	 System.out.println(empid+"\t"+ename+"\t"+empsal);
     }
     connection.close();
     }

}
