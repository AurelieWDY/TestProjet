package class_java;

import java.sql.*;

public class Animal {

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
		String sql = "insert into animal" + "(id, nom, age, race, prix)" + "values ('2020010', 'Zoé', '12', 'Chien', '0')";
		myStmt.executeUpdate(sql);
		System.out.println("Nouveau animal ajouté !");
		
		ResultSet myRs = myStmt.executeQuery("select * from animal");
	while (myRs.next()) {
		System.out.println("Numéro ID : " + myRs.getString("id") + " Nom : " + myRs.getString("nom") + " Age : " + myRs.getString("age") + " Race : " + myRs.getString("race") + " Prix : " + myRs.getString("prix"));
	}
	
	}
	catch (SQLException e) {
		System.err.println("Erreur : " + e.getMessage());
		System.err.println("Code : " + e.getErrorCode());
		System.err.println("State : " + e.getSQLState());
		}
  }
}