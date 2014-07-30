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
public class TwoEndsTool implements Tool {

    private TwoEndsShape twoEndsShape;
    protected int xStart, yStart, xEnd, yEnd;
    protected Graphics onscreen, offscreen;

    public TwoEndsTool(TwoEndsShape twoEndsShape) {
        this.twoEndsShape = twoEndsShape;
    }

    public TwoEndsShape getTwoEndsShape() {
        return twoEndsShape;
    }

    public void setTwoEndsShape(TwoEndsShape twoEndsShape) {
        this.twoEndsShape = twoEndsShape;
    }

    @Override
    public void mousePressed(MouseEvent e, ScribbleCanvas canvas) {
        Point p = e.getPoint();
        canvas.mouseButtonDown = true;
        xStart = canvas.x = p.x;
        yStart = canvas.y = p.y;
        onscreen = canvas.getGraphics();
        onscreen.setXORMode(Color.darkGray);
        onscreen.setColor(Color.lightGray);

        twoEndsShape.drawShape(canvas, xStart, yStart, p);
    }

    @Override
    public void mouseReleased(MouseEvent e, ScribbleCanvas canvas) {
        Point p = e.getPoint();
        canvas.mouseButtonDown = false;
        onscreen = canvas.getGraphics();
        onscreen.setPaintMode();
        offscreen = canvas.getOffScreenGraphics();
        
        twoEndsShape.drawShape(canvas, xStart, yStart, p);
        canvas.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e, ScribbleCanvas canvas) {
        Point p = e.getPoint();
        twoEndsShape.drawShape(canvas, xStart, yStart, p);
        canvas.x = p.x;
        canvas.y = p.y;
    }
}
