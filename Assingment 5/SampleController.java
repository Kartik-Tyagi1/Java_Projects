/*
 * Kartik Tyagi
 * Assignment 5
 * 
 * SampleController class
 * 
 * This class provides functionality to the Sample.fxml file. 
 * 
 * The main function is the btnSerializedClicked which serializes the circle objects drawn into an XML file
 */



package application;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import javax.xml.bind.JAXB;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class SampleController {
	
	// Variables for Serialization
	private A5ShapeList a5ShapeList = new A5ShapeList();
	

    // Holds the current selected color
    private Color fillColor = Color.BLACK;

    // holds the current selected radius
    private double radius = 10;
    
    
    // This function populates the arrayList 
    // Did it outside of the serialization for clarity
    public void fillList() {
    	for(int i = 0; i < paneDraw.getChildren().size(); i++) {
			a5ShapeList.getA5ShapeList().add(new A5Shape(
					((Circle) paneDraw.getChildren().get(i)).getCenterX(),
					((Circle) paneDraw.getChildren().get(i)).getCenterY(),
					((Circle) paneDraw.getChildren().get(i)).getRadius()));
		}
    }
    
 
    @FXML
    private RadioButton rbBlack;

    @FXML
    private ToggleGroup togGrpColor;

    @FXML
    private RadioButton rbRed;

    @FXML
    private RadioButton rbGreen;

    @FXML
    private RadioButton rbBlue;

    @FXML
    private RadioButton rbSmall;

    @FXML
    private ToggleGroup togGrpSize;

    @FXML
    private RadioButton rbMedium;

    @FXML
    private RadioButton rbLarge;

    @FXML
    private RadioButton rbCircle;

    @FXML
    private ToggleGroup togGrpShape;

    @FXML
    private RadioButton rbSquare;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnUndo;

    @FXML
    private Button btnSerialize;

    @FXML
    private Pane paneDraw;

    /**
     * clears the drawing area
     * 
     * @param event
     */
    @FXML
    void btnClearClicked(ActionEvent event) {

        paneDraw.getChildren().clear();
    }

    /**
     * undo the last added shape
     * 
     * @param event
     */

    @FXML
    void btnUndo(ActionEvent event) {

        if (!paneDraw.getChildren().isEmpty())
            paneDraw.getChildren().remove(paneDraw.getChildren().size() - 1);
        
    }
    
    @FXML
    void btnSerializedClicked(ActionEvent event) {
  
    	
    	// All information about TextInputDialogs was found at the following URL
    	// https://code.makery.ch/blog/javafx-dialogs-official/
    	
    	TextInputDialog dialog = new TextInputDialog();
    	dialog.setTitle("File Name");
    	dialog.setHeaderText(
    			"File Name Format: \n "
    			+ "\t1. Starts with upper case letter\n"
    			+ "\t2. Followed by two or more letters\n"
    			+ "\t3. Followed by at least one number\n"
    			+ "\t4. Followed by zero or more letters\n"
    			+ "\t5. Ends with .XML"
    			);
    	dialog.setContentText("Enter a file name:");

    	Optional<String> result = dialog.showAndWait();
        	
    	
    	if (result.isPresent()){
    	    String check = result.get();
    	    if(check.matches("[A-Z][a-zA-Z]{2,}\\d+[a-zA-Z]*[.][X][M][L]")){
    	    	
    	    	Path path = Paths.get(check);
    	    	
    	    	try{
    	    		BufferedWriter output = Files.newBufferedWriter(path); 
    	    		
    	    		// Fills the array list with the circle object
    	    	    // Function definition is near the top of the file
    	    		fillList(); 
    	    		
    	    		// Serialize the objects into the file name specified into XML format
        	    	JAXB.marshal(a5ShapeList, output);
        	    	
        	    	// If the text field is filled out and passes the regex then show that it worked
        	    	Alert alert = new Alert(AlertType.INFORMATION);
    	    	    alert.setTitle("Serialization");
    	    	    alert.setContentText("Successfully written all files to " + check);
    	    	    alert.show();
    	    	    
    	    	    // The following loop was used to check if the items were added to the list properly
    	    	    //for(A5Shape item : a5ShapeList.getA5ShapeList()) {
    	    		//	System.out.printf("Circle X_cord: %.3f  Y_cord: %.3f  Radius: %.3f %n", item.getX(), item.getY(), item.getRadius());
    	    		//}
    	    	    
        	    }
        	    catch (IOException e) {
    				e.printStackTrace();
    			} 	    	
    	    } 
    	    else {
    	    	// This alert is if the file name does not match the expression
    	    	Alert alert = new Alert(AlertType.INFORMATION);
    	    	alert.setTitle("Serialization Cancelled");
    	    	alert.setContentText("File serialization cancelled by user or does not match Regex");
    	    	alert.show();
    	    }
    	    	
    	 }
    	 else {
    		 // This alert is if the user presses cancel
    		 Alert alert = new Alert(AlertType.INFORMATION);
	    	 alert.setTitle("Serialization Cancelled");
	    	 alert.setContentText("File serialization cancelled by user or does not match Regex");
	    	 alert.show();
    	}
    	
    	
    }
    	
    
    

    /**
     * Called when mouse is dragged on the drawing panel
     * 
     * @param event
     */
    
 
    
    @FXML
    void drawPaneMouseDrag(MouseEvent event) {
    	
		if(rbCircle.isSelected()) {
    		paneDraw.getChildren().add(new Circle(event.getX(), event.getY(), radius, fillColor));
    		// Add those circles to our list so we can serialize
    		//A5ShapeList.getA5ShapeList().add(new A5Shape(event.getX(), event.getY(), radius));
    		// DO NOT ADD HERE BECUASE THE UNDO AND CLEAR WILL NOT UPDATE HERE
    		
    		
    	}
    	else if(rbSquare.isSelected()) {  		
    		// rectangle does not have a constructor to set everything and the color so we have to set the 
    		// location separately
    		Rectangle square = new Rectangle(radius, radius, fillColor);
			square.setX(event.getX());
			square.setY(event.getY());
    		paneDraw.getChildren().add(square);
    	}
    	else {}
    }
    
    


    @FXML
    void initialize() {

        assert rbBlack != null : "fx:id=\"rbBlack\" was not injected: check your FXML file 'Sample.fxml'.";
        assert togGrpColor != null : "fx:id=\"togGrpColor\" was not injected: check your FXML file 'Sample.fxml'.";
        assert rbRed != null : "fx:id=\"rbRed\" was not injected: check your FXML file 'Sample.fxml'.";
        assert togGrpColor != null : "fx:id=\"groupDrawingColor\" was not injected: check your FXML file 'Sample.fxml'.";
        assert rbGreen != null : "fx:id=\"rbGreen\" was not injected: check your FXML file 'Sample.fxml'.";
        assert rbBlue != null : "fx:id=\"rbBlue\" was not injected: check your FXML file 'Sample.fxml'.";
        assert rbSmall != null : "fx:id=\"rbSmall\" was not injected: check your FXML file 'Sample.fxml'.";
        assert togGrpSize != null : "fx:id=\"togGrpSize\" was not injected: check your FXML file 'Sample.fxml'.";
        assert rbMedium != null : "fx:id=\"rbMedium\" was not injected: check your FXML file 'Sample.fxml'.";
        assert togGrpSize != null : "fx:id=\"groupDrawingColor1\" was not injected: check your FXML file 'Sample.fxml'.";
        assert rbLarge != null : "fx:id=\"rbLarge\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btnUndo != null : "fx:id=\"btnUndo\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Sample.fxml'.";
        assert paneDraw != null : "fx:id=\"paneDraw\" was not injected: check your FXML file 'Sample.fxml'.";

    
           
        
        // change listener for the color toggle group
        togGrpColor.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

                if (rbBlue.isSelected())
                    fillColor = Color.BLUE;
                else if (rbRed.isSelected())
                    fillColor = Color.RED;
                else if (rbGreen.isSelected())
                    fillColor = Color.GREEN;
                else
                    fillColor = Color.BLACK;
            }
        });

        // change listener for the size toggle group
        togGrpSize.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

                if (rbLarge.isSelected()) {
                    radius = 15;               	
                }
                else if (rbMedium.isSelected()) {
                    radius = 10;                	
                }
                else if (rbSmall.isSelected()){
                    radius = 5;                   
                }
            }
        });
        
        // change listener for the shape toggle group 
        //togGrpSize.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
        //	@Override
        //    public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
        //
        //        if (rbCircle.isSelected())
        //            radius = 15;
        //
        //    }
        //});
        
        
        
        
    }
}