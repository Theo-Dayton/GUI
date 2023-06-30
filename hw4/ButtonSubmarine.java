/*
 * Button class, simple button which prints a message to console when it is
 * pressed
 */

import javax.swing.JButton; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ButtonSubmarine extends Button implements ActionListener{ 

    public ButtonSubmarine (String label) {
	    super(label);
    }

    public ButtonSubmarine (String label, Canvas c) {
        super(label,c);
    }

    public void actionPerformed (ActionEvent e) {
        c.addShip("Submarine");
        System.out.println("Submarine was added!");
        c.repaint();
    }
}
