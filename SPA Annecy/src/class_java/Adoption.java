package class_java;

import java.sql.*;

public class Adoption {
	public static void main(String[] args) throws Exception{
		
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3308/spa_database?useUnicode=true" + 
			"&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&" + 
			"serverTimezone=UTC";
	String user = "WDY";
	String password = "Aurelie2020*";
	Class.forName(driver);
	
	try {
		Connection myConn = DriverManager.getConnection(url, user, password);
		Statement myStmt = myConn.createStatement();
		String sql = "insert into adoption" + "(date)" + "values ('29/03/2020')";
		myStmt.executeUpdate(sql);
		System.out.println("Nouvelle adoption ajoutée !");
		
		ResultSet myRs = myStmt.executeQuery("select * from adoption");
	while (myRs.next()) {
		System.out.println("Date : " + myRs.getString("date"));
	}
	
	}
	catch (SQLException e) {
		System.err.println("Erreur : " + e.getMessage());
		System.err.println("Code : " + e.getErrorCode());
		System.err.println("State : " + e.getSQLState());
		}
  }
}