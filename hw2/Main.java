// Main driver program

import java.awt.*; 
import javax.swing.*; 

public class Main extends JFrame {
    public static void main (String [] args) {
	java.awt.EventQueue.invokeLater (new Runnable() {
            public void run() {
		new Main ();
            }
        });
    }

    public Main () {
	// Window setup
	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	setSize (300, 300);
	// Put a Canvas in
	JPanel framing = new JPanel (new BorderLayout());
	Canvas canvas = new Canvas();

	JPanel subPanel = new JPanel();

	subPanel.add (new Button ("Add"));
	subPanel.add (new Button ("Delete"));


	framing.add (subPanel, BorderLayout.NORTH);
	framing.add (new ScrollBarHorizontal(), BorderLayout.SOUTH);
	framing.add (new ScrollBarVertical(), BorderLayout.EAST);
	framing.add (new ToggleButton ("Weapons offline"), BorderLayout.WEST);
	framing.add (canvas, BorderLayout.CENTER);

	add(framing);

	// Show the window
	setVisible (true); 
	
    }
}

