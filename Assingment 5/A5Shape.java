/*
 * Kartik Tyagi
 * Assignment 5
 * 
 * A5Shape class
 * 
 * This class is a POJO class that will hold the circle objects created in the paint program 
 */


package application;

public class A5Shape {
	
	private double x;        // X coordinate of circle
	private double y;		 // Y coordinate of circle
	private double radius;	 // Radius of circle
	
	
	// Initialize A5Shape with default values 
	public A5Shape() {
		
	}
	
	// Initialize A5Shape with provided values 
	public A5Shape(double x, double y, double radius) {
		super();
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}

}
