package pieces;

import main.Cell;
import main.EnumColor;

import java.net.URL;

public class Pawn extends Piece {


    public Pawn(URL texture, Cell position, Boolean hasMoved, EnumColor color) {
        super(texture, position, hasMoved, color);
    }

    @Override
    public void move() {

    }

    @Override
    public boolean validMove(Cell toPosition) {
        return false;
    }
}
