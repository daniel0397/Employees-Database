public class Employee extends Person {
	private String id;
	private String salary;
	private String startDate;
	private String title;
	private String email;
	
	//creates set and get methods for some of the columns in the table 
	//and adds all of the columns into a class used to display records
	public Employee(String name, char gender, String Nin, String dob, String address, String postcode, String id,
			String salary, String start, String title, String email) {
		super(name, gender, Nin, dob, address, postcode);
		this.id = id;
		this.salary = salary;
		this.startDate = start;
		this.title = title;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String toString() {
		return "Id;" + id + "Salary;" + salary + "Start Date;" + startDate + "Title;" + title + "Email;" + email;
	}	
}
