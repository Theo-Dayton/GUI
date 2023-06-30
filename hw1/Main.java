/*
 * Main class, containing the Main program to open a simple window with widgets
 * Then it lets the Java window take over
 */

import javax.swing.JFrame; 
import java.awt.FlowLayout; 

public class Main extends JFrame { 
    public static void main (String [] args) { 
		new Main (); 
    }
    
    public Main () { 
	// Window setup
	setSize (300, 300); 
	setLayout (new FlowLayout ()); 

	// Add button in
	add (new Button ("Button the 1st"));

	// add another button in
	add (new Button ("Button the 2nd"));

	// Add label
	add (new Label ("Label")); 
	
	// Add toggle button
	add (new ToggleButton ("Toggle Button")); 

	// Add scrollbar
	add (new ScrollBar ()); 

	// Show the window
	setVisible (true); 

    }
}
