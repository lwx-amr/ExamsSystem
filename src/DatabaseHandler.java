import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseHandler {

	String sql = "Select * from users where id=? and password=?";
	String url = "jdbc:mysql://localhost:3306/examssystem";
	String username = "examsuser";
	String password = "User123%";
	
	public boolean checkLogin(String id, String ps) {
		Connection conn = null;
	    try {
	    	System.out.println("ID: " + id + " PS: " + ps);
	    	Class.forName("com.mysql.jdbc.Driver");	
	      	conn = DriverManager.getConnection(url, username, password);
	      	PreparedStatement st =  conn.prepareStatement(sql);
	      	st.setString(1, id);
	      	st.setString(2, ps);
	      	ResultSet rs = st.executeQuery();
	      	if(rs.next()){
	      		return true;
	      	}else {
	      		return false;
	      	}
	    } catch (SQLException | ClassNotFoundException e) {
	        throw new Error("Problem", e);
	    }
	}
}
