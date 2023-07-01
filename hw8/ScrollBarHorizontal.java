/*
 * ScollBarHorizontal class, simple horizontal scrollbar 
 */

import java.awt.event.AdjustmentEvent;


public class ScrollBarHorizontal extends ScrollBar {
    public ScrollBarHorizontal (Canvas canvas) { 
		this.c = canvas;
		setOrientation (HORIZONTAL);
		addAdjustmentListener (this); 
    }

    public void adjustmentValueChanged (AdjustmentEvent event) {
		System.out.println ("Scrollbar: " + getValue()); 
	}
}
