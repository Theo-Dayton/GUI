import java.awt.event.*;
import javax.swing.*;

abstract class ComboBox extends JComboBox<String> implements ItemListener {

    public ComboBox () {
		addItemListener (this);
    }

    public void itemStateChanged (ItemEvent e) { 
	if (e.getStateChange()==ItemEvent.SELECTED) {
		System.out.println( getSelectedItem() + " was selected");
	}
    }
}
