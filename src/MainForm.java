//Daniel Smith 15075097
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MainForm extends JFrame 
	{
	//Create variables for form components 
	JLabel nameLbl, genderLbl, dobLbl, salaryLbl, ninLbl, emailLbl, startLbl, titleLbl, addressLbl, postcodeLbl, headerLbl;
	JTextField nameTxt, salaryTxt, ninTxt, emailTxt, titleTxt, addressTxt, postcodeTxt ; 
	JRadioButton maleRdb, fmaleRdb; 
	JComboBox<Integer> dobDayCmb, dobMonthCmb, dobYearCmb, startDayCmb, startMonthCmb, startYearCmb;
	JButton enterBtn, clearBtn, forwardBtn, backBtn, deleteBtn;
		
		//set's default values for the labels used
	public void LabelFormat(JLabel label, int y, String text){
		label = new JLabel(text);
		label.setFont(new Font("Main", Font.PLAIN, 14));
		label.setBounds(20, y, 210, 30);
		add(label);
			
	}
		//set's default values for the textboxes used
	public void TxtBoxFormat(JTextField txt, int y){
		//txt = new JTextField();
		txt.setFont(new Font("Main", Font.PLAIN, 14));
		txt.setBounds(300, y, 250, 30);
		add(txt);
			
	}
	//set's default values for the comboboxes used
	public void CmbBoxFormat(JComboBox<Integer> cmb, int x, int y, int w){
		cmb.setFont(new Font("Main", Font.PLAIN, 14));
		cmb.setBounds(x, y, w, 30);
		add(cmb);
			
	}
	
	//creates a default layout for the error messages
	public void ErrorMessage(String msg){
		JOptionPane.showMessageDialog(null, msg);
	}
	
	
	EmployeeDAO dao = new EmployeeDAO();  
	ArrayList<Employee> empList = dao.getEmployees(); // imports the arraylist from the EmployeeDOA class
	//Create a counter used to indentify the record selected
	int counter = -1;	
	public MainForm() throws SQLException 
	{
		super("Employee Record System Assignment");
		setLayout(null);
			
		//Creates a header at the top of the form
		headerLbl = new JLabel("Enter Employee Information");
		headerLbl.setFont(new Font("Header", Font.BOLD, 25));
		headerLbl.setBounds(230, 10, 600, 30);
		add(headerLbl);
		
		//Creates a label and textbox for the user to enter their name 
		LabelFormat(nameLbl, 70, "Enter Name:");
		nameTxt = new JTextField();
		TxtBoxFormat(nameTxt, 70);
		
		//Creates a label and two radio buttons for the user to select their gender 
		LabelFormat(genderLbl, 130,"Select Gender:");
		maleRdb =  new JRadioButton("Male");
		maleRdb.setBounds(300, 130, 100, 30);
		add(maleRdb);
		fmaleRdb =  new JRadioButton("Female");
		fmaleRdb.setBounds(410, 130, 100, 30);
		add(fmaleRdb);
		
		//Creates a label and comboboxes for the user to select their date of birth	
		LabelFormat(dobLbl, 190,"Select Date Of Birth:");
		dobDayCmb = new JComboBox<>();
		CmbBoxFormat(dobDayCmb, 300, 190, 70);
		dobMonthCmb = new JComboBox<>();	
		CmbBoxFormat(dobMonthCmb, 370, 190, 80);
		dobYearCmb = new JComboBox<>();
		CmbBoxFormat(dobYearCmb, 450, 190, 100);
		
		//Creates a label and textbox for the user to enter their salary	
		LabelFormat(salaryLbl, 250,"Enter Salary:" );
		salaryTxt = new JTextField();
		TxtBoxFormat(salaryTxt, 250);
		
		//Creates a label and textbox for the user to enter their Nat Insc Number
		LabelFormat(ninLbl, 310, "Enter Nation Insurance Number:");
		ninTxt = new JTextField();
		TxtBoxFormat(ninTxt, 310);
		
		//Creates a label and textbox for the user to enter their email
		LabelFormat(emailLbl, 370, "Enter E-Mail Address:");
		emailTxt = new JTextField();
		emailTxt = new JTextField();
		TxtBoxFormat(emailTxt, 370);
		
		//Creates a label and comboboxes for the user to select their date of birth
		LabelFormat(startLbl, 430, "Select Start Date:");
		startDayCmb = new JComboBox<>();
		CmbBoxFormat(startDayCmb, 300, 430, 70);
		startMonthCmb = new JComboBox<>();
		CmbBoxFormat(startMonthCmb, 370, 430, 80);
		startYearCmb = new JComboBox<>();
		CmbBoxFormat(startYearCmb, 450, 430, 100);
			
		//Creates a label and textbox for the user to enter their job title
		LabelFormat(titleLbl, 490, "Enter Job Title:");
		titleTxt = new JTextField();
		TxtBoxFormat(titleTxt, 490);
		
		//Creates a label and textbox for the user to enter their address
		LabelFormat(addressLbl, 550, "Enter Address:");
		addressTxt = new JTextField();
		TxtBoxFormat(addressTxt, 550);
		
		//Creates a label and textbox for the user to enter their postcode
		LabelFormat(postcodeLbl, 610, "Enter Postcode:");
		postcodeTxt = new JTextField();
		TxtBoxFormat(postcodeTxt, 610);
		
		//Creates the buttons for the user to use
		enterBtn = new JButton("Enter");
		enterBtn.setBounds(650, 600, 100, 30);
		add(enterBtn);
		clearBtn = new JButton("Clear");
		clearBtn.setBounds(800, 600, 100, 30);
		add(clearBtn);
		forwardBtn = new JButton("Forward");
		forwardBtn.setBounds(650, 100, 100, 30);
		add(forwardBtn);
		backBtn = new JButton("Back");
		backBtn.setBounds(800, 100, 100, 30);
		add(backBtn);
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(675, 500, 200, 60);
		add(deleteBtn);
		
		//adds data into the comboboxes
		for(int i=1; i<32; i++){
			dobDayCmb.addItem(i);
			startDayCmb.addItem(i);
		}
		for(int i=1; i<12; i++){
			dobMonthCmb.addItem(i);
			startMonthCmb.addItem(i);
		}
		for(int i=1950; i<2017; i++){
			dobYearCmb.addItem(i);
			startYearCmb.addItem(i);
		}
			
		//when the clear button is pressed all textboxes and radio buttons are reset 
		clearBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				nameTxt.setText(" ");
				salaryTxt.setText(" ");
				ninTxt.setText(" ");
				emailTxt.setText(" ");
				titleTxt.setText(" ");
				addressTxt.setText(" ");
				postcodeTxt.setText(" ");
				maleRdb.setSelected(false);
				fmaleRdb.setSelected(false);
			}
		});
		
		
		forwardBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{   
					//checks that there are records after the current one to display
					if(counter < dao.getEmployees().size() - 1){ 
						counter++; //counter is moved so the next record is selected
						//Retrieves the records from the arraylist 
						nameTxt.setText(empList.get(counter).getName());
						char gender = empList.get(counter).getGender();
						ninTxt.setText(empList.get(counter).getNIN());
						String dob = empList.get(counter).getDob();
						addressTxt.setText(empList.get(counter).getAddress());
						postcodeTxt.setText(empList.get(counter).getPostcode());
						salaryTxt.setText(empList.get(counter).getSalary());
						String start = empList.get(counter).getStartDate();
						titleTxt.setText(empList.get(counter).getTitle());
						emailTxt.setText(empList.get(counter).getEmail());
						
						//displays the correct gender
						if(gender == 'M'){
							maleRdb.setSelected(true);
						}
						else{
							fmaleRdb.setSelected(true);
						}
						
						//the dob and start date strings are split up to be put into comboboxes
						String[] splitDob = dob.split("-");
						dobDayCmb.setSelectedIndex(Integer.valueOf(splitDob[0]) - 1);
						dobMonthCmb.setSelectedIndex(Integer.valueOf(splitDob[1]) - 1);
						dobYearCmb.setSelectedIndex(Integer.valueOf(splitDob[2]) - 1950);
						
						String[] splitStart = start.split("-");
						startDayCmb.setSelectedIndex(Integer.valueOf(splitStart[0]) - 1);
						startMonthCmb.setSelectedIndex(Integer.valueOf(splitStart[1]) - 1);
						startYearCmb.setSelectedIndex(Integer.valueOf(splitStart[2]) - 1950);	
					}
					else{ //if there are no records to display after the current ones this error message is displayed
						ErrorMessage("This is the last record in the database");
					}
				}catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
				
			}		
		});
		
		
		backBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
					if(counter != 0 ){ //checks that the current record isnt the first in the table
						counter--; //counter is moved so the previous record is selected
						//Retrieves the records from the arraylist 
						nameTxt.setText(empList.get(counter).getName());
						char gender = empList.get(counter).getGender();
						ninTxt.setText(empList.get(counter).getNIN());
						String dob = empList.get(counter).getDob();
						addressTxt.setText(empList.get(counter).getAddress());
						postcodeTxt.setText(empList.get(counter).getPostcode());
						salaryTxt.setText(empList.get(counter).getSalary());
						String start = empList.get(counter).getStartDate();
						titleTxt.setText(empList.get(counter).getTitle());
						emailTxt.setText(empList.get(counter).getEmail());
					
						//displays the correct gender
						if(gender == 'M'){
							maleRdb.setSelected(true);
						}
						else{
							fmaleRdb.setSelected(true);
						}
						
						//the dob and start date strings are split up to be put into comboboxes
						String[] splitDob = dob.split("-");
						dobDayCmb.setSelectedIndex(Integer.valueOf(splitDob[0]) - 1);
						dobMonthCmb.setSelectedIndex(Integer.valueOf(splitDob[1]) - 1);
						dobYearCmb.setSelectedIndex(Integer.valueOf(splitDob[2]) - 1950);
						
						String[] splitStart = start.split("-");
						startDayCmb.setSelectedIndex(Integer.valueOf(splitStart[0]) - 1);
						startMonthCmb.setSelectedIndex(Integer.valueOf(splitStart[1]) - 1);
						startYearCmb.setSelectedIndex(Integer.valueOf(splitStart[2]) - 1950);
					}
					else{ //if there are no records to display after the current ones this error message is displayed
						ErrorMessage("This is the first record in the database");
					}	
			}		
		});	
		
		enterBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
				String tempDob = null;
				String tempStart = null;
				String tempGen = null;
				//creates a unique id by adding one to the total records in the table as each records id is respective to its order in the table
				Integer y = dao.getEmployees().size() + 1;
				String id = y.toString();
				//edits the dob and start date to make sure they are the right format for the table
				if(dobDayCmb.getSelectedIndex() < 10 && dobMonthCmb.getSelectedIndex() < 10 ){
					tempDob = "0" + dobDayCmb.getSelectedItem().toString() + "-" + "0" + 
							dobMonthCmb.getSelectedItem().toString()+ "-" + dobYearCmb.getSelectedItem().toString();
				}
				else if(dobDayCmb.getSelectedIndex() < 10){
					tempDob = "0" + dobDayCmb.getSelectedItem().toString() + "-" + 
							dobMonthCmb.getSelectedItem().toString() + dobYearCmb.getSelectedItem().toString();	
				}
				else if(dobMonthCmb.getSelectedIndex() < 10){
					tempDob = dobDayCmb.getSelectedItem().toString() + "-" + "0" + 
							dobMonthCmb.getSelectedItem().toString()+ "-" + dobYearCmb.getSelectedItem().toString();
				}
				
				if(startDayCmb.getSelectedIndex() < 10 && startMonthCmb.getSelectedIndex() < 10 ){
					tempStart = "0" + startDayCmb.getSelectedItem().toString() + "-" + "0" + 
							startMonthCmb.getSelectedItem().toString()+ "-" + startYearCmb.getSelectedItem().toString();
				}
				else if(startDayCmb.getSelectedIndex() < 10){
					tempStart = "0" + startDayCmb.getSelectedItem().toString() + "-" + 
							startMonthCmb.getSelectedItem().toString() + startYearCmb.getSelectedItem().toString();	
				}
				else if(startMonthCmb.getSelectedIndex() < 10){
					tempStart = startDayCmb.getSelectedItem().toString() + "-" + "0" + 
							startMonthCmb.getSelectedItem().toString()+ "-" + startYearCmb.getSelectedItem().toString();
				}
				
				//selects the gender for the current record
				if (maleRdb.isSelected() == true)tempGen = "M";
				else if (fmaleRdb.isSelected() == true)tempGen = "F";
				//inserts all values entered by the user into a string in the right format for an sql query
				String employee = id + ", '" + nameTxt.getText() + "', '" + tempGen + "', '" + ninTxt.getText() + "', '" + tempDob + "', '" + addressTxt.getText() 
					+ "', '" + postcodeTxt.getText()+ "', '" + salaryTxt.getText() + "', '" + tempStart + "', '" + titleTxt.getText()+ "', '" + emailTxt.getText()+"'";
				
				//inserts the data into the table
					EmployeeDAO.SelectAllEmployees();
					EmployeeDAO.InsertEmployee(employee);
					EmployeeDAO.SelectAllEmployees();
				
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}	
			}
		});
		
		deleteBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(counter != -1){ //checks if a record is selected
					try{ //deletes the current record from the table
						EmployeeDAO.DeleteEmployee(empList.get(counter).getId());
					
					} catch (SQLException e1) {
						System.out.println(e1.getMessage());
					}
				}
				else{ //if no record is selected this error will display
					ErrorMessage("No record selected");
				}
				
			}
		});
			
		
	}
}
		
		//private class myEventHandler implements ActionListener{
			//public void actionPerformed(ActionEvent e){
				//if (e.getSource()==clearBtn){
				//}
				//else if (e.getSource()==enterBtn){
					//String tempDob = null;
					//String tempStart = null;
					//String tempGen = null;
					//String id = "1234";
					//if(dobDayCmb.getSelectedIndex() < 10 && dobMonthCmb.getSelectedIndex() < 10 ){
					//	tempDob = "0" + dobDayCmb.getSelectedItem().toString() + "/" + "0" + 
					//			dobMonthCmb.getSelectedItem().toString()+ "/" + dobYearCmb.getSelectedItem().toString();
					//}
					//else if(dobDayCmb.getSelectedIndex() < 10){
						//tempDob = "0" + dobDayCmb.getSelectedItem().toString() + "/" + 
						//		dobMonthCmb.getSelectedItem().toString() + dobYearCmb.getSelectedItem().toString();	
					//}
					//else if(dobMonthCmb.getSelectedIndex() < 10){
					//	tempDob = dobDayCmb.getSelectedItem().toString() + "/" + "0" + 
					//			dobMonthCmb.getSelectedItem().toString()+ "/" + dobYearCmb.getSelectedItem().toString();
					//}
					
					//if(startDayCmb.getSelectedIndex() < 10 && startMonthCmb.getSelectedIndex() < 10 ){
					//	tempStart = "0" + startDayCmb.getSelectedItem().toString() + "/" + "0" + 
					//			startMonthCmb.getSelectedItem().toString()+ "/" + startYearCmb.getSelectedItem().toString();
					//}
					//else if(startDayCmb.getSelectedIndex() < 10){
					//	tempStart = "0" + startDayCmb.getSelectedItem().toString() + "/" + 
					//			startMonthCmb.getSelectedItem().toString() + startYearCmb.getSelectedItem().toString();	
					//}
					//else if(startMonthCmb.getSelectedIndex() < 10){
					//	tempStart = startDayCmb.getSelectedItem().toString() + "/" + "0" + 
					//			startMonthCmb.getSelectedItem().toString()+ "/" + startYearCmb.getSelectedItem().toString();
					//}
					
				//	if (maleRdb.isSelected() == true)tempGen = "M";
				//	else if (fmaleRdb.isSelected() == true)tempGen = "F";
					//else if(maleRdb.isSelected() == true && fmaleRdb.isSelected() == true | maleRdb.isSelected() == false && fmaleRdb.isSelected() == false ) {
					//	ErrorMessage("Ivalid Gender");
					//}
					
					//else if(!salaryTxt.getText().contains("£")){
					//	ErrorMessage("Ivalid Salary");
					//}
					
					//else if(!emailTxt.getText().contains("@") && !emailTxt.getText().contains(".")){
					//	ErrorMessage("Invalid E-Mail Address");
					//}
					//else {
					//	error = false;
					//}
				//	if(error = false){		
				//		String employee = id + ", '" + nameTxt.getText() + "', '" + tempGen + "', '" + ninTxt.getText() + "', '" + tempDob + "', '" + addressTxt.getText() 
				//		+ "', '" + postcodeTxt.getText()+ "', '" + salaryTxt.getText() + "', '" + tempStart + "', '" + titleTxt.getText()+ "', '" + emailTxt.getText()+"'";
				//	try{
				//		EmployeeDAO.SelectAllEmployees();
				//		EmployeeDAO.InsertEmployee(employee);
						//EmployeeDAO.InsertEmployee("4, 'Test', 'M', 'hsg', 'sahgsg', 'sahasha', 'ahasghsgf', 'hasgsg', 'sgrwe', 'shbc', 'agsfsd'");
				//		EmployeeDAO.SelectAllEmployees();
					
				//	} catch (SQLException e1) {
				//		System.out.println(e1.getMessage());
				//	}	
				//	}
				//}
			



