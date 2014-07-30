/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phase1;

import java.awt.Point;

/**
 *
 * @author jsingh
 */
public interface TwoEndsShape {
    public void drawShape(ScribbleCanvas canvas, int xStart, int yStart, Point p);
    public void drawOutline(ScribbleCanvas canvas, int xStart, int yStart, Point p);
}
