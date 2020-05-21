package pl.sowinski.databaseoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import pl.sowinski.model.Customer;

public class DatabaseOperation {
	private static String dataFromBase;

	public static List<String> createMailQuery(List<String> list, String queryToDB) {

		String connectionUrl = "jdbc:mysql://localhost:3306/sakila?user=root&password=abcd1234";
		String query = queryToDB;

		Connection conn = null;

		try {

			// Ustawiamy dane dotycz¹ce pod³¹czenia
			conn = DriverManager.getConnection(connectionUrl);

			// Ustawiamy sterownik MySQL
			Class.forName("com.mysql.jdbc.Driver");

			// Uruchamiamy zapytanie do bazy danych
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				dataFromBase = rs.getString(1);
				list.add(dataFromBase);

			}
			System.out.println(list.size());

			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch (SQLException e2) {
			e2.printStackTrace();
		}
		return list;

	}

	public static List<String> createPhoneQuery(List<String> list, String queryToDB) {

		String connectionUrl = "jdbc:mysql://localhost:3306/sakila?user=root&password=abcd1234";
		String query = queryToDB;

		Connection connection = null;

		try {

			// Ustawiamy dane dotycz¹ce pod³¹czenia
			connection = DriverManager.getConnection(connectionUrl);

			// Ustawiamy sterownik MySQL
			Class.forName("com.mysql.jdbc.Driver");

			// Uruchamiamy zapytanie do bazy danych
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				dataFromBase = rs.getString(1);
				list.add(dataFromBase);

			}
			System.out.println(list.size());

			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch (SQLException e2) {
			e2.printStackTrace();
		}
		return list;

	}

	public static String mailQuery() {
		return "Select email from customer";
	}

	public static String phoneQuery() {
		return "Select phone from customer join address on customer.address_id=address.address_id";
	}

}
