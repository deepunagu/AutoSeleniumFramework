package practice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpadte {

	public static void main(String[] args) throws SQLException {
		
		Driver driverRef = new Driver();
		
		//Step1: Register the driver
		DriverManager.registerDriver(driverRef);
		
		//Step2:Get the connection 
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3db", "root", "root");
		
		//Step3: issue create statement
		Statement state = con.createStatement();
		
		//Step 4:execute a query 
		String query="insert into candidateinfo values('Kavya',20,'Gadag');";
		int result = state.executeUpdate(query);
		if(result>=1)
		{
			System.out.println("data added");
		}
		ResultSet resul = state.executeQuery("select * from candidateinfo;");
		while(resul.next())
		{
			System.out.println(resul.getString(1)+" "+resul.getInt(2)+" "+resul.getString(3));
		}
		
		//Step 5:close the database
		con.close();
		System.out.println("db closed");
			
	}
}
