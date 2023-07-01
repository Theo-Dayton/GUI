import java.awt.event.ActionEvent;

public class ButtonSpeedUp extends Button{ 

    public ButtonSpeedUp (String label) {
	    super(label);
    }

    public ButtonSpeedUp (String label, Canvas c) {
        super(label,c);
    }

    public void actionPerformed (ActionEvent e) {
        System.out.println("Ships were sped up");
        c.speedUp();
    }
}
