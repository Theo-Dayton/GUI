/*
 * Toggle button class, simple toggle button class which takes a string, which
 * is used as its text. The text then changes based off of whether its selected
 * or not. It also prints a message to console when it is pressed
 */

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ToggleButton extends JToggleButton implements ActionListener {
    private Canvas c; 

    public ToggleButton (String label, Canvas c) { 
	setText (label); 
    addActionListener (this);
    this.c = c;
    }

    public void actionPerformed (ActionEvent e) {
        if (isSelected()) {
            setText("Rotated");
            System.out.println("Rotated");
            c.toggleRotate();
        }
            else {
                setText("Unrotated");
                System.out.println("Rotated");
                c.toggleRotate();
            }
    }

}
