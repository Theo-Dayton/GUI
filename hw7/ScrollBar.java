/*
 * ScollBar superclass, scrollbar which contains the properties
 * for its subclasses
 */


import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;

import javax.swing.JScrollBar;

abstract public class ScrollBar extends JScrollBar implements AdjustmentListener {
	protected Canvas c;

    public ScrollBar () {
	setMinimum (20); 
	setMaximum (150); 
	// Initial value
	setValue (85); 
	addAdjustmentListener (this); 
    }

	public void adjustmentValueChanged (AdjustmentEvent event) { 
    }
}
