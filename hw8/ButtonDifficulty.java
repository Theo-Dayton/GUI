import java.awt.event.*;

public class ButtonDifficulty extends Button {
    private ComboBox combo; 

    public ButtonDifficulty (ComboBox combo, Canvas c) { 
        super(combo,c);
	    this.combo = combo;
        this.c = c;
        setText ("Set difficulty");
        addActionListener (this);
    }

    public void actionPerformed (ActionEvent e) { 
        c.setDifficulty((String)combo.getSelectedItem());
    }
}
