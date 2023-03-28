package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {

	public static void main(String[] args) throws SQLException {
		
		//driver for my sql database
		Driver driverRef=new Driver();
		
		//Step1:Register the Driver
		DriverManager.registerDriver(driverRef);
		
		//Step2:Get the connection from database--database name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3db", "root", "root");
	
		//Step3:issue the create statement
	Statement state = con.createStatement();
		
		//Step4:execute a query - table name
		ResultSet result = state.executeQuery("select * from candidateinfo;");
		while(result.next())
		{
			System.out.println(result.getString(1)+ " "+result.getInt(2)+" "+ result.getString(3));
		}
		//Step5:close the database
		con.close();
		System.out.println("db closed");
	}

}
