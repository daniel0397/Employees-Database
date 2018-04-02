//Daniel Smith 15075097
public class Person {
	private String name;
	private char gender;
	private String NIN; 
	private String dob;
	private String address;
	private String postcode;
	
	//creates set and get methods for some of the columns in the table
	public Person(String name, char gender, String nin, String dob, String address, String postcode) {
		this.name = name;
		this.gender = gender;
		this.NIN = nin;
		this.dob = dob;
		this.address = address;
		this.postcode = postcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getNIN() {
		return NIN;

	}

	public void setNIN(String NIN) {
		this.NIN = NIN;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public String setPostcode(String postcode) {
		return postcode;
	}

	public String toString() {
		return "Name;" + name + "Gender;" + gender + "National Insurance Number;" + NIN + "Date Of Birth;" + dob
				+ "Address;" + address + "Postcode;" + postcode;

	}
	
}
