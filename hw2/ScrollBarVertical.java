/*
 * ScollBarVertical class, simple vertical scrollbar
 */


import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;

import javax.swing.JScrollBar;

public class ScrollBarVertical extends ScrollBar {

    public ScrollBarVertical () { 
	// Customize properties of our ScrollBar
	// Named static constant
	setOrientation (VERTICAL); 
    }
}
