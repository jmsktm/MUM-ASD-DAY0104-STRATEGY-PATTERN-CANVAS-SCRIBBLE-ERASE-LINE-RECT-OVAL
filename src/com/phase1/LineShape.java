/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phase1;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author jsingh
 */
public class LineShape implements TwoEndsShape {

    protected Graphics onscreen, offscreen;

    @Override
    public void drawShape(ScribbleCanvas canvas, int xStart, int yStart, Point p) {
        onscreen = canvas.getGraphics();
        offscreen = canvas.getOffScreenGraphics();
        if (canvas.mouseButtonDown) {
            onscreen.drawLine(xStart, yStart, xStart, yStart);
        } else {
            offscreen.drawLine(xStart, yStart, p.x, p.y);
        }
    }

    @Override
    public void drawOutline(ScribbleCanvas canvas, int xStart, int yStart, Point p) {
        onscreen = canvas.getGraphics();
        offscreen = canvas.getOffScreenGraphics();
        
        onscreen.drawLine(xStart, yStart, canvas.x, canvas.y);
        onscreen.drawLine(xStart, yStart, p.x, p.y);
    }
}
