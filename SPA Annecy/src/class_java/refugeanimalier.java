package class_java;

import java.sql.*;

public class Refugeanimalier {

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
		String sql = "insert into refugeanimalier" + "(id, nom, adresse, ville, code_postal, contact, ouverture)" + "values ('190081679', 'SPA Sillingy', '1240 rte de Clermont', 'Sillingy', '74330', '450687053', 'Du Lundi au Samedi de 14h à 18h')";
		myStmt.executeUpdate(sql);
		System.out.println("Nouvelle refuge ajoutée !");
		
		ResultSet myRs = myStmt.executeQuery("select * from refugeanimalier");
	while (myRs.next()) {
		System.out.println("Numéro ID : " + myRs.getString("id") + " Nom : " + myRs.getString("nom") + " Adresse : " + myRs.getString("adresse") + " Ville : " + myRs.getString("ville") + " Code postal : " + myRs.getString("code_postal") + " Contact : " + myRs.getString("contact") + " Horaire d'ouverture : " + myRs.getString("ouverture"));
	}
	
	}
	catch (SQLException e) {
		System.err.println("Erreur : " + e.getMessage());
		System.err.println("Code : " + e.getErrorCode());
		System.err.println("State : " + e.getSQLState());
		}
  }
}
