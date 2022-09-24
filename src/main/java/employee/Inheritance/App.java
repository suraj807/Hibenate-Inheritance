

package employee.Inheritance;

import java.util.List;
import java.util.Scanner;



public class App 
{
	// MAIN METHOD
    public static void main( String[] args )
    {
    	Scanner scan = new Scanner(System.in);
    	int Id,salary,hike,experience,contract,choice=0;
    	String name;
    	
    	// CREATING OBJECT OF EMPLOYEE
    	employee emp = new employee();
    	// CREATING OBJECT OF FRESHER EMPLOYEE
    	FresherEmployee femp = new FresherEmployee();
    	// CREATING OBJECT OF EXPERIENCED EMPLOYEE
    	ExperienceEmployee Eemp = new ExperienceEmployee();	
    	//CREATING OBJECT OF EMPLOYEE DAO
    	employeeDao dao = new employeeDao();
    	
    	while(choice<7) {
			System.out.println("\nPress 1 - New Register \nPress 2 - Register as Fresher \nPress 3 - Rgister as Experienced \nPress 4 - Print Employee \nPress 5 - Print All Employee \nPress 6 - Remove Employee \nPress 7 - Exit");
			System.out.print("ENTER CHOICE : ");
			choice = scan.nextInt();
			
			
			switch(choice) {
			
			// first Case
			// to add employee
			case 1->{
				System.out.print("Enter Name:");
				name = scan.next();
				emp.setEmpName(name);
				
				// CALLLING CONNECT METHOD TO START SESSION
				dao.connect();
				dao.registerEmp(emp);// ADDING EMPLOYEE IN DATABASE
				System.out.println(emp);
				
				// CALLING DISCONNECT METHOD TO END SESSION
				dao.disconnect();
			}
			
			// SECOND CLASS
			// TO ADD FRESHER EMPLOYEE
			case 2->{
				System.out.print("Enter Name:");
				name = scan.next();
				femp.setEmpName(name);
				System.out.print("Enter Salary:");
				salary = scan.nextInt();
				femp.setSalary(salary);
				System.out.print("Enter Contract Period:");
				contract = scan.nextInt();
				femp.setContractPeriod(contract);
				System.out.print("Enter Increment:");
				hike = scan.nextInt();
				femp.setIncrement(hike);
				
				// CALLLING CONNECT METHOD TO START SESSION
				dao.connect();
				dao.registerEmp(femp);
				System.out.println(femp);// ADDING FRESER IN DATABASE
				
				// CALLING DISCONNECT METHOD TO END SESSION
				dao.disconnect();
			}
			
			// THIRD CLASS
			// TO ADD EXPEREINCED EMPLOYEE
			case 3->{
				System.out.print("Enter Name:");
				name = scan.next();
				Eemp.setEmpName(name);
				System.out.print("Enter Salary:");
				salary = scan.nextInt();
				Eemp.setSalary(salary);
				System.out.print("Enter Experience:");
				experience = scan.nextInt();
				Eemp.setExperience(experience);
				System.out.print("Enter hike:");
				hike = scan.nextInt();
				Eemp.setHike(hike);
				
				// CALLLING CONNECT METHOD TO START SESSION
				dao.connect();
				dao.registerEmp(Eemp);// ADDING EXPERIENCED IN DATABASE
				System.out.println(Eemp);
				
				// CALLING DISCONNECT METHOD TO END SESSION
				dao.disconnect();
			}
			
			// FOURTH CLASS
			// TO FETCH EMPLOYEE DETAIL
			case 4 ->{
				System.out.print("Enter Id:");
				Id = scan.nextInt();
				
				// CALLLING CONNECT METHOD TO START SESSION
				dao.connect();
				try {
				emp = dao.fetchEmp(Id);// FETCHING AN EMPLOYEE DETAIL FROM DATABASE
				System.out.println(emp);
				}
				catch(Exception e) {
					System.out.println("Employee does not exist");
				}
				
				// CALLING DISCONNECT METHOD TO END SESSION
				dao.disconnect();
			}
			
			// FIFTH CASE
			// TO FETCH DETAILS OF EVERY EMPLOYEE
			case 5 ->{
				
				// CALLLING CONNECT METHOD TO START SESSION
				dao.connect();
				List<employee> empl = dao.fetchAll();// FETCHING ALL EMPLOYEE DETAIL FROM DATABASE
				
				// CALLING DISCONNECT METHOD TO END SESSION
				dao.disconnect();
				for(employee e : empl)
					System.out.println(e);
			}
			
			// SIXTH CASE
			// TO DELETE EMPLOYEE FORM DATABASE
			case 6 ->{
				
				// CALLLING CONNECT METHOD TO START SESSION
				dao.connect();
				System.out.print("Enter Id : ");
				Id = scan.nextInt();// ASKING USER TO INPUT ID
				int ret = dao.deleteEmp(Id);// REMOVING EMPLOYEE FROM DATABASE
				
				// CALLING DISCONNECT METHOD TO END SESSION
				dao.disconnect();
				if (ret==1)
					System.out.println("Employee removed Successfully.");
				else
					System.out.println("Employee does not exist!!!");
			}
			}
    	}
    	
    	// CLOSING SCANNER OBJECT
    	scan.close();
    }
}
