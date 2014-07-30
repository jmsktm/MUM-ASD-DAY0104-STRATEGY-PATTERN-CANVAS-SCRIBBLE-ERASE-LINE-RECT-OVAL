package com.phase1;

import java.awt.event.MouseEvent;

/**
 * @author jsingh
 */
public interface Tool {
    
    public void mousePressed(MouseEvent e, ScribbleCanvas canvas);
    
    public void mouseReleased(MouseEvent e, ScribbleCanvas canvas);
    
    public void mouseDragged(MouseEvent e, ScribbleCanvas canvas);
}
