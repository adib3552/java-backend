package jdbc;

//Java database connectivity

/*
 steps:-
 1.import package.
 2.load and register the driver
 3.create connection
 4.create a statement
 5.execute the query
 6.process the result
 7.close
*/

import java.sql.*;

public class demoClass {
	public static void main(String[] args) throws Exception{
		
		//System.out.println("Hello");
		
		String url="jdbc:mysql://localhost:3306/demo";
		String username="root";
		String password="";
		String query="select * from demotable";
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection(url,username,password);
		Statement st=con.createStatement();
		
		ResultSet rs=st.executeQuery(query);
		
		while(rs.next()) {
			String userData=rs.getInt(1)+": "+rs.getString(2);
			System.out.println(userData);
		}
		
		st.close();
		con.close();
	}
}
