import java.awt.event.ActionEvent;

public class ButtonSlowDown extends Button{ 

    public ButtonSlowDown (String label) {
	    super(label);
    }

    public ButtonSlowDown (String label, Canvas c) {
        super(label,c);
    }

    public void actionPerformed (ActionEvent e) {
        System.out.println("Ships were slowed down");
        c.slowDown();
    }
}
