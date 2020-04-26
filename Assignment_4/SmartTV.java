/*
 * Kartik Tyagi 
 * Assignment 4
 * 
 * SmartTV class
 * 
 * This class inherits from the screen class. Therefore it must define the equals() and getType() functions
 * 		equals() returns true or false if the object we are comparing to a SmartTV object has the same model number 
 * 		getType() will return a string "Smart"
 * 
 * This class also declares a new member variable called operatingSystem
 * 
 */



import java.util.Date;

public class SmartTV extends Screen {

	private String operatingSystem;
	
	public SmartTV(String operatingSystem, long id, double salePrice, Date makeDate,  String manufacturer, String model) {
		// We use the super operator because we defined these variables in the superclass aka the screen class
		super(id, salePrice, makeDate, manufacturer, model);
		this.operatingSystem = operatingSystem;
	}
	
	
	// Abstract Method from Screen class
	public boolean equals(Object temp) { 
		// If the model of SmartTV is equal to model of the object
		
		boolean output = false;
		
		// First we use the instanceof operator to check if the object is of a specific type
		if(temp instanceof LED) {
			// If the object is of the type we want then we can cast it to that type and check if the model is the same
			if(getModel().equals(((Screen) temp).getModel())) {   
				output = true;
			}
		}
		
		else if(temp instanceof SmartTV) {
			if(getModel().equals(((Screen) temp).getModel())) {   
				output = true;
			}
		}
		
		else if(temp instanceof CRT) {
			if(getModel().equals(((Screen) temp).getModel())) {   
				output = true;
			}
		}
		else if(temp instanceof ComputerMonitor) {
			if(getModel().equals(((Screen) temp).getModel())) {   
				output = true;
			}
		}
		
		return output;
		
	}
	
	

	// Abstract Method from Screen class
	public String getType() {
		return "Smart" ; 
	}
	
	
	// GETTER AND SETTER 
	public String getOperatingSystem() {
		return operatingSystem;
	}
	
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	
	
	
} // end of SmartTV class
