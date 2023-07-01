// Main driver program

import java.awt.*; 
import javax.swing.*; 

public class Main extends JFrame {
	private Model model;
	private Canvas canvas;
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
	this.model = new Model();
	this.canvas = new Canvas(model);

	for (int i = 0; i <3; i++) {
		this.model.addRandomToList();
	}


	JPanel subPanel = new JPanel();

	subPanel.add (new Button ("Add", this.canvas));
	subPanel.add (new Button ("Delete", this.canvas));

	framing.add (subPanel, BorderLayout.NORTH);
	framing.add (new ScrollBarHorizontal(this.canvas), BorderLayout.SOUTH);
	framing.add (new ScrollBarVertical(this.canvas), BorderLayout.EAST);
	framing.add (new ToggleButton ("Unrotated", this.canvas), BorderLayout.WEST);
	framing.add (this.canvas, BorderLayout.CENTER);

	add(framing);

	// Show the window
	setVisible (true); 
	
    }
}

