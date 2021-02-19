package main;

import pieces.Piece;

import java.awt.*;
import java.util.ArrayList;

public class Cell {

    public static java.util.List<Cell> cells = new ArrayList<>();
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

        cells.add(this);
    }

    public static Cell getCellByCoords(char coord_x, int coord_y) {
        for (Cell cell : cells) {
            if (cell.getCoord_x() == coord_x && cell.getCoord_y() == coord_y) {
                return cell;
            }
        }
        return null;
    }

    public static String getCellCoordinate(int x, int y) {
        for (Cell cell : cells) {
            if (cell.getRect().contains(x, y)) {
                return cell.getCoordinate();
            }
        }
        return "";
    }

    public static Cell getCellByPos(String coordinate) {
        for (Cell cell : cells) {
            if (cell.getCoordinate().equals(coordinate)) {
                return cell;
            }
        }
        return null;
    }

    public static Cell getCell(int x, int y) {
        for (Cell cell : cells) {
            if (cell.getRect().contains(x, y)) {
                return cell;
            }
        }
        return null;
    }

    public static Piece getPieceByPos(String coordinate) {
        for (Cell cell : cells) {
            if (cell.getCoordinate().equals(coordinate)) {
                return cell.getPiece();
            }
        }
        return null;
    }

    public char getCoord_x() {
        return coord_x;
    }

    private void setCoord_x(char coord_x) {
        this.coord_x = coord_x;
    }

    public int getCoord_y() {
        return coord_y;
    }

    private void setCoord_y(int coord_y) {
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

    private void setColor(EnumColor color) {
        this.color = color;
    }

    public Shape getRect() {
        return rect;
    }

    private void setRect(Shape rect) {
        this.rect = rect;
    }

    public int getPos_x() {
        return pos_x;
    }

    private void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    private void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    public String getCoordinate() {
        return coordinate;
    }

    private void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

}