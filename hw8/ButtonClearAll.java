import java.awt.event.ActionEvent;

public class ButtonClearAll extends Button { 

    public ButtonClearAll (String label) {
	    super(label);
    }

    public ButtonClearAll (String label, Canvas c) {
        super(label,c);
    }

    public void actionPerformed (ActionEvent e) {
        c.resetCanvas();
    }
}
