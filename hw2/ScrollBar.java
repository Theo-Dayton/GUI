/*
 * ScollBar superclass, scrollbar which contains the properties
 * for its subclasses
 */


import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;

import javax.swing.JScrollBar;

abstract public class ScrollBar extends JScrollBar implements AdjustmentListener {

    public ScrollBar () { 
	// Customize properties of our ScrollBar
	// Named static constant
	setMinimum (0); 
	setMaximum (100); 
	// Initial value
	setValue (50); 
	addAdjustmentListener (this); 
    }

    public void adjustmentValueChanged (AdjustmentEvent event) { 
	    System.out.println ("New value for Scrollbar = " + getValue()); 
    }
}
