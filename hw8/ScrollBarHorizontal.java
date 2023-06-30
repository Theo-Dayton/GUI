/*
 * ScollBarHorizontal class, simple horizontal scrollbar 
 */


import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;


public class ScrollBarHorizontal extends ScrollBar {
	private int oldValue = 50;

    public ScrollBarHorizontal (Canvas canvas) { 
		this.c = canvas;
		setOrientation (HORIZONTAL);
		addAdjustmentListener (this); 
    }

    public void adjustmentValueChanged (AdjustmentEvent event) {
		System.out.println ("Scrollbar: " + getValue()); 
	}
}
