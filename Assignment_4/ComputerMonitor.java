/*
 * Kartik Tyagi
 * Assignment 4
 * 
 * ComputerMonitor class
 * 
 * This class inherits from the screen class. However, because we are making this class abstract as well
 * 		there is no need to define the abstract methods in this class
 */



import java.util.Date;

public abstract class ComputerMonitor extends Screen{
	
	public ComputerMonitor(long id, double salePrice, Date makeDate, String manufacturer, String model) {
		super(id, salePrice, makeDate, manufacturer, model);
	}
	

} // end of ComputerMonitor class
