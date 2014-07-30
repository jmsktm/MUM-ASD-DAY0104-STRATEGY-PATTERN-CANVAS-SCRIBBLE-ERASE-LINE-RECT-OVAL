package com.phase1;

import java.awt.*;
import java.awt.event.*;

public class ScribbleCanvasListener
        implements MouseListener, MouseMotionListener {

    protected Lab1 drawframe;
    protected ScribbleCanvas canvas;
    protected int xStart, yStart, xEnd, yEnd;
    protected Graphics onscreen, offscreen;

    public ScribbleCanvasListener(ScribbleCanvas canvas, Lab1 drawframe) {
        this.canvas = canvas;
        this.drawframe = drawframe;
    }

    public void mousePressed(MouseEvent e) {
        drawframe.currentTool.mousePressed(e, canvas);
    }

    public void mouseReleased(MouseEvent e) {
        drawframe.currentTool.mouseReleased(e, canvas);
    }

    public void mouseDragged(MouseEvent e) {
        drawframe.currentTool.mouseDragged(e, canvas);
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }

}
