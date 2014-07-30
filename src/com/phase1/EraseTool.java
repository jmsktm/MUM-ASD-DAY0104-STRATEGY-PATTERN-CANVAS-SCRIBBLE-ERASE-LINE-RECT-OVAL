/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phase1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

/**
 *
 * @author jsingh
 */
public class EraseTool implements Tool {
    
    Graphics offscreen;

    @Override
    public void mousePressed(MouseEvent e, ScribbleCanvas canvas) {
        System.out.println("ERASE TOOL: MOUSE PRESSED");
        Point p = e.getPoint();
        canvas.mouseButtonDown = true;
        canvas.x = p.x;
        canvas.y = p.y;
        offscreen = canvas.getOffScreenGraphics();
        offscreen.setColor(Color.white);
    }

    @Override
    public void mouseReleased(MouseEvent e, ScribbleCanvas canvas) {
        System.out.println("ERASE TOOL: MOUSE RELEASED");
        canvas.mouseButtonDown = false;
        canvas.setPenColor(canvas.penColor);
    }

    @Override
    public void mouseDragged(MouseEvent e, ScribbleCanvas canvas) {
        System.out.println("ERASE TOOL: MOUSE DRAGGED");
        Point p = e.getPoint();
        if (canvas.mouseButtonDown) {
            int xs, ys, dx, dy;
            xs = Math.min(canvas.x, p.x) - 2;
            ys = Math.min(canvas.y, p.y) - 2;
            dx = Math.abs(p.x - canvas.x) + 6;
            dy = Math.abs(p.y - canvas.y) + 6;
            offscreen.fillRect(xs, ys, dx, dy);
            canvas.repaint(xs, ys, dx, dy);
            canvas.x = p.x;
            canvas.y = p.y;
        }
    }
}
