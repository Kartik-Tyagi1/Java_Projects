/*
 * Kartik Tyagi
 * Assignment 5
 * 
 * A5ShapeList class
 * 
 * This class is a container class that holds A5Shape objects. 
 * The point of this is to hold all the Circle objects that we want to serialize
 */



package application;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;


public class A5ShapeList {
	
	@XmlElement(name = "CircleObject")
    private List<A5Shape> A5ShapeList = new ArrayList<>();

    public List<A5Shape> getA5ShapeList() {

        return A5ShapeList;
    }

    
    
}