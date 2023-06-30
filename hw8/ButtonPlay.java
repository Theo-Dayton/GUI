import javax.swing.JButton; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ButtonPlay extends Button implements ActionListener{ 

    public ButtonPlay (String label) {
	    super(label);
    }

    public ButtonPlay (String label, Canvas c) {
        super(label,c);
    }

    public void actionPerformed (ActionEvent e) {
        System.out.println("Play button was pressed");
        c.play();
    }
}
