package tetris;

import java.awt.Graphics;

public class Box extends Figure {

    private int width;
    private int height;

    public Box(int x, int y, int width, int height) {
        super(x, y);
        System.out.println(x);
                System.out.println(y);

        this.height = height;
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void draw(Graphics graphics) {
        System.out.println(super.getX());
        System.out.println(super.getY());
        graphics.fillRect(super.getX(), super.getY(), width, height);
    }

}
