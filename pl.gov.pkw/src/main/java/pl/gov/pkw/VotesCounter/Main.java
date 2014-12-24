package pl.gov.pkw.VotesCounter;
import java.sql.Connection;

import java.sql.DriverManager;

public class Main {

	public static void main(String[] args) {
		new WindowManager();
		Connection c = null;
		try {
			Class.forName("org.postgreaql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql.//localhost:5432/testdb",
					"postgres", "123");
		}	catch (Exception e) {
			e.printStackTrace();
			System.err.print(e.getClass().getName());
			//System.exit(0);
		}
		System.out.println("Opened database successfully");
	}

}
