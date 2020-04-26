/*
 * Kartik Tyagi 
 * Assignment 4
 * 
 * Screen Class
 * 
 * This is an abstract class that will be inherited from by SmartTV, LED, and ComputerMonitor. 
 * 
 * This class will provide the member variables that are used by all the classes as well as the 
 * 		setter and getter functions for those variables 
 * 
 * There are also two abstract functions equals() and getType()
 * 		since these are abstract they will be defined in the child classes
 * 	
 */





import java.util.Date;

public abstract class Screen {

	
	// Member Variables
	
	private long id;
	private double salePrice;
	private Date makeDate;     	
	private String manufacturer; 
	private String model; 
	
	
	// Non-Default Constructor
	public Screen (long id, double salePrice, Date makeDate, String manufacturer, String model) { // Check for Date
		this.id = id;
		this.salePrice = salePrice;
		this.makeDate = makeDate;
		this.manufacturer = manufacturer;
		this.model = model;
	}
	
	
	// --------------------------------------------------
	//GETTER FUNCTIONS
	
	public long getId() {
		return id;
	}
	
	public double getSalePrice() {
		return salePrice;
	}
	
	
	public Date getMakeDate()  {
	
		return makeDate;
	}
	
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public String getModel() {
		return model;
	}
	
	//--------------------------------------------------
	

	
	
	
	//--------------------------------------------------
	// SETTER FUNCTIONS 
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	
	
	public void setMakeDate(Date makeDate) {
		this.makeDate = makeDate;
	}
	
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	//--------------------------------------------------
	
	
	
	
	
	
	//--------------------------------------------------
	// ABSTRACT FUNCTIONS 
	
	public abstract String getType(); // To be defined in a class that inherits this Screen class
	public abstract boolean equals(Object temp); // To be defined in a class that inherits this Screen class
	
	//--------------------------------------------------
	
	
	
	
	public String toString() {
		
		return "Screen"; 	
	}
	
	
	
	
	
	
	
} // End of screen class
