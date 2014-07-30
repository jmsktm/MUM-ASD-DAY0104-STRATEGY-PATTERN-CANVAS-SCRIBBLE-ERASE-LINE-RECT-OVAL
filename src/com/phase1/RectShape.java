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
public class RectShape implements TwoEndsShape {

    Graphics onscreen, offscreen;

    @Override
    public void drawShape(ScribbleCanvas canvas, int xStart, int yStart, Point p) {
        onscreen = canvas.getGraphics();
        offscreen = canvas.getOffScreenGraphics();
        if (canvas.mouseButtonDown) {
            onscreen.drawRect(xStart, yStart, 1, 1);
        } else {
            offscreen.drawRect(xStart, yStart, p.x - xStart + 1, p.y - yStart + 1);
        }
    }

    @Override
    public void drawOutline(ScribbleCanvas canvas, int xStart, int yStart, Point p) {
        onscreen = canvas.getGraphics();
        offscreen = canvas.getOffScreenGraphics();
        
        onscreen.drawRect(xStart, yStart, canvas.x - xStart + 1, canvas.y - yStart + 1);
        onscreen.drawRect(xStart, yStart, p.x - xStart + 1, p.y - yStart + 1);
    }
}
