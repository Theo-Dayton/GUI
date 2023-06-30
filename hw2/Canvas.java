/*
 * Canvas class, canvas page to draw on
 */

import java.awt.*;
import javax.swing.*;

public class Canvas extends JPanel {
    // This is the draw callback
    public void paintComponent (Graphics g) { 
	super.paintComponent(g); 
	//g.drawLine (50, 50, 100, 50); 
    }
}
