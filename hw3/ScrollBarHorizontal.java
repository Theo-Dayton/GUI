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
		if (oldValue != getValue()) {
			if (oldValue > getValue()) {
				horizontalDecrease();
				c.repaint();
			}
			else {
				horizontalIncrease();
				c.repaint();
			}
			oldValue = getValue();
		}
    }

	public void horizontalIncrease() {
		c.setx(c.getx()+1);
	}

	public void horizontalDecrease() {
		c.setx(c.getx()-1);
	}
}
