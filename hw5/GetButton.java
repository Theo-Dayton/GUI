import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GetButton extends Button implements ActionListener {
    private ComboBox combo; 
    private ScrollBarHorizontal scroll;
    private Canvas c;

    public GetButton (ComboBox combo, ScrollBarHorizontal scroll, Canvas c) { 
        super(combo,scroll,c);
	    this.combo = combo;
        this.scroll = scroll;
        this.c = c;
        setText ("Add Ship");
        addActionListener (this);
    }

    public void actionPerformed (ActionEvent e) { 
	    c.addShip((String)combo.getSelectedItem(),scroll.getValue());
        c.repaint();
    }
}
