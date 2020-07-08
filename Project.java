import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;
import java.util.ListIterator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * This code captures, manages and manipulates projects information
 * <p>
 * @author ThaboTT
 * @version 2.3
 */
public class Project {
    /**
     * @throws IOException if an input or output exception occurred
     * 
     */
	public static void main(String[] args) throws IOException, ParseException {
		/**
		 * Declares new project object and its stakeholders
		 * @see Class#ProjectDetails
		 * @see Class#Stakeholders
		 */
		ProjectDetails lwazi = new ProjectDetails();     //Project object (lwazi) declared with class 'ProjectDetails'
		Stakeholders contractor = new Stakeholders();
		Stakeholders architect = new Stakeholders();
		Stakeholders client = new Stakeholders();
		Stakeholders [] personnel = {architect, contractor, client};    //Stakeholder objects declared with class 'Stakeholders'
		
		// variable to get input from the scanner
		Scanner s = new Scanner(System.in);      //For integer inputs
		Scanner n = new Scanner(System.in);      //For String inputs
	    /**
	     * Provides a menu to the management system
	     */
		//Provides a menu for the user
		System.out.println("Please select from the following: ");
		System.out.println(" 1 - Add a new project");
		System.out.println(" 2 - Change the due date");
		System.out.println(" 3 - Change amount paid");
		System.out.println(" 4 - Update contractor's details");
		System.out.println(" 5 - Finalise the project");
		System.out.println(" 6 - See a list of incomplete projects");
		System.out.println(" 7 - See a list of overdue projects");
		
		int choice = s.nextInt();
		if (choice < 1 || choice > 7) {
			throw new IllegalArgumentException( );}  //To ensure that a valid choice is inputted.
			
		if (choice == 1)	//Capture project details
		/**
		 * @see Method#getProjectDetails
		 */
		{
			getProjectDetails(lwazi, contractor, architect, client, personnel, s, n);	
		}
		/**
		 * @see Method#editDeadline
		 */
		else if (choice == 2) //Edit project deadline
		{   
			editDeadline(n);
		}
		/**
		 * Reads the file CompletedProjects and creates list which is searched for project number 
		 * or name.
		 * the project amount index can then be edited there after a new line with new project amount
		 * is written back the CompletedProjects File overwriting the previous one 
		 * @see Method#editAmountPaidToDate
		 * @see Method#writeToFile
		 * @throws FileNotFoundException if the file being created or written is absent
		 */
		//To edit the project amount paid to date
		else if (choice == 3)
		{
			try{
				FileInputStream n3 = new FileInputStream("C:\\Users\\marshal.delladmin\\Dropbox\\Thabo tahana Tichareva-47200"
                                                    + "\\Introduction to Software Engineering\\Task 24\\CompletedProject.txt");
			     BufferedReader nb = new BufferedReader(new InputStreamReader(n3));
			     String fileLines;
			     StringBuilder fileItems = new StringBuilder();
			     
			     while((fileLines = nb.readLine()) != null)
			     {
			    	 String keyWord[] = fileLines.split(",");
			    	 if(keyWord.length > 0)
			    	 {   //To select the project to edit the amount
			    	     System.out.println("Enter the new project name or number: ");
			    	     String num = n.nextLine();
			    	     
			    	     if(keyWord[0].equals(num) || keyWord[1].equals(num))   //Checks project number or name
			    	     {
			    		     editAmountPaidToDate(n, fileItems, keyWord);
			    	     }
			    	     else
			    	     {
			    	    	 fileItems.append(fileLines);
			    	     }
			    	 }		    	     	
			     }
			     //To write edited project information to file
			     writeToFile(n3, fileItems);
			}
		    
			catch (FileNotFoundException e) {
				System.out.println("Error");
		  }		
		}
		/**
		 * @see #Choice == 3
		 * @see #method(Scanner, StringBuilder, String[])
		 * @see #method(FileInputStream, StringBuilder)
		 */
		else if (choice == 4) //To update contractor's details
		{
			try{
				FileInputStream n3 = new FileInputStream("C:\\Users\\marshal.delladmin\\Dropbox\\Thabo tahana Tichareva-47200"
                                                    + "\\Introduction to Software Engineering\\Task 24\\CompletedProject.txt");
			     BufferedReader nb = new BufferedReader(new InputStreamReader(n3));
			     String fileLines;
			     StringBuilder fileItems = new StringBuilder();
			     
			     while((fileLines = nb.readLine()) != null)
			     {
			    	 String keyWord[] = fileLines.split(",");
			    	 if(keyWord.length > 0)
			    	 {   //To select the project to edit contractor's contact details
			    	     System.out.println("Enter the new project name or number: ");
			    	     String num = n.nextLine();
			    	     
			    	     if(keyWord[0].equals(num) || keyWord[1].equals(num))   //Checks project number or name
			    	     {
			    	    	 changeContactDetails(n, fileItems, keyWord);
			    	     }
			    	     else
			    	     {
			    	    	 fileItems.append(fileLines);
			    	     }
			    	 }		    	 	    	
			     }
			     writeToFile(n3, fileItems);
			}
		
			catch (FileNotFoundException e) {
				System.out.println("Error");
		  }	
		}
		
		/**
		 * @see #choice == 3
		 * @see #method(Scanner, StringBuilder, String[])
		 * @see #method(FileInputStream, StringBuilder)
		 */
		else if (choice == 5) //To finalise Project
		{		
			try{
				FileInputStream ns = new FileInputStream("C:\\Users\\marshal.delladmin\\Dropbox\\Thabo tahana Tichareva-47200"
                                                    + "\\Introduction to Software Engineering\\Task 24\\CompletedProject.txt");
			     BufferedReader na = new BufferedReader(new InputStreamReader(ns));
			     String fileLines;
			     StringBuilder fileItems = new StringBuilder();
			     
			     while((fileLines = na.readLine()) != null)
			     {
			    	 String keyWord[] = fileLines.split(",");
			    	 if(keyWord.length > 0)
			    	 {   //To select project to finalise
			    	     System.out.println("Enter the new project name or number: ");
			    	     String num = n.nextLine();
			    	     
			    	     if(keyWord[0].equals(num) || keyWord[1].equals(num)) 
			    	     {
			    		     finaliseProject(n, fileItems, keyWord);
			    	     }
			    	     else
			    	     {
			    	    	 fileItems.append(fileLines);
			    	     }
			    	 }		    	 	    	
			     }
			          writeToFile(ns, fileItems);
			}
		
			catch (FileNotFoundException e) {
				System.out.println("Error");
		    }						            
		}
		/** 
		 * Checks for indexes with word "incomplete" which indicates that the project is incomplete.
		 * The identified lines are then displayed using project number and name which is index 0 and 1.
		 * @see #choice == 2
		 */
		else if (choice == 6)  //To List incomplete projects
		{
			try{
				BufferedReader ns = new BufferedReader(new FileReader("C:\\Users\\marshal.delladmin\\Dropbox\\Thabo tahana Tichareva-47200"
                                                    + "\\Introduction to Software Engineering\\Task 24\\CompletedProject.txt"));
			     String fileLines;   //To store lines read from file
			     
			     while((fileLines = ns.readLine()) != null)
			     {
			    	 String keyWord[] = fileLines.split(",");
			    	 
			    	 if(fileLines.contains("Incomplete")) //Checks if the project is Incomplete
			    	 {   //Displays list of incomplete projects according to project number and respective project name 
			    		 System.out.println("List of Incomplete Projects\n");
			    		 System.out.println("Project Number: " + keyWord[0]);
			    		 System.out.println("Project Name: " + keyWord[1] + "\n");	 			    		 
			    	 }
			    	 else 
			    	 {
			    		 System.out.println("All projects are complete");
			    	 }
		          }
	            }
			catch (FileNotFoundException e) {
				System.out.println("Error");
		       }
			}
		/**
		 * Compares the current date with the project deadline at index 7.
		 * @see #choice == 2
		 */
		else if (choice == 7)  //To List overdue projects
		{
			try{
				BufferedReader ns = new BufferedReader(new FileReader("C:\\Users\\marshal.delladmin\\Dropbox\\Thabo tahana Tichareva-47200"
                                                    + "\\Introduction to Software Engineering\\Task 24\\CompletedProject.txt"));
			     String fileLines;   //To store lines read from file
			     
			     while((fileLines = ns.readLine()) != null)
			     {
			    	 String keyWord[] = fileLines.split(",");
			    	 SimpleDateFormat f = new SimpleDateFormat("dd MMMM yyyy");  //Imposing date format for comparison
			    	 Date date = new Date();                                    //Gets todays date
			    	 Date projectDeadLine = new SimpleDateFormat("dd MMMM yyyy").parse(keyWord[7]);  //Converts string to date
			    	 
			    	 if(projectDeadLine.compareTo(date) < 0) //Checks if the project is overdue
			    	 {   //Displays list of overdue projects according to project number and respective project name 
			    		 System.out.println("List of overdue Projects\n");
			    		 System.out.println("Project Number: " + keyWord[0]);
			    		 System.out.println("Project Name: " + keyWord[1] + "\n");	 			    		 
			    	 }	
			    	 else
			    	 {
			    		 System.out.println("All projects are on schedule" + date);
			    	 }
		          }
	            }
			catch (FileNotFoundException e) {
				System.out.println("Error");
		       }		
		}
	}
    /**
     *  
     * @param ns writes on the file
     * @param fileItems stores the elements to be written on the file
     * @see Class#Project
     */
    //Method to write to file
	private static void writeToFile(FileInputStream ns, StringBuilder fileItems) throws IOException {
		FileWriter nr = new FileWriter("C:\\Users\\marshal.delladmin\\Dropbox\\Thabo tahana Tichareva-47200"
		                                 + "\\Introduction to Software Engineering\\Task 24\\CompletedProject.txt");
		 BufferedWriter nw = new BufferedWriter(nr);
		 nw.write(fileItems.toString());
		 nw.close();
	}
    /**
     * After editing the date, the string list is converted to an Arraylist.
     * @param n allows for inputs
     * @see Class#Project
     * @see method#writeToFile
     */
	private static void editDeadline(Scanner n) throws IOException {
		//Reads from the 'Completed file Project'
		try{
			FileInputStream ns = new FileInputStream("C:\\Users\\marshal.delladmin\\Dropbox\\Thabo tahana Tichareva-47200"
		                                        + "\\Introduction to Software Engineering\\Task 24\\CompletedProject.txt");
		     BufferedReader na = new BufferedReader(new InputStreamReader(ns));
		     String fileLines;
		     StringBuilder fileItems = new StringBuilder();
		     
		     while((fileLines = na.readLine()) != null)
		     {
		    	 String keyWord[] = fileLines.split(","); //make a list of the file contents
		    	 if(keyWord.length > 0)
		    	 {   //To select the project to edit the deadline
		    	     System.out.println("Enter the new project name or number: ");
		    	     String num = n.nextLine();
		    	     
		    	     if(keyWord[0].equals(num) || keyWord[1].equals(num)) 
		    	     {
		    		     System.out.println("Enter new deadline (dd mmmm yyyy: ");
		    		     keyWord[7] = n.nextLine();                //To edit the deadline
		    		     List<String> newLine = new ArrayList<String>(Arrays.asList(keyWord));  // creates a resizeable list using collections
		    		      
		    		     ListIterator<String> iterator = newLine.listIterator();
		    		     //use iterator methods to access elements
		    		     while(iterator.hasNext()) {
		    		     fileItems.append(iterator.next() + ", ");
		    		     }
		    	     }
		    	     else
		    	     {
		    	    	 fileItems.append(fileLines);
		    	     }
		    	 }		    	   	
		     }
		     //Write the new line with new deadline
		     writeToFile(ns, fileItems);
		}

		catch (FileNotFoundException e) {
			System.out.println("Error");
        }
	}
	/**
	 * This method captures project details and writes them on the CompletedProject text file.
	 * @param lwazi project object
	 * @param contractor project stakeholder object
	 * @param architect project stakeholder object
	 * @param client project stakeholder object
	 * @param personnel string list of project stakeholders
	 * @param s to take in integer input
	 * @param n to take in string input
	 */
    //Method to capture project data
	private static void getProjectDetails(ProjectDetails lwazi, Stakeholders contractor, Stakeholders architect,
			Stakeholders client, Stakeholders[] personnel, Scanner s, Scanner n) {
		System.out.println("Enter project number: ");    
		lwazi.projectNumber = s.nextInt();

		System.out.println("Enter project name: ");
		lwazi.projectName = n.nextLine();

		System.out.println("Enter building design: ");
		lwazi.buildingDesign = n.nextLine();

		System.out.println("Enter physical address: ");		    
		lwazi.physicalAddress = n.nextLine();

		System.out.println("Enter erf number: ");		    
		lwazi.erfNumber = s.nextInt();
		
		System.out.println("Enter project total fee: ");
		lwazi.projectTotalFee = s.nextInt();
		
		System.out.println("Enter the amount paid to date: ");
		lwazi.amountPaidToDate = s.nextInt();

		System.out.println("Enter project deadline (dd mmmm yyyy): ");
		lwazi.projectDeadline = n.nextLine();

		System.out.println("Enter project status: ");
		lwazi.projectStatus = n.nextLine();
		
		//Input details for project stakeholders
		String[] stakeholders = {"Architect", "Contractor", "Client"};
		System.out.println("Enter the details for the following: ");
		for (int i = 0; i < 3; i++)
		{
			System.out.println(stakeholders[i]);
			
		    System.out.println("Enter name: ");
		    personnel[i].name = n.nextLine();
		    
		    System.out.println("Enter surname: ");
		    personnel[i].surname = n.nextLine();	

		    System.out.println("Enter telephone number: ");
		    personnel[i].telNumber = s.nextInt();

		    System.out.println("Enter email address: ");
		    personnel[i].email = n.nextLine();

		    System.out.println("Enter physical address: ");
		    personnel[i].physicalAddress = n.nextLine();
		}

		try {
			FileWriter f = new FileWriter("C:\\Users\\marshal.delladmin\\Dropbox\\Thabo tahana Tichareva-47200"
			                            + "\\Introduction to Software Engineering\\Task 24\\CompletedProject.txt", true);
			Formatter ff = new Formatter(f);
			
			// write the formatted strings to the "CompletedProject" file
			ff.format("%s %s %s %s %s", lwazi, architect, contractor, client, "\r\n");
			f.close();    
			} 
  
			catch (Exception e) {
				System.out.println("Error");
			}
	}
	/**	
	 * This method finalises the project by creating an invoice if the full project amount is not paid.
	 * Completed date is added and project status changed to complete
	 * @param n allows for string input
	 * @param fileItems stores edited project elements
	 * @param keyWord stores the list type of project elements
	 * @param project amount is the project price
	 * @param amount paid reflects the figure paid to date
	 * @see method#editDeadline
	 */
	public static void finaliseProject(Scanner n, StringBuilder fileItems, String[] keyWord) {
		 String a = keyWord[5];
		 String b = keyWord[6];
		 double projectAmount = Double.valueOf(a);
		 double amountPaid = Double.valueOf(b);
		 //If client is still owing an invoice will be generated
		 if(projectAmount != amountPaid)
		 {
		     getInvoice(keyWord, projectAmount, amountPaid);			    	 			
			  	    		 
		     System.out.println("Enter project status: ");
		     keyWord[8] = n.nextLine();                //To edit project status
		     System.out.println("Enter project completion date (dd mmmm yyyy): ");
		     keyWord[9] = n.nextLine();                //To add completion date
		 
		     List<String> newLine = new ArrayList<String>(Arrays.asList(keyWord)); 
		      
		     ListIterator<String> iterator = newLine.listIterator();
		     //use iterator methods to access elements
		     while(iterator.hasNext()) {
		     fileItems.append(iterator.next() + ", ");
		     }
		 }
		 	//If the client is not owing an invoice wont be generated
		 else 
		 {
			 System.out.println("Enter project status: ");
		     keyWord[8] = n.nextLine();                //To edit project status
		     System.out.println("Enter project completion date (dd mmmm yyyy): ");
		     keyWord[9] = n.nextLine();                //To add completion date
		     	     
		      List<String> newLine = new ArrayList<String>(Arrays.asList(keyWord));  
		      
		     ListIterator<String> iterator = newLine.listIterator();
		     //use iterator methods to access elements
		     while(iterator.hasNext()) {
		     fileItems.append(iterator.next() + ", ");
		     }
		  }
	}
    /**
     * This method writes the project invoice
     * @see method#finaliseProject
     * @param keyWord
     * @param projectAmount
     * @param amountPaid
     * 
     */
	public static void getInvoice(String[] keyWord, double projectAmount, double amountPaid) {
		double balance = projectAmount - amountPaid;
	
		 try {
			Formatter p = new Formatter("C:\\Users\\marshal.delladmin\\Dropbox\\Thabo tahana Tichareva-47200"
			                            + "\\Introduction to Software Engineering\\Task 24\\invoice.txt");
					
			// print the formatted strings to the file as invoice
			p.format("%s %s %s %s %s", keyWord[20], keyWord[21], keyWord[22], keyWord[23], balance);
			p.close();    
			} 
	 		  
			catch (Exception e) {
				System.out.println("Error");
			}
	}
   /**
    * This method edits the project amount paid to date
    * @see method#finaliseProject
    * @param n
    * @param fileItems
    * @param keyWord
    */
	public static void editAmountPaidToDate(Scanner n, StringBuilder fileItems, String[] keyWord) {
		System.out.println("Enter new amount paid to date: ");
		 double amount = n.nextInt();
		 keyWord[6] = String.valueOf(amount);      //To edit the amount
		 
		 List<String> newLine = new ArrayList<String>(Arrays.asList(keyWord));  
	      
	     ListIterator<String> iterator = newLine.listIterator();
	     //use iterator methods to access elements
	     while(iterator.hasNext()) {
	     fileItems.append(iterator.next() + ", ");
	     }
	}
    /**
     * This method changes the contractors contact details.
     * @see method#finaliseProject
     * @param n
     * @param fileItems
     * @param keyWord
     */
	public static void changeContactDetails(Scanner n, StringBuilder fileItems, String[] keyWord) {
		System.out.println("Enter the contractor's new telephone number: ");
		 keyWord[17] = n.nextLine();      //To edit the telephone number
		 System.out.println("Enter the contractor's new email address: ");
		 keyWord[18] = n.nextLine();      //To edit the email address
		 
		 List<String> newLine = new ArrayList<String>(Arrays.asList(keyWord));
	      
	     ListIterator<String> iterator = newLine.listIterator();
	     //use iterator methods to access elements
	     while(iterator.hasNext()) {
	     fileItems.append(iterator.next() + ", ");
	     }
	}
}