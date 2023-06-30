/*
 * Button class, simple button which prints a message to console when it is
 * pressed
 */

import javax.swing.JButton; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Button extends JButton implements ActionListener{ 
    public Button (String label) { 
	setText (label);
    addActionListener (this);
    }

    public void actionPerformed (ActionEvent e) {
        JButton y = (JButton) e.getSource();
        // Checks to see which button was pressed
        if (y.getText() == "Button the 1st") {
            System.out.println("Button the 1st was pushed!");
        }
        else {
            System.out.println("Button the 2nd was pushed!");
        }
    }
}
