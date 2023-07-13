package jdbc;

import java.sql.*;

public class DemoClassForInsertion {
	
	public static void main(String[] args) throws Exception{
		
		String url="jdbc:mysql://localhost:3306/demoforinsert";
		String username="root";
		String password="";
		String query="insert into demotable values(?,?)";
		
		int id=1;
		String name="thicc emon";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection(url,username,password);
		//Statement st=con.createStatement();
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1, id);
		st.setString(2, name);
		int count=st.executeUpdate();
		
		if(count==0) {
			System.out.println("Unsuccessfull");
		}
		else {
			System.out.println("Successfull");
		}
	
		st.close();
		con.close();
		
	}

}
