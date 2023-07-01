/*
 * Button class, simple button which prints a message to console when it is
 * pressed
 */

import javax.swing.JButton; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Button extends JButton implements ActionListener{ 
    private Canvas c;
    private int min = 10;
    private int max = 200;

    public Button (String label) {
	    setText (label);
        addActionListener (this);
    }

    public Button (String label, Canvas c) {
        this.c = c;
	    setText (label);
        addActionListener (this);
    }

    public void actionPerformed (ActionEvent e) {
        JButton buttonSource = (JButton) e.getSource();
        // Checks to see which button was pressed
        if (buttonSource.getText() == "Add") {
            // random numbers to add variety to ships
            int x = (int)Math.floor(Math.random()*(max-min+1)+min);
            int y = (int)Math.floor(Math.random()*(max-min+1)+min);
            int width = (int)Math.floor(Math.random()*(200-100+1)+100);
            int length = (int)Math.floor(Math.random()*(100-50+1)+50);
            c.setValues(x, y, width, length);
            c.paintComponent(getGraphics());
            c.repaint();
            
            System.out.println("Ship was added!");
        }
        else {
            System.out.println("Ship was removed");
            c.resetCanvas(getGraphics());
            c.repaint();
        }
    }
}
