package bolls;

import java.awt.*;

/**
 * Created by panasyuk on 20.09.2015.
 */
public class Ball {
    private int x;
    private int y;
    private int v;
    private Color color;

    public Ball(){

    }
    public Ball(int x, int y, int v, Color color){
        this.y = y;
        this.x = x;
        this.v = v;
        this.color = color;

    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
