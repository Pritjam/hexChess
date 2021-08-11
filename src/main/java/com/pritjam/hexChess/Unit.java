package com.pritjam.hexChess;

import java.awt.*;

public class Unit {
    private Rank rank;
    protected Color color;

    public Unit(Rank r, Color c) {
        this.rank = r;
        this.color = c;
    }

    public void draw(Graphics g, int centerX, int centerY, int radius) {
        g.setColor(this.color);
        g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        switch(this.rank) {                
            case PAWN:
                break;
            case BISHOP:
                g.drawString("B", centerX, centerY);
                break;
            case KING:
                g.drawString("K", centerX, centerY);
                break;
            case KNIGHT:
                g.drawString("N", centerX, centerY);
                break;
            case QUEEN:
                g.drawString("Q", centerX, centerY);
                break;
            default:
                break;
        }
        Polygon hex = new Polygon();
        for (int i = 0; i < 6; i++) {
            double angle = (double) i / 3 * Math.PI;
            double dx = radius * Math.cos(angle);
            double dy = radius * Math.sin(angle);
            hex.addPoint(centerX + (int) dx, centerY + (int) dy);
        }
        g.drawPolygon(hex);

    }

    public Rank getRank() {
        return this.rank;
    }

    public boolean validMove(int dq, int dr) {
        switch(this.rank) {
            case PAWN:
                return Math.abs(dq) == 1 && dr == 0;
            case BISHOP:
                return (dr != 0 && dq == 0) || (dr == dq && dq != 0);
            case KING:
                return Math.abs(dq + dr) != 0;
            case KNIGHT:
                return (dq == -1 && dr == -1) ||
                       (dq == 1 && dr == -2) ||
                       (dq == 2 && dr == -1) ||
                       (dq == 1 && dr == 1) ||
                       (dq == -1 && dr == 2) ||
                       (dq == -2 && dr == 1);
            case QUEEN:
                return (dr != 0 && dq == 0) || (dr == dq && dq != 0) || (dq != 0 && dr == 0);
            default:
                return false;
        }
    }

    public String toString() {
        switch(this.rank) {
            case PAWN:
                return "pawn";
            case BISHOP:
                return "bishop";
            case KING:
                return "king";
            case KNIGHT:
                return "knight";
            case QUEEN:
                return "queen";
            default:
                return "other";
        }
    }
}
