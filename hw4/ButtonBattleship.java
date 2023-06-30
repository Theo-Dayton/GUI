/*
 * Button class, simple button which prints a message to console when it is
 * pressed
 */

import javax.swing.JButton; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ButtonBattleship extends Button implements ActionListener{ 
    public ButtonBattleship (String label) {
	    super(label);
    }

    public ButtonBattleship (String label, Canvas c) {
        super(label,c);
    }

    public void actionPerformed (ActionEvent e) {
        c.addShip("Battleship");
        System.out.println("Battleship was added!");
        c.repaint();
    }
}
