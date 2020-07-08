
public class ProjectDetails {
		
		//Attributes
		int projectNumber;
		String projectName;
		String buildingDesign;
		String physicalAddress;
		int erfNumber;
		double projectTotalFee;
		double amountPaidToDate;
		String projectDeadline;
		String projectStatus;
		String dateOfCompletion;
		
		//Methods
		   //Constructor to create the objects
		   public ProjectDetails() {
			   
		   }
		   
		   public String getProjectName() {
		      return projectName;
		   }
		   
		   public String getBuildingDesign() {
			   return buildingDesign;
		   }
			
		   public String getPhysicalAddress() {
			   return physicalAddress; 
		    }
		   
		   public String getProjectStatus() {
			   return projectStatus; 
		    }
		   
		   public String getDateOfCompletion() {
			   return dateOfCompletion;
		   }
		 
		   //format to display the outputs
		   public String toString() {
		      String output = projectNumber + ", ";
		      output += projectName + ", ";
		      output += buildingDesign + ", ";
		      output += physicalAddress + ", ";
		      output += erfNumber + ", ";
		      output += projectTotalFee + ", ";
		      output += amountPaidToDate + ", ";
		      output += projectDeadline + ", ";
		      output += projectStatus + ", ";
		      output += dateOfCompletion + ", ";
		   
		      return output;
		   }


}
