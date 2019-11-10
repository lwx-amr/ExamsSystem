package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class DatabaseHandler {

	String url = "jdbc:mysql://localhost:3306/examssystem";
	String username = "examsuser";
	String password = "User123%";
	
	public Connection openDbConnectio(){
		Connection con = null;
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");	
	      	con = DriverManager.getConnection(url, username, password);
	      	return con;
	    } catch (SQLException | ClassNotFoundException e) {
	        throw new Error("Problem", e);
	    }
	}
	
	public boolean checkLogin(String id, String ps) {
		Connection con = openDbConnectio();
		String sql = "Select * from student where sid=? and password=?";
		try {
	      	PreparedStatement st =  con.prepareStatement(sql);
	      	st.setInt(1, Integer.parseInt(id));
	      	st.setString(2, ps);
	      	ResultSet rs = st.executeQuery();
	      	if(rs.next()){
	      		con.close();
	      		return true;
	      	}else {
	      		con.close();
	      		return false;
	      	}
	    } catch (SQLException e) {
	        throw new Error("Problem", e);
	    }
	}
	
	public boolean checkExam(String id){
		Connection con = openDbConnectio();;
	    try {
	    	String sql = "Select * from students_answers where sid=?";
	    	PreparedStatement st =  con.prepareStatement(sql);
	      	st.setInt(1, Integer.parseInt(id));
	      	ResultSet rs = st.executeQuery();
	      	if(rs.next()){
	      		con.close();
	      		return true;
	      	}else {
	      		con.close();
	      		return false;
	      	}
	    } catch (SQLException e) {
	        throw new Error("Problem", e);
	    }
	}
	
	public ArrayList<String> getQuestion(){
		Connection con = openDbConnectio();
		String sql = "Select * from question";
	    try {
	    	ArrayList<String> questions = new ArrayList<String>();
	    	ArrayList<String> finalOutput = new ArrayList<String>();
	    	PreparedStatement st =  con.prepareStatement(sql);
	      	ResultSet rs = st.executeQuery();
	      	while(rs.next()){
	      		questions.add(rs.getString(2));
            }
	      	// Get random number
	      	Random rg = new Random();
	      	int randQ = rg.nextInt(questions.size());
	      	
	      	// Add Choosen question
	      	finalOutput.add(questions.get(randQ));
	      	
	      	// Get all answers;
	      	ArrayList<String> answers = getAnswers(randQ+1);
	      	System.out.println(answers.toString());
	      	
	      	// Add correct answer
	      	finalOutput.add(answers.get(0));
	      	answers.remove(0);
	      	
	      	// Choose 2 answers
	      	for (int i=0; i<2; i++) {
	      		randQ = rg.nextInt(answers.size());
	      		finalOutput.add(answers.get(randQ));
	      		answers.remove(randQ);
	      	}
	      	con.close();
	      	return finalOutput;
	    } catch (SQLException e) {
	        throw new Error("Problem", e);
	    }
	}
	
	public ArrayList<String> getAnswers(int qid){
		Connection con = openDbConnectio();
		String sql = "Select * from answer where qid=?";
	    try {
	    	ArrayList<String> answers = new ArrayList<String>();
	    	PreparedStatement st =  con.prepareStatement(sql);
	      	st.setInt(1, qid);
	      	ResultSet rs = st.executeQuery();
	      	while(rs.next()){
	      		answers.add(rs.getString(2));
            }
	      	con.close();
	      	return answers;
	    } catch (SQLException e) {
	        throw new Error("Problem", e);
	    }
	}

	public void submitExam(int sid,String question,String answer){
		Connection con = openDbConnectio();
		String sql = "insert into students_answers values(?,?,?)";
	    try {
	    	PreparedStatement st =  con.prepareStatement(sql);
	      	int qid = getQuestId(question);
	      	int aid = getAnswerId(answer);      	
	      	st.setInt(1, sid);
	      	st.setInt(2, qid);
	      	st.setInt(3, aid);
	      	st.executeUpdate();
	      	con.close();
	    } catch (SQLException e) {
	        throw new Error("Problem", e);
	    }
	}

	private int getAnswerId(String answer) {
		Connection con = openDbConnectio();
		String sql = "Select * from answer where text=?";
	    try {
	    	PreparedStatement st =  con.prepareStatement(sql);
	      	st.setString(1, answer);
	      	ResultSet rs = st.executeQuery();
	      	while(rs.next()) {
	      		return rs.getInt(1);
	      	}
	      	return -1;
	    } catch (SQLException e) {
	        throw new Error("Problem", e);
	    }
	}

	private int getQuestId(String question) {
		Connection con = openDbConnectio();
		String sql = "Select * from question where text=?";
	    try {
	    	PreparedStatement st =  con.prepareStatement(sql);
	      	st.setString(1, question);
	      	ResultSet rs = st.executeQuery();
	      	while(rs.next()) {
	      		return rs.getInt(1);
	      	}
	      	return -1;
	    } catch (SQLException e) {
	        throw new Error("Problem", e);
	    }
	}
}
