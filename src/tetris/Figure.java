package tetris;

import java.awt.Graphics;

/**
 *
 * @author cw
 */
public abstract class Figure {

    private int x;
    private int y;

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy) {
        System.out.println("called");
        this.y += dy;
        this.x += dx;
    }

    public abstract void draw(Graphics graphics);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    
}
