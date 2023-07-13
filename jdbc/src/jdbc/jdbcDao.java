package jdbc;
import java.sql.*;

public class jdbcDao {
	public static void main(String[] args) {
		UserDao dao=new UserDao();
		User us=dao.getUser(3);
		System.out.println(us.name);
	}
}

class User{
	int id;
	String name;
}

class UserDao{
	public User getUser(int id) {
		try {
			User u =new User();
			u.id=id;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demofordao","root","");
			Statement st=con.createStatement();
			String query="select name from demotable where id="+id;
			ResultSet rs=st.executeQuery(query);
			rs.next();
			String name=rs.getString(1);
			u.name=name;
			
			return u;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
}

