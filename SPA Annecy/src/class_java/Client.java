package class_java;

import java.sql.*;

public class Client {

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
		String sql = "insert into client" + "(id, prenom, nom, adresse, ville, code_postal)" + "values ('5', 'Robert', 'Schmitt', '1 rue Jean Jaurès', 'Annecy', '74000')";
		myStmt.executeUpdate(sql);
		System.out.println("Nouveau client ajouté !");
		
		ResultSet myRs = myStmt.executeQuery("select * from client");
	while (myRs.next()) {
		System.out.println("Numéro ID : " + myRs.getString("id") + " Prenom : " + myRs.getString("prenom") + " Nom : " + myRs.getString("nom") + " Adresse : " + myRs.getString("adresse") + " Ville : " + myRs.getString("ville") + " Code Postal : " + myRs.getString("code_postal"));
	}
	
	}
	catch (SQLException e) {
		System.err.println("Erreur : " + e.getMessage());
		System.err.println("Code : " + e.getErrorCode());
		System.err.println("State : " + e.getSQLState());
		}
  }
}