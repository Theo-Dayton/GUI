// Main driver program

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener, KeyListener{
	private Model model;
	private Canvas canvas;
	private int frameNumber = 1;
	private int frameSpeed = 2;
	private Timer timer;
	private Button speedUp, slowDown;
	private ScrollBarHorizontal scroll;
	

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
	model = new Model();
	canvas = new Canvas(this, model);

	for (int i = 0; i <1; i++) {
		model.addShip("Battleship", 50);
	}


	JPanel subPanel1 = new JPanel();

	speedUp = new ButtonSpeedUp ("Speed Up", canvas);
	slowDown = new ButtonSlowDown("Slow Down", canvas);

	framing.add (speedUp, BorderLayout.WEST);
	framing.add (slowDown, BorderLayout.EAST);

	ComboBox combo = new ComboBox (canvas);
	subPanel1.add (combo);
	subPanel1.add (new JLabel ("Length"));

	scroll = new ScrollBarHorizontal(canvas);
	subPanel1.add (scroll);

	subPanel1.add (new GetButton(combo, scroll, canvas));

	subPanel1.add (new ButtonClear ("Clear", canvas));

	framing.add (subPanel1, BorderLayout.NORTH);
	framing.add (new ToggleButton ("Click to pause time", canvas), BorderLayout.SOUTH);
	framing.add (this.canvas, BorderLayout.CENTER);

	add(framing);

	// Show the window
	setVisible (true); 
	
    	// Start timer
	this.timer = new Timer (100, this); // 100 milliseconds 
	this.timer.start(); 
    }

    public int getFrameNumber () { return frameNumber; }

	public Timer getTimer () { return timer; } 

    // Like a clock tick
    public void actionPerformed (ActionEvent e) {
		frameNumber += frameSpeed;
		canvas.repaint(); 
    }

	public void frameNumberChange(boolean speed) {
		if (speed) {
			frameSpeed++;
		}
		else {
			frameSpeed--;
		}
	}

	public void disableButtons() {
		if (speedUp.isEnabled()) {
			speedUp.setEnabled(false);
			slowDown.setEnabled(false);
		}
		else {
			speedUp.setEnabled(true);
			slowDown.setEnabled(true);
		}
	}

    // Methods for KeyListener
    public void keyPressed (KeyEvent e) { 
	if (e.getKeyCode()==KeyEvent.VK_ESCAPE) System.exit (0); 
    }
    public void keyReleased (KeyEvent e) { }
    public void keyTyped (KeyEvent e) { }
}

