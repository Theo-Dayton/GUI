/*
 * Toggle button class, simple toggle button class which takes a string, which
 * is used as its text. The text then changes based off of whether its selected
 * or not. It also prints a message to console when it is pressed
 */

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ToggleButton extends JToggleButton implements ActionListener { 
    public ToggleButton (String label) { 
	setText (label); 
    addActionListener (this);
    }

    public void actionPerformed (ActionEvent e) {
        System.out.println("toggle button was pushed!");
        if (isSelected()) {
            setText("Currently pressed!");
        }
            else {
                setText("Not pressed anymore");
            }
    }

}
