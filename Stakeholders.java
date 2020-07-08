//Defines the attributes and the methods of project personnel
public class Stakeholders {
	
	//attributes
	String name;
	String surname;
	int telNumber;
	String email;
	String physicalAddress;
	
	//Methods
	  //Constructor
	public Stakeholders() {
		
	}
	
	public String getName() {
	    return name;
	   }  
		
	public String getSurname() {
	    return surname;
	   }  
	
	public String getEmail() {
		return email; 
	    }
	   
	public String getPhysicalAddress() {
		return physicalAddress; 
	    }
	 
	   //format to display the outputs
	   public String toString() {
	      String output = name + ", ";
	      output += surname + ", ";
	      output += telNumber + ", ";
	      output += email + ", ";
	      output += physicalAddress + ", ";
	      
	      return output;
	   }


}
