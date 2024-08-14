package jdbcOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcTrial {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		executeCSVJDBC();
	}

	public static void executeCSVJDBC() throws ClassNotFoundException, SQLException {
		Class.forName("org.relique.jdbc.csv.CsvDriver"); // this is for type of DB
		String csvUrl = "src/test/resources/jdbccsv/";

		Connection con = DriverManager.getConnection("jdbc:relique:csv:" + csvUrl);
		Statement st = con.createStatement( ResultSet.TYPE_FORWARD_ONLY,
				 ResultSet.CONCUR_UPDATABLE);
		ResultSet rst = st.executeQuery("Select FirstName, LastName, JobTitle from people where UserId = (select UserId from people100 where FirstName='Crystal'); ");
		while(rst.next())
		System.out.println(rst.getString("FirstName")+" "+rst.getString("LastName")+" "+rst.getString("JobTitle"));
	}
}
