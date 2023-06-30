/*
 * Button class, simple button which prints a message to console when it is
 * pressed
 */

import javax.swing.JButton; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ButtonClear extends Button implements ActionListener{ 

    public ButtonClear (String label) {
	    super(label);
    }

    public ButtonClear (String label, Canvas c) {
        super(label,c);
    }

    public void actionPerformed (ActionEvent e) {
        c.resetCanvas();
        System.out.println("Ships were cleared");
        c.repaint();
    }
}
