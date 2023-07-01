/*
 * ScollBarVertical class, simple vertical scrollbar
 */

import java.awt.event.AdjustmentEvent;


public class ScrollBarVertical extends ScrollBar {

    public ScrollBarVertical (Canvas canvas) { 
		this.c = canvas;
		setOrientation (VERTICAL);
		addAdjustmentListener (this); 
    }

    public void adjustmentValueChanged (AdjustmentEvent event) {
		System.out.println ("Scrollbar: " + getValue()); 
	}
}
