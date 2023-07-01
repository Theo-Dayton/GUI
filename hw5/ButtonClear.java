import javax.swing.JButton; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ButtonClear extends Button implements ActionListener{ 

    public ButtonClear (String label) {
	    super(label);
    }

    public ButtonClear (String label, Canvas c) {
        super(label,c);
    }

    public void actionPerformed (ActionEvent e) {
        System.out.println("Ships were removed");
        c.resetCanvas();
        c.repaint();
    }
}
