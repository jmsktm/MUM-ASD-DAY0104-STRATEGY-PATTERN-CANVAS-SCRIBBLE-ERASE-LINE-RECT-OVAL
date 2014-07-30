/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phase1;

import java.awt.Point;
import java.awt.event.MouseEvent;

/**
 *
 * @author jsingh
 */
public class ScribbleTool implements Tool {

    @Override
    public void mousePressed(MouseEvent e, ScribbleCanvas canvas) {
        System.out.println("SCRIBBLE TOOL: MOUSE PRESSED");
        Point p = e.getPoint();
        canvas.mouseButtonDown = true;
        canvas.x = p.x;
        canvas.y = p.y;
    }

    @Override
    public void mouseReleased(MouseEvent e, ScribbleCanvas canvas) {
        System.out.println("SCRIBBLE TOOL: MOUSE RELEASED");
        canvas.mouseButtonDown = false;
    }

    @Override
    public void mouseDragged(MouseEvent e, ScribbleCanvas canvas) {
        System.out.println("SCRIBBLE TOOL: MOUSE DRAGGED");
        Point p = e.getPoint();
        if (canvas.mouseButtonDown) {
            canvas.getOffScreenGraphics().drawLine(canvas.x, canvas.y, p.x, p.y);
            int xs = Math.min(canvas.x, p.x);
            int ys = Math.min(canvas.y, p.y);
            int dx = Math.abs(p.x - canvas.x) + 1;
            int dy = Math.abs(p.y - canvas.y) + 1;
            canvas.repaint(xs, ys, dx, dy);
            canvas.x = p.x;
            canvas.y = p.y;
        }
    }
}
