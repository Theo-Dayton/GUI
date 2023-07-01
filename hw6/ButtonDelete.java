import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ButtonDelete extends Button implements ActionListener{ 

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
