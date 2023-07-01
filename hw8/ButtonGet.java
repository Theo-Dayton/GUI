import java.awt.event.*;

public class ButtonGet extends Button {
    private ComboBox combo; 
    private ScrollBarHorizontal scroll;

    public ButtonGet (ComboBox combo, ScrollBarHorizontal scroll, Canvas c) { 
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
