package pl.gov.pkw.VotesCounter;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		new WindowManager();
//		Connection c = null;
//		try {
//			Class.forName("org.postgreaql.Driver");
//			//DriverManager.register(new org.postgresql.Driver());
//			c = DriverManager
//					.getConnection("jdbc:postgresql.//localhost:5432/PKW",
//					"localhost", "morgoth");
//		}	catch (Exception e) {
//			e.printStackTrace();
//			System.err.print(e.getClass().getName()+": "+e.getMessage());
//			System.exit(0);
//		}
//		System.out.println("Opened database successfully");
	}

}
