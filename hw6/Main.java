// Main driver program

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener, KeyListener, ComponentListener{
	private Model model;
	private Canvas canvas;
	
	private int frameNumber = 1;
	private int frameSpeed = 2;
	private Timer timer;
	private Button speedUp, slowDown, addShip, deleteShip, clearAll;
	private ComboBox combo;
	private JLabel length;
	private ScrollBarHorizontal scroll;

	private JPanel framing; //main frame
	private JPanel subPanel1; //north panel

	private static final int SMALL = 400;
	private static final int LARGE = 800;
	

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
	setSize (LARGE, LARGE);
	// Put a Canvas in
	framing = new JPanel (new BorderLayout());
	subPanel1 = new JPanel();
	model = new Model();
	canvas = new Canvas(this, model);
	addComponentListener (this); 

	for (int i = 0; i <1; i++) {
		model.addShip("Battleship", 50, frameNumber);
	}

	// EAST AND WEST BUTTONS
	speedUp = new ButtonSpeedUp ("Speed Up", canvas);
	slowDown = new ButtonSlowDown("Slow Down", canvas);
	framing.add (speedUp, BorderLayout.WEST);
	framing.add (slowDown, BorderLayout.EAST);

	// CREATING SUBPANEL FOR NORTH
	combo = new ComboBox (canvas);
	scroll = new ScrollBarHorizontal(canvas);
	length = new JLabel ("Length");
	addShip = new ButtonGet(combo, scroll, canvas);
	deleteShip = new ButtonDelete ("Delete ship", canvas);
	clearAll = new ButtonClearAll ("Clear all", canvas);

	subPanel1.add (combo);
	subPanel1.add (length);
	subPanel1.add (scroll);
	subPanel1.add (addShip);
	subPanel1.add (deleteShip);
	subPanel1.add (clearAll);

	framing.add (subPanel1, BorderLayout.NORTH);
	
	//CREATING BUTTON FOR SOTUH
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

	/*
     * Listener responds to resize of our whole JFrame
     * If resized, we modify or reassemble the components of our window
     */
    public void componentResized (ComponentEvent e) {
		Dimension size = getSize(); 
	
		if (size.width < SMALL || size.height < SMALL) { 
			framing.remove(slowDown);
			framing.remove(speedUp);
			subPanel1.remove (length);
			subPanel1.remove (scroll);
		}
		
		// LARGE = Full layout
		else {
			framing.add(slowDown, BorderLayout.EAST);
			framing.add(speedUp, BorderLayout.WEST);
			addPanel();
		}
	
		// May need to force recompute layout
		revalidate();
		repaint();
	}

	public void addPanel() {
		subPanel1.removeAll();
		subPanel1.add (combo);
		subPanel1.add (length);
		subPanel1.add (scroll);
		subPanel1.add (addShip);
		subPanel1.add (deleteShip);
		subPanel1.add (clearAll);
	}
	

	public void componentHidden(ComponentEvent e) {}
	public void componentMoved(ComponentEvent e) {}
	public void componentShown(ComponentEvent e) {}

}

