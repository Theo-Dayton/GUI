import java.awt.event.ActionEvent;

public class ButtonDelete extends Button{ 

    public ButtonDelete (String label) {
	    super(label);
    }

    public ButtonDelete (String label, Canvas c) {
        super(label,c);
    }

    public void actionPerformed (ActionEvent e) {
        c.removeShip();
    }
}
