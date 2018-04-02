import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;


public class EmployeeDAO {
	Connection c = null;
	Statement s = null;
	ResultSet r = null;
	
	public static void SelectAllEmployees() throws SQLException {

		Connection dbConnection = null;
		Statement statement = null;
		ResultSet resultset = null;
		
		//creates a query to select all users in the table
		String query = "SELECT * FROM employees;";


		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println(query);

			// execute SQL query

			resultset = statement.executeQuery(query);

			//displays all records in the table for testing
			while (resultset.next()) {
				System.out.println(resultset.getString("ID") + " "
						+ resultset.getString("Name")+ " "
						+ resultset.getString("Gender")+ " "
						+ resultset.getString("DOB")+ " "
						+ resultset.getString("Address")+ " "
						+ resultset.getString("Postcode")+ " "
						+ resultset.getString("NIN")+ " "
						+ resultset.getString("JobTitle")+ " "
						+ resultset.getString("StartDate")+ " "
						+ resultset.getString("Salary")+ " "
						+ resultset.getString("Email"));
			}	

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (resultset != null) {
				resultset.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}
	
	public static void InsertEmployee(String column) throws SQLException {

		Connection dbConnection = null;
		Statement statement = null;
		ResultSet resultset = null;
		
		//creates a query to insert data into the table 
		String query = "INSERT INTO employees (ID, Name, Gender, DOB, Address, Postcode, NIN, JobTitle, StartDate, Salary, Email) VALUES ("+ column + ");";


		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println(query);

			// execute SQL query

			resultset = statement.executeQuery(query);
			
			//displays all records in the table for testing
			while (resultset.next()) {
				System.out.println(resultset.getString("ID") + " "
						+ resultset.getString("Name")+ " "
						+ resultset.getString("Gender")+ " "
						+ resultset.getString("DOB")+ " "
						+ resultset.getString("Address")+ " "
						+ resultset.getString("Postcode")+ " "
						+ resultset.getString("NIN")+ " "
						+ resultset.getString("JobTitle")+ " "
						+ resultset.getString("StartDate")+ " "
						+ resultset.getString("Salary")+ " "
						+ resultset.getString("Email"));
			}	

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (resultset != null) {
				resultset.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}
	
	public static void DeleteEmployee(String id) throws SQLException {

		Connection dbConnection = null;
		Statement statement = null;
		ResultSet resultset = null;
		
		//creates a query to delete a record from the table
		String query = "DELETE FROM employees WHERE ID="+ id +";";


		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println(query);

			// execute SQL query

			resultset = statement.executeQuery(query);
	

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (resultset != null) {
				resultset.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}
	
	public ArrayList<Employee> getEmployees() throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet resultset = null;
		
		//creates an array list to store the records from the table
		ArrayList<Employee> employees = new ArrayList<Employee>();
		Employee temp; // Giving an object to employee

		String query = "SELECT * FROM employees;";
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println(query);
			// execute SQL query
			resultset = statement.executeQuery(query);
			while (resultset.next()) {
				
				//stores the records into a variable temporarily
				String id = resultset.getString("ID");
				String name = resultset.getString("Name");
				String gender = resultset.getString("Gender");
				String dob = resultset.getString("DOB");
				String nin = resultset.getString("NIN");
				String title = resultset.getString("JobTitle");
				String start = resultset.getString("StartDate");
				String salary = resultset.getString("Salary");
				String email = resultset.getString("Email");
				String address = resultset.getString("Address");
				String postcode = resultset.getString("Postcode");
				
				//converts the gender string into a char
				char genderChar = gender.charAt(0);
				//creates a temporary list of the records selected 
				temp = new Employee(name, genderChar, nin, dob, address, postcode, id, salary, start, title, email);
				//adds the temporary list onto the main array list 
				employees.add(temp);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (resultset != null) {
				resultset.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return employees;
	}
	
	
	//connects to the table 
	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName("org.sqlite.JDBC");

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			String dbURL = "jdbc:sqlite:empdb.sqlite";	         		
			dbConnection = DriverManager.getConnection(dbURL);
			return dbConnection;

		} catch (SQLException e) {

		}

		return dbConnection;
	}
	
}
