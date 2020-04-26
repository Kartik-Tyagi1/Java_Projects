/*
 * Kartik Tyagi 
 * Assignment 4
 * 
 * LED class
 * 
 * This class inherits from the screen class. Therefore it must define the equals() and getType() functions
 * 		equals() returns true or false if the object we are comparing to a LED object has the same sale price
 * 		getType() will return a string "LED"
 * 
 * 
 */


import java.util.Date;

public class LED extends ComputerMonitor{

	public LED(long id, double salePrice, Date makeDate, String manufacturer, String model) {
		super(id, salePrice, makeDate, manufacturer, model);
	}

	// Abstract Method from Screen class
	public String getType() {
		
		return "LED"; 
	}

	
	// Abstract Method from Screen class
	public boolean equals(Object temp) {
		// If the sale price of LED is equal to Sale price of object
		boolean output = false;
		
		if(temp instanceof LED) {
			if(getSalePrice() == ((Screen) temp).getSalePrice()) {   
				output = true;
			}
		}
		
		else if(temp instanceof SmartTV) {
			if(getSalePrice() == ((Screen) temp).getSalePrice()) {   
				output = true;
			}
		}
		
		else if(temp instanceof CRT) {
			if(getSalePrice() == ((Screen) temp).getSalePrice()) {   
				output = true;
			}
		}
		else if(temp instanceof ComputerMonitor) {
			if(getSalePrice() == ((Screen) temp).getSalePrice()) {   
				output = true;
			}
		}
		
		return output;
		
	}
	
	
} // end of LED class
