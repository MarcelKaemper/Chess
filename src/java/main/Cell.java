package main;

import java.awt.*;

public class Cell {
    private int pos_x;
    private int pos_y;
    private EnumColor color;
    private String coordinate;
    private Shape rect;

    public Cell(int pos_x, int pos_y, EnumColor color, String coordinate, Shape rect) {
        setPos_x(pos_x);
        setPos_y(pos_y);
        setCoordinate(coordinate);
        setColor(color);
        setRect(rect);
    }


    public EnumColor getColor() {
        return color;
    }

    public void setColor(EnumColor color) {
        this.color = color;
    }

    public Shape getRect() {
        return rect;
    }

    public void setRect(Shape rect) {
        this.rect = rect;
    }

    public int getPos_x() {
        return pos_x;
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }
}