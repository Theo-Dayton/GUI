/*
 * ScollBarHorizontal class, simple horizontal scrollbar 
 */


import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;

import javax.swing.JScrollBar;

public class ScrollBarHorizontal extends ScrollBar {

    public ScrollBarHorizontal () { 
	// Customize properties of our ScrollBar
	// Named static constant
	setOrientation (HORIZONTAL); 
    }
}
