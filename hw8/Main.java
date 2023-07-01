// Main driver program

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class Main extends JFrame implements ActionListener, KeyListener, ComponentListener{
	private Model model;
	private Canvas canvas;
	
	private int frameNumber = 1;
	private int frameSpeed = 2;
	private Timer timer;
	private Button speedUp, slowDown, addShip, deleteShip, clearAll,zoomIn,zoomOut,zoomReset,play, selectDifficulty;
	private ToggleButton toggle;
	private ComboBox combo, comboDifficulty;
	private JLabel length, score, difficulty;
	private ScrollBarHorizontal scroll;

	private JPanel framing; //main frame
	private JPanel subPanel1; //north panel
	private JPanel subPanel2; // west panel
	private JPanel subPanel3; // east panel
	private JPanel subPanel4; // south difficulty panel

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
	model = new Model();
	canvas = new Canvas(this, model);
	addComponentListener (this); 

	// widgets to select difficult
	difficulty = new JLabel ("Select difficulty:");
	comboDifficulty = new ComboBoxDifficulty();
	selectDifficulty = new ButtonDifficulty(comboDifficulty, canvas);
	subPanel4 = new JPanel();
	subPanel4.add(difficulty);
	subPanel4.add(comboDifficulty);
	subPanel4.add(selectDifficulty);


	// WEST panel
	JPanel subPanel2Layout = new JPanel(new GridBagLayout());
	subPanel2 = new JPanel(new GridLayout(2, 1, 10, 25));

	speedUp = new ButtonSpeedUp ("Speed Up", canvas);
	slowDown = new ButtonSlowDown("Slow Down", canvas);
	subPanel2.add (speedUp);
	subPanel2.add (slowDown);

	subPanel2Layout.add(subPanel2);

	framing.add(subPanel2Layout, BorderLayout.WEST);

	// EAST panel
	JPanel subPanel3Layout = new JPanel(new GridBagLayout());
	subPanel3 = new JPanel(new GridLayout(3, 1, 10, 25));

	zoomIn = new ButtonZoom("Zoom In", canvas, "IN");
	zoomOut = new ButtonZoom("Zoom Out", canvas, "OUT");
	zoomReset = new ButtonZoom("Reset Zoom", canvas, "RESET");
	subPanel3.add(zoomIn);
	subPanel3.add(zoomOut);
	subPanel3.add(zoomReset);
	subPanel3Layout.add(subPanel3);

	framing.add(subPanel3Layout, BorderLayout.EAST);


	// CREATING SUBPANEL FOR NORTH
	subPanel1 = new JPanel();

	play = new ButtonPlay("Play", canvas);
	combo = new ComboBoxShip ();
	scroll = new ScrollBarHorizontal(canvas);
	length = new JLabel ("Length");
	addShip = new ButtonGet(combo, scroll, canvas);
	deleteShip = new ButtonDelete ("Delete ship", canvas);
	clearAll = new ButtonClearAll ("Clear all", canvas);
	score = new JLabel ("Score 0");

	subPanel1.add (play);
	subPanel1.add (combo);
	subPanel1.add (length);
	subPanel1.add (scroll);
	subPanel1.add (addShip);
	subPanel1.add (deleteShip);
	subPanel1.add (clearAll);
	subPanel1.add (score);
	score.setVisible(false);

	framing.add (subPanel1, BorderLayout.NORTH);
	
	//CREATING BUTTON FOR SOUTH
	toggle = new ToggleButton ("Click to pause time", canvas);
	framing.add (toggle, BorderLayout.SOUTH);
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
		frameNumber = frameSpeed;
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
			subPanel2.remove(slowDown);
			subPanel2.remove(speedUp);
			subPanel1.remove (length);
			subPanel1.remove (scroll);
		}
		
		// LARGE = Full layout
		else {
			addPanel();
		}
	
		// May need to force recompute layout
		revalidate();
		repaint();
	}

	public void addPanel() {
		subPanel1.removeAll();
		subPanel1.add (play);
		subPanel1.add (combo);
		subPanel1.add (length);
		subPanel1.add (scroll);
		subPanel1.add (addShip);
		subPanel1.add (deleteShip);
		subPanel1.add (clearAll);
		subPanel1.add (score);

		subPanel2.removeAll();
		subPanel2.add(speedUp);
		subPanel2.add(slowDown);
	}
	
	public void setScore(int gameScore) {
		score.setText("Score: " + gameScore);
	}

	public Dimension getMainSize() {
		return framing.getSize(); 
	}

	public void play() {
		clearAll.setEnabled(!addShip.isEnabled());
		speedUp.setEnabled(!addShip.isEnabled());
		slowDown.setEnabled(!addShip.isEnabled());
		addShip.setEnabled(!addShip.isEnabled());
		score.setVisible(!score.isVisible());
		length.setVisible(!length.isVisible());
		scroll.setVisible(!scroll.isVisible());
		combo.setVisible(!combo.isVisible());
		zoomIn.setEnabled(!zoomIn.isEnabled());
		zoomOut.setEnabled(!zoomOut.isEnabled());
		zoomReset.setEnabled(!zoomReset.isEnabled());
		if (toggle.isShowing()) {
			framing.remove(toggle);
			framing.add(subPanel4, BorderLayout.SOUTH);
		}
		else {
			framing.remove(subPanel4);
			framing.add(toggle, BorderLayout.SOUTH);
		}
	}

	public boolean isPlaying() {
		return score.isVisible();
	}
	

	public void componentHidden(ComponentEvent e) {}
	public void componentMoved(ComponentEvent e) {}
	public void componentShown(ComponentEvent e) {}

}

