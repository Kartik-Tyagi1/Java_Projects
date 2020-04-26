/*
 * Kartik Tyagi 
 * Assignment 4
 * 
 * CRT class
 * 
 * This class inherits from the ComputerMonitor class which inherits from screen class. 
 * This class is more specific than just a screen because it is type of computer monitor so it is more specific
 * 
 * Therefore it must define the equals() and getType() functions
 * 		equals() returns true or false if the object we are comparing to a CRT object has the same ID number 
 * 		getType() will return a string "CRT"
 * 
 * This class also declares a new member variable called glassThickness
 * 
 */


import java.util.Date;

public class CRT extends ComputerMonitor {

	private double glassThickness;
	
	
	public CRT(double glassThickness, long id, double salePrice, Date makeDate, String manufacturer, String model) {
		super(id, salePrice, makeDate, manufacturer, model);
		this.glassThickness = glassThickness;	
	}


	// Abstract Method from Screen class
	public String getType() {
		
		return "CRT"; 
	}
	
	// Abstract Method from Screen class
	public boolean equals(Object temp) {
		// If the id of CRT is equal to id of object
		
		boolean output = false;
		
		if(temp instanceof LED) {
			if(getId() == ((Screen) temp).getId()) {   
				output = true;
			}
		}
		
		else if(temp instanceof SmartTV) {
			if(getId() == ((Screen) temp).getId()) {   
				output = true;
			}
		}
		
		else if(temp instanceof CRT) {
			if(getId() == ((Screen) temp).getId()) {   
				output = true;
			}
		}
		else if(temp instanceof ComputerMonitor) {
			if(getId() == ((Screen) temp).getId()) {   
				output = true;
			}
		}
		
		return output;
	}
	
	
	// GETTER AND SETTER 
	public double getGlassThickness() {
		return glassThickness;
	}
	
	public void setGlassThickness(double glassThickness) {
		this.glassThickness = glassThickness;
	}


	
	

	
	
}
