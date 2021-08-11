package com.pritjam.hexChess;

import java.awt.*;

public class Tile {
    private int q,r; 
    //axial coordinates - 
    // q axis increases to the right, denoted by letters a-i
    // r axis increases up-left, denoted by numbers 1-9
    private Unit unit;
    public boolean marked;

    private static final Color[] colors = {new Color(1.0F, 1.0F, 1.0F), new Color(0.9F, 0.9F, 0.9F), new Color(0.8F, 0.8F, 0.8F)};

    public Tile(int q, int r) {
        this.q = q;
        this.r = r;
        unit = null;
        marked = false;
    }

    public Polygon getPolygon(int originX, int originY, int radius) {
        int xCenter = (int) (originX + 1.73 * this.q * radius + 1.73 * 0.5 * this.r * radius);
        int yCenter = (int) (originY + 1.5 * this.r * radius);
        Polygon hex = new Polygon();
        for (int i = 0; i < 6; i++) {
            double angle = (double) (2 * i + 1) / 6 * Math.PI;
            double dx = radius * Math.cos(angle);
            double dy = radius * Math.sin(angle);
            hex.addPoint(xCenter + (int) dx, yCenter + (int) dy);
        }
        return hex;
    }

    // private Tile sum(Tile other) {
    //     return new Tile(this.q + other.q, this.r + other.r);
    // }

    private Color getColor() {
        return marked ? Color.CYAN : colors[((this.q - this.r) % 3 + 3) % 3];
    }

    public void setUnit(Unit u) {
        this.unit = u;
    }

    public Unit getUnit() {
        return this.unit;
    }

    public void draw(Graphics g, int originX, int originY, int radius) {
        g.setColor(this.getColor());
        g.fillPolygon(this.getPolygon(originX, originY, radius));
        int centerX = (int) (originX + 1.73 * this.q * radius + 1.73 * 0.5 * this.r * radius);
        int centerY = (int) (originY + 1.5 * this.r * radius);
        if(this.unit != null) {
            this.unit.draw(g, centerX, centerY, 2 * radius / 3);
        }
        if(marked) {
            g.setColor(Color.RED);
            StringBuilder coords = new StringBuilder();
            coords.append((char) ('a' + (q + 4)));
            coords.append((char) ('9' - (r + 4)));
            g.drawString(coords.toString(), centerX, centerY);
        }
    }
}
