/*
 * Kartik Tyagi 
 * Assignment 4
 * 
 * Inventory Class
 * 
 * This class defines an arrayList that stores the screen objects
 * 
 * It has functions to return arrayLists of the Computer Monitors and SmartTV
 * 
 * It has a function to add an object to the arrayList by first checking if a similar object 
 * 		exists in the list. If it does it will not be added. This method uses the equals() 
 * 		Abstract function that was created in the Screen class but defined in the child classes
 * 
 * There is also a function to print the arrayList. This function prints out all the the data stored in 
 * 		the member variables for each object. If the object is a SmartTV it also prints the OS and if the 
 * 		object is a CRT it also prints Glass Thickness
 * 
 * The date object in the print method uses modifiers that are made for Date objects to find 
 * 		the day, month, and year
 */



import java.util.ArrayList;

public class Inventory {

	private final ArrayList<Screen> listInventory = new ArrayList<Screen>();
	
	// Default Constructor 
	public Inventory() {} 
	
	
	// Returns size of list 
	public int inventoryCount() {
		
		return listInventory.size();
	}
	
	// Add Screen object to list
	public boolean addToInventory(Screen temp) {
		
		
		if(listInventory.contains(temp)) {
			
			System.err.println("The inventory contains a similar Screen object");
			return false;
		}
		else {
			
			return listInventory.add(temp);	
		}
	
	}
	
	public ArrayList<ComputerMonitor> listComputerMonitor(){
		
		ArrayList<ComputerMonitor> listofMonitors = new ArrayList<ComputerMonitor>();
		
		for (Screen item: listInventory) {
			if(item instanceof ComputerMonitor) {
				listofMonitors.add((ComputerMonitor) item);
			}
		}
		
		
		return listofMonitors;
	}
	
	public ArrayList<SmartTV> listSmartTV(){
		
		ArrayList<SmartTV> listofSmartTV = new ArrayList<SmartTV>();
		
		for (Screen item: listInventory) {
			if(item instanceof SmartTV) {
				listofSmartTV.add((SmartTV) item);
			}
		}
		
		
		return listofSmartTV;
	}
	
	public void printInventory() {
		
		System.out.println();
		
		System.out.println("+-------+-------------+-------------+------------+--------------+----------+-------+------------+");
		
		// I didn't put in all in one line so that I could see each one individually 
		System.out.printf("|%5s  |"     , "Type");
		System.out.printf("%7s      |"  , "ID");
		System.out.printf("%10s   |"    , "Price");
		System.out.printf("%10s  |"     , "Make Date");
		System.out.printf("%13s |"      , "Manufactuer");
		System.out.printf("%7s   |"     , "Model");
		System.out.printf("%6s |"       , "Glass");
		System.out.printf("%7s     |%n" , "OS");
		
		for(Screen obj : listInventory) {
			System.out.println("+-------+-------------+-------------+------------+--------------+----------+-------+------------+");
			
			
			System.out.printf("| %-5s |"          , obj.getType());
			System.out.printf(" %-10d  |"         , obj.getId());
			System.out.printf(" $%,-8.2f   |"     , obj.getSalePrice());
			System.out.printf(" %tm/%<td/%<tY |"  , obj.getMakeDate());
			System.out.printf(" %-9s    |"        , obj.getManufacturer());
			System.out.printf(" %-8s |"           , obj.getModel());
			
		
			if(obj instanceof CRT) {
				System.out.printf(" %-5.2f |" , ((CRT) obj).getGlassThickness());
			}
			else {
				System.out.printf(" %-5s |", " " );
			}
			
			if(obj instanceof SmartTV) {
				System.out.printf(" %-10s |%n" , ((SmartTV) obj).getOperatingSystem());
			}
			else {
				System.out.printf(" %-10s |%n", " " );
			}
			
		}
		
		System.out.println("+-------+-------------+-------------+------------+--------------+----------+-------+------------+");
		
		
	}
	
}
