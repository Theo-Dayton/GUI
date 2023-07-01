/*
 * ScollBarVertical class, simple vertical scrollbar
 */


import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;


public class ScrollBarVertical extends ScrollBar {
	private int oldValue = 50;

    public ScrollBarVertical (Canvas canvas) { 
		this.c = canvas;
		setOrientation (VERTICAL);
		addAdjustmentListener (this); 
    }

    public void adjustmentValueChanged (AdjustmentEvent event) {
		if (oldValue != getValue()) {
			if (oldValue > getValue()) {
				verticalDecrease();
				c.repaint();
			}
			else {
				verticalIncrease();
				c.repaint();
			}
			oldValue = getValue();
		}
    }

	public void verticalIncrease() {
		c.sety(c.gety()+1);
	}

	public void verticalDecrease() {
		c.sety(c.gety()-1);
	}
}
