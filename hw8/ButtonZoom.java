import java.awt.event.ActionEvent;

public class ButtonZoom extends Button{ 
    private String direction;

    public ButtonZoom (String label, String direction) {
	    super(label);
        this.direction = direction;
    }

    public ButtonZoom (String label, Canvas c, String direction) {
        super(label,c);
        this.direction = direction;
    }

    public void actionPerformed (ActionEvent e) {
        c.zoom(direction);
    }
}
