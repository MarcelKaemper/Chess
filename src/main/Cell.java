package main;

import pieces.Piece;

import java.awt.*;

public class Cell {

    private int pos_x;
    private int pos_y;
    private Piece piece;
    private EnumColor color;
    private char coord_x;
    private int coord_y;
    private String coordinate;
    private Shape rect;

    public Cell(int pos_x, int pos_y, EnumColor color, char coord_x, int coord_y, Shape rect, Piece piece) {
        setPos_x(pos_x);
        setPos_y(pos_y);
        setColor(color);
        setCoord_x(coord_x);
        setCoord_y(coord_y);
        setCoordinate(coord_x + String.valueOf(coord_y));
        setRect(rect);
        setPiece(piece);
    }

    public char getCoord_x() {
        return coord_x;
    }

    public void setCoord_x(char coord_x) {
        this.coord_x = coord_x;
    }

    public int getCoord_y() {
        return coord_y;
    }

    public void setCoord_y(int coord_y) {
        this.coord_y = coord_y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
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